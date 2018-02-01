package com.revature.bam.controller;

/**
 * 
 */

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bam.bean.Subtopic;
import com.revature.bam.exception.CustomException;
import com.revature.bam.service.SubtopicService;

@RestController
@RequestMapping(value = "Subtopic/")
public class SubtopicAddController {

  @Autowired
  SubtopicService subserv;

  /**
   * 
   * @param jsonObj
   * @author Samuel Louis-Pierre, Avant Mathur
   * 
   *         REST controller to add existing subtopic to specified batch
   * @throws CustomException
   */

  @RequestMapping(value = "addSubtopic", method = RequestMethod.POST, produces = "application/json")
  public void addSubtopic(@RequestBody String jsonObj) throws CustomException {

    Subtopic st = null;
    try {
      st = new ObjectMapper().readValue(jsonObj, Subtopic.class);
    } catch (IOException e) {
      throw new CustomException(e);
    }

    subserv.updateSubtopic(st);
  }

}