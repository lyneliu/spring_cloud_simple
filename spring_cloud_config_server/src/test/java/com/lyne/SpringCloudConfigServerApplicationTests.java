package com.lyne;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudConfigServerApplication.class)
public class SpringCloudConfigServerApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void contextLoads() {
		Environment environment = new TestRestTemplate().getForObject("http://localhost:"
				+ port + "/", Environment.class);
		assertFalse(environment.getPropertySources().isEmpty());
		assertEquals("bar",
				environment.getPropertySources().get(0).getSource().get("info.foo"));
	}

}
