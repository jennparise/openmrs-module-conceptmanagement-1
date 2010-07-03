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
package org.openmrs.module.conceptmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;

/**
 * ConceptSearch Class to keep of searches by the user isSet values: -1 Don't care 0 false 1 true
 */
public class ConceptSearch {
	
	private String searchQuery;
	
	private List<String> searchTerms;
	
	private List<ConceptDatatype> dataTypes;
	
	private List<ConceptClass> conceptClasses;
	
	private List<String> conceptUsedAs;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	private int isSet;
	
	private SimpleDateFormat df;
	
	/**
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		return df.format(this.dateFrom);
	}
	
	/**
	 * @return the dateFrom as date
	 */
	public Date getDateFromAsDate() {
		return this.dateFrom;
	}
	
	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	/**
	 * @return the dateTo
	 */
	public String getDateTo() {
		return df.format(this.dateTo);
	}
	
	/**
	 * @return the dateTo as date
	 */
	public Date getDateToAsDate() {
		return this.dateTo;
	}
	
	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * @return the conceptUsedAs
	 */
	public List<String> getConceptUsedAs() {
		return conceptUsedAs;
	}
	
	/**
	 * @param conceptUsedAs the conceptUsedAs to set
	 */
	public void setConceptUsedAs(List<String> conceptUsedAs) {
		this.conceptUsedAs = conceptUsedAs;
	}
	
	/**
	 * @return the isSet
	 */
	public int getIsSet() {
		return isSet;
	}
	
	/**
	 * @param isSet the isSet to set
	 */
	public void setIsSet(int isSet) {
		this.isSet = isSet;
	}
	
	/**
	 * @param searchQuery
	 */
	public ConceptSearch(String searchQuery) {
		df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy");
		this.searchQuery = searchQuery;
	}
	
	/**
	 * @return the searchQuery
	 */
	public String getSearchQuery() {
		return searchQuery;
	}
	
	/**
	 * @param searchQuery the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	
	/**
	 * @return the searchTerms as List
	 */
	public List<String> getSearchTermsList() {
		/*String ret = "";
		for (String s : searchTerms)
			ret += s + " ";
		return ret.trim();*/
		return searchTerms;
	}
	
	/**
	 * @return the searchTerms
	 */
	public String getSearchTerms() {
		String ret = "";
		for (String s : searchTerms)
			ret += s + " ";
		return ret.trim();
	}
	
	/**
	 * @param searchTerms the searchTerms to set
	 */
	public void setSearchTerms(List<String> searchTerms) {
		this.searchTerms = searchTerms;
	}
	
	/**
	 * @return the dataTypes
	 */
	public List<ConceptDatatype> getDataTypes() {
		return dataTypes;
	}
	
	/**
	 * @param dataTypes the dataTypes to set
	 */
	public void setDataTypes(List<ConceptDatatype> dataTypes) {
		this.dataTypes = dataTypes;
	}
	
	/**
	 * @return the conceptClasses
	 */
	public List<ConceptClass> getConceptClasses() {
		return conceptClasses;
	}
	
	/**
	 * @param conceptClasses the conceptClasses to set
	 */
	public void setConceptClasses(List<ConceptClass> conceptClasses) {
		this.conceptClasses = conceptClasses;
	}
	
}
