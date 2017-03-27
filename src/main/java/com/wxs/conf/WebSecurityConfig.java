package com.wxs.conf;

import com.wxs.security.CustomUserService;
import com.wxs.security.MyPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1

    @Bean
	UserDetailsService customUserService(){ //2
		return new CustomUserService();
	}

	// 自定义验证，实现passwordEncoder接口。
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(new MyPasswordEncoder()); //3
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				       .antMatchers("/static/**","/druid/**","/favicon.ico").permitAll() //设置不阻止的页面
						.anyRequest()
						.authenticated()
						.and()
						.formLogin()
							.loginPage("/login")
							.failureUrl("/login?error")
							.permitAll()
						.and()
						.logout().permitAll();
	}


	/**
	 * 设置用户密码的加密方式为MD5加密
	 * @return
	 */
	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();

	}



}