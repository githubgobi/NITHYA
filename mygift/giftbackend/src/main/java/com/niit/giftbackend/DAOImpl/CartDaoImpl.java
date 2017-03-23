package com.niit.giftbackend.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.niit.giftbackend.dao.CartDao;
import com.niit.giftbackend.model.Cart;

@Repository("cartDao")
@EnableTransactionManagement
@Transactional
public class CartDaoImpl implements CartDao {

	Logger log = LoggerFactory.getLogger(CartDaoImpl.class);

	
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	public void update(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
	}

	public Cart getById(int cartId) {
		String hql = "from Cart where cartId=" + cartId;
		Cart cart = (Cart) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		return cart;
	}

	public Cart getByUserId(int userId) {
		String hql = "from Cart where userId=" + userId;
		Cart cart = (Cart) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		return cart;
	}

}