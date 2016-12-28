package com.hotel.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hotel.domain.Guest;
import com.hotel.domain.impl.GuestImpl;
import com.hotel.service.GuestService;
import com.hotel.service.ServiceUtils;
import com.hotel.web.model.RegisterForm;

public class RegisterAction extends Action{
	
	 public ActionForward execute(ActionMapping mapping,
             ActionForm form,
             HttpServletRequest request,
             HttpServletResponse response) {
		
		RegisterForm registerForm = (RegisterForm) form;
		ActionForward forward = new ActionForward();
		GuestService guestService = ServiceUtils.getGuestService();
		
		//System.out.println("Username: "+guestForAuth.getUserName());
	  if (("save").equals(registerForm.getAction())) {
		  
		 // Guest guestForAuth = guestService.getGuestByUserName(registerForm.getUserName());
		 // System.out.println("UserUsr: "+guestForAuth.getUserName());
          ActionErrors errors = new ActionErrors();
          if (registerForm.getUserName().equals("") || registerForm.getUserName() == null){
              errors.add("key.error.userName", new ActionMessage("error.label.mandatory"));
          }
//          else{
//        	  if(registerForm.getUserName().equals(guestForAuth.getUserName().toString())){
//            	  errors.add("key.error.userNameDuplicate", new ActionMessage("error.label.userNameExist"));
//              }
//          }
          if (registerForm.getPassWord().equals("")  || registerForm.getPassWord() == null) {
              errors.add("key.error.passWord", new ActionMessage("error.label.mandatory"));
          }
          if (registerForm.getEmail().equals("") || registerForm.getEmail() == null) {
              errors.add("key.error.email", new ActionMessage("error.label.mandatory"));
          }
          if (registerForm.getPhoneNo().equals("") || registerForm.getPhoneNo() == null) {
              errors.add("key.error.phoneNo", new ActionMessage("error.label.mandatory"));
          }
          if (registerForm.getFirstName().equals("") || registerForm.getFirstName() == null) {
              errors.add("key.error.firstName", new ActionMessage("error.label.mandatory"));
          }
          if (registerForm.getLastName().equals("") || registerForm.getLastName() == null) {
              errors.add("key.error.lastName", new ActionMessage("error.label.mandatory"));
          }
          else {
              try {
                  Integer phoneNum = Integer.parseInt(registerForm.getPhoneNo());
                  if (phoneNum < 0 && phoneNum > 9) {
                      errors.add("key.error.phoneNo", new ActionMessage("error.label.phoneNo"));
                  }
              }
              catch (NumberFormatException numberFormatException) {
                  errors.add("key.error.phoneNo", new ActionMessage("error.label.numberOnly"));
              }
          }
          if (!errors.isEmpty()) {
              saveErrors(request, errors);
              forward = mapping.getInputForward();
          }
          else {
              
              Guest guest = null;
              Integer registerId = registerForm.getId();
              if (registerId != null && registerId > 0) {
                  guest = guestService.getGuest(registerId);
                  ActionMessages messages = new ActionMessages();
                  messages.add(ActionMessages.GLOBAL_MESSAGE,
                               new ActionMessage("message.lead.update"));
                  saveMessages(request, messages);
              }
              else {
                  guest = new GuestImpl();
      
                  ActionMessages messages = new ActionMessages();
                  messages.add(ActionMessages.GLOBAL_MESSAGE,
                               new ActionMessage("message.lead.insert"));
                  saveMessages(request, messages);
              }
              
              guest.setUserName(registerForm.getUserName());
              guest.setPassWord(registerForm.getPassWord());
              guest.setEmail(registerForm.getEmail());
              guest.setPhoneNo(registerForm.getPhoneNo());
              guest.setFirstName(registerForm.getFirstName());
              guest.setLastName(registerForm.getLastName());
              guest = guestService.save(guest);
             // request.getSession().setAttribute("guest", guest);
              forward = mapping.findForward("login");
          }
      }
      else if (("cancel").equalsIgnoreCase(registerForm.getAction())) {
          forward = mapping.findForward("login");
      }
	  return forward;
	}
}
