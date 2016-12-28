package com.hotel.web.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class RoomTypeForm extends BaseForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 295439366312083659L;
	private Integer roomTypeId;
	private String description;
	private Integer maxCapacity;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	 public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request) {
		      ActionErrors errors = new ActionErrors();
		      ActionForward forward = new ActionForward();
		      ActionMessages messages = new ActionMessages();
		      
		        if (description.equals("") || description == null){
		             errors.add("key.error.RoomTypeDescription", new ActionMessage("error.label.mandatory"));
		         }else if(maxCapacity < 0){
		        	  errors.add("key.error.RoomTypeMaxCapacity", new ActionMessage("error.label.mandatory"));
		         }else{
		        	 if (!errors.isEmpty()) {
		        		// saveErrors(request, errors);
		                 forward = mapping.getInputForward();
		                 return errors;
		        	 }
		        }
		        return errors;
	 }
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
}
