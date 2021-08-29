package com.practice.resume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.resume.entity.Topic;
import com.practice.resume.service.TopicService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/topic")
public class TopicMap {
	
	@Autowired
	private TopicService TopicService;
	
	@RequestMapping("/")
	public void init()
	{
		System.out.println("welcome to topics list1");
	}
	
	@GetMapping("/getTopic/{id}")
	@ApiOperation(value = "Find topic by id",
	notes = "provide an id to look up specific topic from topic map",
	response = Topic.class)
	public Topic getTopic(@ApiParam(value = "id for the topic you need to retieve", required = true)@PathVariable String id)
	{
		return TopicService.getTopic(id);
	}
	
    @GetMapping("/getTopics")
    @ApiOperation(value = "Get all topics",
	notes = "Methods to get topic  list",
	response = Topic.class)
	public ResponseEntity<List<Topic>> getTopics()
	{
		//return TopicService.getTopicList();
		return new ResponseEntity<List<Topic>>(TopicService.getTopicList(),HttpStatus.OK);
	}
    
    @PostMapping("/postTopic")
    @ApiOperation(value = "post a new topic",
	notes = "Add a new entry to topic  map")
    public ResponseEntity<String> postTopic(@RequestBody Topic topic) 
    {
    	TopicService.saveTopic(topic);
    	return new ResponseEntity<String>("success",HttpStatus.OK);
    }

}
