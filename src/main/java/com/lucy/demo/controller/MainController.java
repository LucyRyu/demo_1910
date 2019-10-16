package com.lucy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucy.demo.Service.MemberService;

@RestController
public class MainController {

  @Autowired
  MemberService memberService;
  
  @RequestMapping(value= "/", method=RequestMethod.GET)
  public String Main() {
      return memberService.getUserInfo("rsa");
  }
}
