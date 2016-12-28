package com.hotel.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.domain.Room;
import com.hotel.domain.RoomType;
import com.hotel.service.RoomService;
import com.hotel.utils.HibernateUtils;

public class RoomServiceImpl extends ServiceImpl implements RoomService {
	
	private static RoomServiceImpl roomServiceImpl = new RoomServiceImpl();
	private static final String ROOMS_BY_ROOMTYPE_QUERY = 
			"from Room room where room.roomType.id = :roomTypeId";
	private RoomServiceImpl(){
		
	}
	
	public static RoomServiceImpl getInstance(){	
		return roomServiceImpl;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1535210485210951402L;

	public Room getRoom(Integer id) {
		Room room = null;
		try {
			Session session = HibernateUtils.currentSession();
			room = (Room)session.get(Room.class, id);
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return room;	
	}

	public Room save(Room room) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.saveOrUpdate(room);
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
		return room;
	}

	public void delete(Room room) {
		// TODO Auto-generated method stub
		
	}

	public List<Room> getRoomsByRoomType(RoomType roomType) {
		List<Room> rooms = null; 
		try {
			Session session = HibernateUtils.currentSession();
			Query query = session.createQuery(ROOMS_BY_ROOMTYPE_QUERY);
			query.setParameter("roomTypeId", roomType.getId());
			rooms = (List<Room>) query.list();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		return rooms;	
		}


}
