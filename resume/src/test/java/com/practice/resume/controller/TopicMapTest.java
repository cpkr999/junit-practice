package com.practice.resume.controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.resume.entity.Topic;

import io.swagger.annotations.ApiParam;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TopicMapTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private TopicMap TopicMap;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeEach
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void saveTopicTest() throws Exception
	{
		Topic topic = new Topic("1","beginner","c#");
		String jsonRequest = om.writeValueAsString(topic);
		MvcResult result = mockMvc.perform(post("/topic/postTopic").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		//ResponseEntity<String> response = om.readValue(resultContent, ResponseEntity.class);
		Assert.assertTrue(resultContent.contains("success"));
	}
	
	@Test
	public void getTopic() throws Exception
	{
		MvcResult result = mockMvc.perform(get("/topic/getTopic/1").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		int resultContent = result.getResponse().getStatus();
		Assert.assertTrue(resultContent==200);
	}
	
	@Test
	public void getTopicTest() throws Exception
	{
		
		MvcResult result = mockMvc.perform(get("/topic/getTopics").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		int resultContent = result.getResponse().getStatus();
		//Topic response = om.readValue(resultContent, Topic.class);
		//verify(TopicMap,times(1)).getTopics();
		Assert.assertTrue(resultContent==200);
	}
	

}
