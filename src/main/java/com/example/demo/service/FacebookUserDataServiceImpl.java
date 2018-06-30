package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FacebookUserDao;
import com.example.demo.model.FacebookUserData;

@Service
@Qualifier("facebookUserData")
public class FacebookUserDataServiceImpl implements FacebookUserDataService {
	
	 @Autowired
	FacebookUserDao fbUserDao;
	
	public List<FacebookUserData> show(){
		List<FacebookUserData> fbUserList = fbUserDao.show();
		return fbUserList;
	}

}
