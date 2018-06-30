package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WalkInJobDetailsDao;
import com.example.demo.model.WalkInJobDetails;
import java.util.List;

@Service
@Qualifier("WalkInData")

public class WalkInJobDetailServiceImpl implements WalkInJobDetailService{

	@Autowired
	WalkInJobDetailsDao wijob;
	
	public List<WalkInJobDetails> show(){
		
		return wijob.show();
	}
	
}
