package com.hotel.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.hotel.domain.Room;
import com.hotel.domain.RoomType;
import com.hotel.service.RoomService;
import com.hotel.service.ServiceUtils;
import com.hotel.web.model.RoomForm;

public class RoomAction extends Action {
	 List<RoomType> roomTypeList;
	 HttpServletRequest request;
	 
	 public RoomAction(){
		 roomTypeList = ServiceUtils.getRoomTypeService().getRoomTypes();
		 
	 }
		 
	 
	public ActionForward execute(ActionMapping mapping,
             ActionForm form,
             HttpServletRequest request,
             HttpServletResponse response) {
		
		RoomForm roomForm = (RoomForm) form;
		ActionForward forward = null;
		
		request.setAttribute("roomTypeList2", roomTypeList);
		
		System.out.println(roomForm.getAction());
		if (("Save").equalsIgnoreCase(roomForm.getAction())) {
		ActionErrors errors = new ActionErrors();
		if (("Select any Room Type").equals(roomForm.getRoomType())) {
		errors.add("roomType", new ActionMessage("error.label.mandatory"));
		}
		if (roomForm.getName().trim().length() < 1 || roomForm.getName() == null) {
		errors.add("name", new ActionMessage("error.label.mandatory"));
		}
		if (roomForm.getNumber().trim().length() < 1 || roomForm.getNumber() == null) {
		errors.add("number", new ActionMessage("error.label.mandatory"));
		}
		if ("Select any Room Status".equals(roomForm.getStatus())) {
		errors.add("status", new ActionMessage("error.label.mandatory"));
		}
		if ("Select any Smoke Status".equals(roomForm.getSmoke())) {
		errors.add("smoke", new ActionMessage("error.label.mandatory"));
		}
		else {
			try {
				int roomNumber = Integer.parseInt(roomForm.getNumber());
				if (roomNumber < 0) {
				    errors.add("roomNo", new ActionMessage("error.label.greaterThanZero"));
				}
			}
			catch (NumberFormatException numberFormatException) {
				errors.add("price", new ActionMessage("error.label.numberOnly"));
			}
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.getInputForward();
		}
		else {
			Room room = null;
			RoomService roomService = ServiceUtils.getRoomService();
			
			Integer roomId = roomForm.getRoomId();
			
			if (roomId != null && roomId > 0) {
				room = roomService.getRoom(roomId);
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,
				             new ActionMessage("message.update"));
				saveMessages(request, messages);
		}
		else {
				room = new Room();
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE,
				             new ActionMessage("message.insert"));
				saveMessages(request, messages);
			}
			Integer roomTypeId = Integer.parseInt(roomForm.getRoomType());
			System.out.println("Room Type Id: "+roomTypeId);
			RoomType roomType = ServiceUtils.getRoomTypeService().getRoomType(roomTypeId);
			System.out.println("Room Type: "+roomType.getId());
			room.setRoomType(roomType);
			room.setName(roomForm.getName());
			room.setNumber(roomForm.getNumber());
			room.setStatus(roomForm.getStatus());
			room.setSmoke(roomForm.getSmoke());
			room = roomService.save(room);
			forward = mapping.findForward("main");
		}
		}
		else if (("Cancel").equalsIgnoreCase(roomForm.getAction())) {
			forward = mapping.findForward("main");
		}
		else if (("Update").equalsIgnoreCase(roomForm.getAction())) {
			Integer roomId = roomForm.getRoomId();
			Room room = ServiceUtils.getRoomService().getRoom(roomId);
			String id = String.valueOf(ServiceUtils.getRoomTypeService().getRoomType(room.getRoomType().getId()).getId());
			roomForm.setRoomType(id);
			roomForm.setName(room.getName());
			roomForm.setNumber(room.getNumber());
			roomForm.setStatus(room.getStatus());
			roomForm.setSmoke(room.getSmoke());
			roomForm.setRoomId(roomId);
			forward = mapping.getInputForward();
		}
		else if (("Delete").equalsIgnoreCase(roomForm.getAction())) {
			roomForm.setAction(roomForm.getAction());
			roomForm.setRoomId(roomForm.getRoomId());
			forward = mapping.findForward("main");
		}
		else if (roomForm.getRoomId() != null) {
			Room room = ServiceUtils.getRoomService().getRoom(roomForm.getRoomId());
			request.setAttribute("room", room);
			forward = mapping.getInputForward();
		}
		else {
			forward = mapping.getInputForward();
		}
		return forward;
		}
}
