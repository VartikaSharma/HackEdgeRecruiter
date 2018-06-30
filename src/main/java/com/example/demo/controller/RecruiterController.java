package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.FacebookUserDataService;
import com.example.demo.service.WalkInJobDetailService;
import com.example.demo.model.FacebookUserData;
import com.example.demo.model.WalkInJobDetails;

@Controller
public class RecruiterController {
		
	@Qualifier("facebookUserData")
	@Autowired
	FacebookUserDataService fbUserData; 
	
	@Qualifier("WalkInData")
	@Autowired
	WalkInJobDetailService wiJobData;
	
	@RequestMapping("/index")
	public ModelAndView indexCall() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	
	@RequestMapping(value="/jobList", method= RequestMethod.GET)
	public ResponseEntity<List<FacebookUserData>> showJobList() {
		
		List<FacebookUserData> fbDataList= fbUserData.show();	
		return new ResponseEntity<List<FacebookUserData>>(fbDataList, HttpStatus.OK);
			
		
	}
	@RequestMapping(value="/jobDetails", method= RequestMethod.GET)
	public ResponseEntity<List<WalkInJobDetails>> showJobDetails() {
		
		List<WalkInJobDetails> wiJob= wiJobData.show();
		return new ResponseEntity<List<WalkInJobDetails>>(wiJob, HttpStatus.OK);
			
		
	}
	
}