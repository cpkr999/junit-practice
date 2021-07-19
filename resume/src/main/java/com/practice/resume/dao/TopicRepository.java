package com.practice.resume.dao;

import org.springframework.data.repository.CrudRepository;

import com.practice.resume.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
