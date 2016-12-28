package com.hotel.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hotel.domain.Guest;
import com.hotel.service.GuestService;
import com.hotel.utils.HibernateUtils;

public class GuestServiceImpl extends ServiceImpl implements GuestService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6587741668505886804L;
	
	private String AUTHENTICATION_QUERY_USERNAME = 
			"from Guest guest where guest.userName = :userName";

	private static GuestServiceImpl guestServiceImpl = new GuestServiceImpl();
	
	private GuestServiceImpl(){		
	}
	
	public static GuestService getInstance(){	
		return guestServiceImpl;
	}
	

	public Guest getGuest(Integer id) {
		Guest guest = null;
		try {
			Session session = HibernateUtils.currentSession();
			guest = (Guest)session.get(Guest.class, id);
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return guest;	
	}
	
	public Guest getGuestByUserName(String userName){
		Guest guest = null;
		Session session = HibernateUtils.currentSession();
		try {
			Query query = session.createQuery(AUTHENTICATION_QUERY_USERNAME);
			query.setString("userName", userName);
			
			@SuppressWarnings("unchecked")
			List<Guest> list = (List<Guest>) query.list();
			
			if (list.size() == 1) {
				guest = (Guest) list.get(0);
			}
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return guest;
	}

	public Guest save(Guest guest) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.saveOrUpdate(guest);
		     tx.commit();
		     rollback = false;
		 }
		 catch (Exception e) {
		     throw new ServiceException(e);
		 }
		 finally {
			 if( rollback && tx != null){ 
		    	 tx.rollback();
			 }			 
			 HibernateUtils.closeSession();
		 }
		return guest;
	}

	public void delete(Guest guest) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.delete(guest);
		     tx.commit();
		     rollback = false;
		 }
		 catch (Exception e) {
		     throw new ServiceException(e);
		 }
		 finally {
			 if( rollback && tx != null){ 
		    	 tx.rollback();
			 }			 
			 HibernateUtils.closeSession();
		 }
	}
}
