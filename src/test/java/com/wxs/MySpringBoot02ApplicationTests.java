package com.wxs;

import com.wxs.model.SysUser;
import com.wxs.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBoot02ApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private SysUserService sysUserService;


	@Test
	public void getinfo(){
		SysUser sysUser = sysUserService.getSysUserByName("wxs");

		System.out.println(sysUser.getRoles());
	}


	/* redis 测试------
	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		stringRedisTemplate.opsForHash().put("abc","sdf","sdf");
		Object o = stringRedisTemplate.opsForHash().get("abc", "sdf");
		System.out.println(o.toString());
	}*/

}
