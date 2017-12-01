package com.apress.isf.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.service.TypeService;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.data.TypeDAO;
import com.apress.isf.spring.service.SecurityServiceFacade;

/**
 * 
 * @author dirkseActive
 * @since 10/18/2017
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	private static String EMAIL = "john@email.com";
	private static String PASSWORD = "doe";
	
	@Autowired
	DocumentDAO mongoDocumentDAO;
	@Autowired
	TypeDAO mongoTypeDAO;
	@Autowired
	TypeService typeService;
	
	@Test
	public void testSecurity(){
		log.debug("Testing security ...");
		assertNotNull(security);
		
		assertTrue(security.areCreditialsValid(EMAIL, PASSWORD));
	}

}