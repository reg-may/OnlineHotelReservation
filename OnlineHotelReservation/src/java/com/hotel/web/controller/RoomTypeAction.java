package com.hotel.web.controller;

import java.util.Enumeration;

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
import com.hotel.domain.impl.RoomTypeImpl;
import com.hotel.service.RoomTypeService;
import com.hotel.service.ServiceUtils;
import com.hotel.web.model.RoomTypeForm;



public class RoomTypeAction extends Action{

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    	
        RoomTypeForm roomTypeForm = (RoomTypeForm) form;
        ActionForward forward = null;
    
//        Enumeration paramaterNames = request.getParameterNames();
//        while(paramaterNames.hasMoreElements() ) {
//               System.out.println("Parameters: "+paramaterNames.nextElement());
//        } 
        
        if (("Save").equals(roomTypeForm.getAction())) {
   
                RoomType roomType = null;
                RoomTypeService roomTypeService = ServiceUtils.getRoomTypeService();
                Integer id = roomTypeForm.getRoomTypeId();
                
                if (id != null && id > 0) {
                	roomTypeForm.setAction("Update");
                    roomType = roomTypeService.getRoomType(id);
                    ActionMessages messages = new ActionMessages();
                    messages.add(ActionMessages.GLOBAL_MESSAGE,
                                 new ActionMessage("message.update"));
                    saveMessages(request, messages);
                }
                else {
                    roomType = new RoomType();
                    ActionMessages messages = new ActionMessages();
                    messages.add(ActionMessages.GLOBAL_MESSAGE,
                                 new ActionMessage("message.insert"));
                    saveMessages(request, messages);
                }
               
                roomType.setDescription(roomTypeForm.getDescription());
                roomType.setMaxCapacity(roomTypeForm.getMaxCapacity());
                roomType = roomTypeService.save(roomType);
                forward = mapping.findForward("roomTypeList");
            
        }
        else if (("Cancel").equalsIgnoreCase(roomTypeForm.getAction())) {
        		forward = mapping.findForward("roomTypeList");
        }
        else if (("Update").equalsIgnoreCase(roomTypeForm.getAction())) {
        	
	            Integer roomTypeId = roomTypeForm.getRoomTypeId();
	            RoomType roomType = ServiceUtils.getRoomTypeService().getRoomType(roomTypeId);
	           
	            roomTypeForm.setDescription(roomType.getDescription());
	            roomTypeForm.setMaxCapacity(roomType.getMaxCapacity());
	            roomTypeForm.setRoomTypeId(roomTypeId);
	            forward = mapping.getInputForward();
        }
        else if (("Delete").equalsIgnoreCase(roomTypeForm.getAction())) {
	            roomTypeForm.setAction(roomTypeForm.getAction());
	            roomTypeForm.setRoomTypeId(roomTypeForm.getRoomTypeId());
	            forward = mapping.findForward("roomTypeList");
        }
  
        else if (roomTypeForm.getRoomTypeId() != null) {
	            RoomType roomType = ServiceUtils.getRoomTypeService().getRoomType(roomTypeForm.getRoomTypeId());
	            request.setAttribute("roomType", roomType);
	            forward = mapping.getInputForward();
        }
        else {
        		forward = mapping.getInputForward();
        }
        return forward;
    }
}
