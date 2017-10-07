package net.imain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.imain.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.beans.Transient;

@SpringBootApplication
@RestController
public class RedisbootApplication {

	@Autowired
	private RedisClient redisClinet;

	public static void main(String[] args) {
		SpringApplication.run(RedisbootApplication.class, args);
	}

	@RequestMapping("/set")
	public String set(String key, String value) throws Exception{
		redisClinet.set(key, value);
		return "success";
	}

	@RequestMapping("/get")
	public String get(String key) throws Exception {
		return redisClinet.get(key);
	}
}