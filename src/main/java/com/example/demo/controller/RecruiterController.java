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
	
/*	
	@RequestMapping("/create")
	public String createEntry() {
		return "create";
	}
	
	@RequestMapping(value="/messageCreate", method=RequestMethod.POST)
	public ModelAndView createdDisplay(@ModelAttribute User u) {
		
		ModelAndView mav=new ModelAndView();
		String message;
		int rs= us.create(u);
		if(rs==1) {
			message="Created successfully";
		}
		else
			message="Couldn't create";
		
		mav.addObject("string",message);
		mav.setViewName("messageDisplay");
		return mav;
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value="/deleteEntry", method=RequestMethod.POST)
	public ModelAndView deleteEntry(@ModelAttribute User u) {
		ModelAndView mav=new ModelAndView();
		int rs=us.delete(u);
		String m;
		if(rs==1)
			m="Deleted Successfully";
		else
			m="not deleted";
		mav.addObject(m);
		mav.setViewName("messageDisplay");
		return mav;
	}
	*/
}
