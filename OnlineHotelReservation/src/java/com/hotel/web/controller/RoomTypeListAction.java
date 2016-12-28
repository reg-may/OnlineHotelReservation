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

import com.hotel.domain.RoomType;
import com.hotel.service.RoomTypeService;
import com.hotel.service.ServiceUtils;
import com.hotel.web.model.RoomTypeListForm;

public class RoomTypeListAction extends Action {
	
	List<RoomType> roomTypeList;
	RoomTypeListForm roomTypeListForm;
	ActionForward forward;
	public RoomTypeListAction(){
		roomTypeList = ServiceUtils.getRoomTypeService().getRoomTypes();
		
	}
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
			forward = new ActionForward();
			roomTypeListForm = (RoomTypeListForm) form;
			System.out.println("Delete: "+roomTypeListForm.getAction());
			if (("Delete").equalsIgnoreCase(roomTypeListForm.getAction())) {
					Integer roomTypeId = roomTypeListForm.getRoomTypeId();
					delete(roomTypeId, request);	
			}
			else if (("deleteRoomTypes").equalsIgnoreCase(roomTypeListForm.getAction())) {
					
					String[] roomTypeIds = roomTypeListForm.getRoomTypeIds();
						
					for (String roomTypeIdString : roomTypeIds) {
						Integer roomTypeId = Integer.parseInt(roomTypeIdString);
						delete(roomTypeId, request);
					}
			}
			
			request.setAttribute("roomTypeList", roomTypeList);
			
			forward = mapping.findForward("roomTypeList");
			 return forward;
		}
		
		public void delete(Integer roomTypeId, HttpServletRequest request) {
			
			RoomTypeService roomTypeService = ServiceUtils.getRoomTypeService();
			boolean deleteSuccessful = false;
			
			if(roomTypeId != null && roomTypeId > 0) {
				RoomType roomType = roomTypeService.getRoomType(roomTypeId);
				if (roomType != null) {
					roomTypeService.delete(roomType);
					
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE,
					           new ActionMessage("message.delete"));
					saveMessages(request, messages);
					deleteSuccessful = true;
				}
			}
			if(!deleteSuccessful) {
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_MESSAGE,
				   new ActionMessage("error.deleted"));
				saveErrors(request, errors);
			}
		}
}
