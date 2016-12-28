package com.hotel.service;

import com.hotel.domain.Guest;

public interface GuestService extends Service {

	Guest getGuest(Integer id);
	
	Guest save(Guest guest);
	
	void delete(Guest guest);
	
	Guest getGuestByUserName(String userName);
}
