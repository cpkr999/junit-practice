package com.practice.resume.dao;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicRepoTest {

	@Autowired
	private TopicRepo TopicRepo;
	
	@Test
	@Disabled
	public void getTopic(String id)
	{
		

	}
}
