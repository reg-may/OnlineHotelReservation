package com.hotel.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public abstract class SecuredAction extends Action {
	
    public final ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {

		ActionForward forward = null;
		if (request.getSession().getAttribute("guest") == null) {
			forward = registerExecute(mapping, form, request, response);
		}
		else {
			ActionErrors errors = new ActionErrors();
			errors.add("loggedIn",
			new ActionMessage("error.label.loggedIn"));
			saveErrors(request, errors);
			forward = mapping.findForward("home");
		}
		return forward;
	}

public abstract ActionForward registerExecute(ActionMapping mapping,
                  ActionForm form,
                  HttpServletRequest request,
                  HttpServletResponse response);
}
