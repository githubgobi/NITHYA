package com.niit.mygiftbckend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.niit.mygiftbackend.config.AppContext;
import com.niit.mygiftbackend.dao.ProductDAO;
import com.niit.mygiftbackend.dao.UserDAO;
import com.niit.mygiftbackend.model.Product;
import com.niit.mygiftbackend.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContext.class);
        ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
        UserDAO userDAO=(UserDAO) context.getBean("userDAO");
        
        User user=new User();
        user.setName("sura");
        user.setPassword("sura");
        user.setUsername("sura");
        user.setAddress("ulli");
        
        userDAO.addUser(user);
        
        Product product=new Product();
        product.setName("HTC");
        product.setCategory("lens");
       product.setDescription("abcd");
       product.setPrice(999);
        
        
        productDAO.addProduct(product);
        
        
    }
}