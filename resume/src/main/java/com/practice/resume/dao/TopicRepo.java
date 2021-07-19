package com.practice.resume.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.resume.entity.Topic;

@Repository
public class TopicRepo 
{
      @Autowired
	  private EntityManager EntityManager;
	  
      public Topic getTopic(String id)
  	  {
    	 Session session = EntityManager.unwrap(Session.class);
    	 Topic topic = session.get(Topic.class, id);
  		 return topic;
  	  }
      
      public List<Topic> getTopicList()
  	  {
    	Session session = EntityManager.unwrap(Session.class);
  		Query<Topic> topicList = session.createQuery("from Topic", Topic.class);
  		List<Topic> list = topicList.getResultList();
  		return list;
  	  }
      
      public void saveTopic(Topic topic)
  	  {
    	  Session session = EntityManager.unwrap(Session.class);
    	  session.saveOrUpdate(topic);
  	  }

}
