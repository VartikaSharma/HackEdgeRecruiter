package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.WalkInJobDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class WalkInJobDetailsDaoImpl implements WalkInJobDetailsDao{
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<WalkInJobDetails> show(){
		
		String sql="select walkInId, location, scheduleTime, scheduleData, documents, jobRole, minsalary, maxsalary, minexp, maxexp, description from WalkInJobDetails";
		RowMapper<WalkInJobDetails> rowMapper = new BeanPropertyRowMapper<WalkInJobDetails>(WalkInJobDetails.class);
		return this.jdbc.query(sql, rowMapper);
			
	}
}
