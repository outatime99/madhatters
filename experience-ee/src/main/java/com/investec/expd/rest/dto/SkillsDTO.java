package com.investec.expd.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Skills;

@XmlRootElement
public class SkillsDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642493490845718387L;
	private int skillsId;
	private String name;
	private String description;

	public SkillsDTO(Skills entity){
		this.setSkillsId(entity.getSkillsId());
		this.setDescription(entity.getDescription());
		this.setName(entity.getName());		
	}
	/**
	 * 
	 */
	public SkillsDTO(){
		
	}
	/**
	 * @return the skillsId
	 */
	public int getSkillsId() {
		return skillsId;
	}
	/**
	 * @param skillsId the skillsId to set
	 */
	public void setSkillsId(int skillsId) {
		this.skillsId = skillsId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
}
