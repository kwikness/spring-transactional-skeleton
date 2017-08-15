package com.kyleswebspace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@Configuration //TODO: remove; doesn't seem necessary for some reason but should be for @EnableTransactionManagement
@EnableTransactionManagement
public class TransactionRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void runTransaction() throws Exception {
		//demos to show rollback functionality
		
		jdbcTemplate.execute("delete from some_table where id = 5");
		throwException(); 
		jdbcTemplate.execute("delete from some_table where id = 6");
	}
	
	private void throwException() throws Exception {
		throw new Exception();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
