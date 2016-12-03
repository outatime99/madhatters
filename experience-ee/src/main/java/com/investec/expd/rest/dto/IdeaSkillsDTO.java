package com.investec.expd.rest.dto;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Ideaskills;

@XmlRootElement
public class IdeaSkillsDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5959916856262259323L;
	/**
	 * 
	 */
	
	
	private int ideaSkillsId;
	private int ideaId;
	private SkillsDTO skills;
	
	public IdeaSkillsDTO(Ideaskills entity){
		this.setIdeaSkillsId(entity.getIdeaSkillsId());
		this.setIdeaId(entity.getIdea().getIdeaId());
		this.setSkills(new SkillsDTO(entity.getSkills()));
	}
	
	public IdeaSkillsDTO(){
		
	}
	
	/**
	 * @return the ideaSkillsId
	 */
	public int getIdeaSkillsId() {
		return ideaSkillsId;
	}
	/**
	 * @param ideaSkillsId the ideaSkillsId to set
	 */
	public void setIdeaSkillsId(int ideaSkillsId) {
		this.ideaSkillsId = ideaSkillsId;
	}

	/**
	 * @return the ideaId
	 */
	public int getIdeaId() {
		return ideaId;
	}

	/**
	 * @param ideaId the ideaId to set
	 */
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

	/**
	 * @return the skills
	 */
	public SkillsDTO getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(SkillsDTO skills) {
		this.skills = skills;
	}

	
	
}
