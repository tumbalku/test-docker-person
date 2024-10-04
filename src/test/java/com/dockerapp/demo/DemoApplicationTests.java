package com.dockerapp.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void simpleTest(){
		System.out.println("Datasource URL: " + System.getenv("SPRING_DATASOURCE_URL"));

	}
}
