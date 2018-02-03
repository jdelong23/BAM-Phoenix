package com.revature.bam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bam.bean.TopicName;
import com.revature.bam.service.TopicService;

@RestController
@RequestMapping(value = "topic/")
public class TopicController {
  @Autowired
  TopicService topicService;
    
  /**
   * @author Cristian Hermida / Batch 1712-dec10-java-steve
   * @param request
   * 			- I request must have to have the name of the topic.
   * @return HttpStatus
   * 			- status of 201 CREATED if a Topic is created or updated.
   * 			- status of 204 NO_CONTENT is a Topic is not created.
   */
  @PostMapping("add")
  public ResponseEntity<?> addTopicName(HttpServletRequest request) {
    TopicName topic = new TopicName();
    topic.setName(request.getParameter("name"));
    TopicName topicUpdate = topicService.addOrUpdateTopicName(topic);
    if(topicUpdate != null) {
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    else {
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
	  
  }

}
