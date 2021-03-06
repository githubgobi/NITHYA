package com.niit.giftbackend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.giftbackend.dao.ProductDao;
public class TestProductDao {

	
	@Autowired
	ProductDao productDao;

	

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}

	@Test

	public void UserTestCase() {
		int size = productDao.list().size();
		assertEquals("product list test case ", 7 , size);

	}

}
