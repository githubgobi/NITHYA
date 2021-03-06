package com.niit.giftbackend.DAOImpl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.giftbackend.dao.UserOrderDao;
import com.niit.giftbackend.model.UserOrder;

@Repository("userOrderDao")
@Transactional
@EnableTransactionManagement
public class UserOrderDaoImpl implements UserOrderDao {

	Logger log = LoggerFactory.getLogger(UserOrderDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public void add(UserOrder userOrder) {
		sessionFactory.getCurrentSession().saveOrUpdate(userOrder);
	}

	public UserOrder getUserOrderById(int userOrderId) {
		String hql = "from UserOrder where userOrderId=" + userOrderId;
		UserOrder userOrder = (UserOrder) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		return userOrder;
	}
}
