/**
 * 
 */
package com.investec.expd.expd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author gregf
 *
 */
public class Idea {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("idea_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idea_id", unique = true, nullable = false)
	private int ideaId;
	
	@JsonProperty("idea_name")
	@Column(name = "idea_name", unique = true, nullable = false, length = 100)
	private String ideaName;
	
	@JsonProperty("idea_description")
	@Column(name = "idea_description", unique = true, nullable = false, length = 100)
	private String ideaDescription;
	
	@JsonProperty("idea_bu")
	@Column(name = "idea_bu", unique = true, nullable = false, length = 100)
	private String ideaBusinessUnit;	
	
	@JsonProperty("idea_roi")
	@Column(name = "idea_roi", unique = true, nullable = false, length = 100)
	private String ideaRoi;
	
	@JsonProperty("idea_dueDate")
	@Column(name = "idea_dueDate", unique = true, nullable = false, length = 100)
	private String ideaDueDate;

	public int getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaBusinessUnit() {
		return ideaBusinessUnit;
	}

	public void setIdeaBusinessUnit(String ideaBusinessUnit) {
		this.ideaBusinessUnit = ideaBusinessUnit;
	}

	public String getIdeaRoi() {
		return ideaRoi;
	}

	public void setIdeaRoi(String ideaRoi) {
		this.ideaRoi = ideaRoi;
	}

	public String getIdeaDueDate() {
		return ideaDueDate;
	}

	public void setIdeaDueDate(String ideaDueDate) {
		this.ideaDueDate = ideaDueDate;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public String getIdeaDescription() {
		return ideaDescription;
	}

	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}
	
}
