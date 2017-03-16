package com.wxs.RedisDao;

import com.wxs.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by wuxusen on 2017/3/16.
 */

@Repository
public class PersonDao {

    /**
     *  在set 或 get 数据时，应使用同一个template
     */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public void setRedis(){
        stringRedisTemplate.opsForValue().set("name","wang5");
    }

    public void save(Person person){
        redisTemplate.opsForValue().set(person.getId(),person);
    }

    public Object getStr(){
        return  stringRedisTemplate.opsForValue().get("name");
    }

    public Person getPerson(){
       return (Person) redisTemplate.opsForValue().get("1");
    }


}
