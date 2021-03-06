package com.apress.isf.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.DocumentService;
import com.apress.isf.java.service.TypeService;
import com.apress.isf.spring.data.DocumentDAO;
import com.apress.isf.spring.data.TypeDAO;

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
	DocumentService documentFacade;
	@Autowired
	TypeService typeFacade;
	
	@Test
	public void testMongoDBMigration(){
		log.debug("Testing Spring Data MongoDB - Migration (Run only once)...");
		assertNotNull(mongoDocumentDAO);
		assertNotNull(documentFacade);
		assertNotNull(typeFacade);
		assertNotNull(mongoTypeDAO);
		
		List<Type> types = typeFacade.getAllDefinedTypes();
		assertNotNull(types);
		assertEquals(4, types.size());
		
		for(Type type: types){
			mongoTypeDAO.save(type);
		}
		
		List<Document> documents = documentFacade.getAllDocuments();
		assertNotNull(documents);
		assertEquals(6, documents.size());
		
		for(Document document : documents){
			mongoDocumentDAO.save(document.getDocumentId(), document);
		}

	}

}
