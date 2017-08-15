package com.kyleswebspace.launch;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyleswebspace.TransactionRunner;;

public class Launcher {
	
	private static Logger logger = Logger.getLogger(Launcher.class);
	
	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml")) {
			
			TransactionRunner test = context.getBean(TransactionRunner.class);
			test.runTransaction();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
