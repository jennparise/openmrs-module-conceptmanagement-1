/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.conceptmanagement.web.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.api.context.Context;
import org.openmrs.module.conceptmanagement.ConceptSearch;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * This controller backs the /web/module/basicmoduleForm.jsp page. This controller is tied to that
 * jsp page in the /metadata/moduleApplicationContext.xml file
 */
public class BasicSearchFormController extends SimpleFormController {
	
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Returns any extra data in a key-->value pair kind of way
	 * 
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest,
	 *      java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request, Object obj, Errors err) throws Exception {
		
		// this method doesn't return any extra data right now, just an empty map
		return new HashMap<String, Object>();
	}
	
	/**
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object object,
	                                BindException exceptions) throws Exception {
		
		if (!Context.isAuthenticated()) {
			return new ModelAndView(getFormView());
		}
		
		ModelAndView mav = new ModelAndView(getSuccessView());
		HttpSession session = request.getSession();
		
		Collection<Concept> rslt = new Vector<Concept>();
		ConceptSearch cs = new ConceptSearch("");
		
		String searchWord = (String) request.getParameter("conceptQuery");
		
		if ((searchWord == null) || (searchWord.isEmpty())) {
			return new ModelAndView(getFormView());
		}
		
		//moved to formBackingObject
		/*try {
			cs = (ConceptSearch) session.getAttribute("conceptSearch");
		}
		catch (ClassCastException ex) {
			System.out.println("del attrib");
			session.removeAttribute("conceptSearch");
		}*/

		if (session.getAttribute("conceptSearch") != null) {
			cs = (ConceptSearch) session.getAttribute("conceptSearch");
		} else {
			session.setAttribute("conceptSearch", cs);
		}
		
		cs.setSearchQuery(searchWord);
		rslt = Context.getConceptService().getConceptsByName(searchWord);
		
		mav.addObject("searchResult", rslt);
		
		return mav;
	}
	
	/**
	 * This class returns the form backing object. This can be a string, a boolean, or a normal java
	 * pojo. The type can be set in the /config/moduleApplicationContext.xml file or it can be just
	 * defined by the return type of this method
	 * 
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		try {
			ConceptSearch cs = (ConceptSearch) session.getAttribute("conceptSearch");
		}
		catch (ClassCastException ex) {
			session.removeAttribute("conceptSearch");
		}
		
		return "";
	}
}
