package com.hotel.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.domain.RoomType;
import com.hotel.service.RoomTypeService;
import com.hotel.utils.HibernateUtils;


public class RoomTypeServiceImpl extends ServiceImpl implements RoomTypeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -29381699720490889L;
	private static final String ROOMTYPE_ALL = "from RoomType";
	private static RoomTypeServiceImpl roomTypeServiceImpl = new RoomTypeServiceImpl();
	
	private RoomTypeServiceImpl(){		
	
	}
	
	public static RoomTypeService getInstance(){	
		return roomTypeServiceImpl;
	}
	
	public RoomType getRoomType(Integer id) {
		RoomType roomType = null;
		try {
			Session session = HibernateUtils.currentSession();
			roomType = (RoomType)session.get(RoomType.class, id);
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return roomType;
	}

	public RoomType save(RoomType roomType) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.saveOrUpdate(roomType);
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
		return roomType;
	}

	public void delete(RoomType roomType) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.delete(roomType);
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

	public List<RoomType> getRoomTypes() {
		List<RoomType> roomTypes = null; 
		try {
			Session session = HibernateUtils.currentSession();
			Query query = session.createQuery(ROOMTYPE_ALL);
			roomTypes = (List<RoomType>) query.list();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return roomTypes;
	}

}
