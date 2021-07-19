package com.practice.resume.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.resume.dao.TopicRepo;
import com.practice.resume.entity.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepo TopicRepo;
	
	@Transactional
	public List<Topic> getTopicList()
	{
		
		return TopicRepo.getTopicList();
	}
	
	@Transactional
	public Topic getTopic(String id)
	{
		
		return TopicRepo.getTopic(id);
	}
	
	@Transactional
	public void saveTopic(Topic topic)
	{
		TopicRepo.saveTopic(topic);
	}
	
}
