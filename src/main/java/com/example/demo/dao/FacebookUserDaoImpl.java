package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FacebookUserData;

@Repository
public class FacebookUserDaoImpl implements FacebookUserDao{
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public List<FacebookUserData> show(){
		
		String sql="select id, walkInId, fbUserName, fbEmailId, Interest from FacebookUserData";
		RowMapper<FacebookUserData> rowMapper = new BeanPropertyRowMapper<FacebookUserData>(FacebookUserData.class);
		return this.jdbc.query(sql, rowMapper);
			
	}
}
