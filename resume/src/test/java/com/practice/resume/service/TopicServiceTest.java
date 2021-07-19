package com.practice.resume.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.resume.dao.TopicRepo;
import com.practice.resume.entity.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

	@Autowired
	private TopicService TopicService;
	@MockBean
	private TopicRepo TopicRepo;
	
	@Test
	public void shouldGetTopicList()
	{
		when(TopicRepo.getTopicList()).thenReturn(Stream.of(new Topic("1","beginner","C# course")).collect(Collectors.toList()));
		assertEquals(1,TopicRepo.getTopicList().size());
		
		TopicService.getTopicList();
		verify(TopicRepo,times(2)).getTopicList();
	}
	
	@Test
	public void getTopic()
	{
		String id = "2";
		when(TopicRepo.getTopic(id)).thenReturn(new Topic("1","beginner","C# course"));
		
		Topic topic = TopicService.getTopic(id);
		assertEquals("1",topic.getId());
		
		TopicService.getTopic(id);
		verify(TopicRepo,times(2)).getTopic(id);
	}
	
	@Test
	public void saveTopic()
	{
		Topic topic = new Topic("1","beginner","C# course");
		TopicService.saveTopic(topic);
		verify(TopicRepo,times(1)).saveTopic(topic);
	}
}
