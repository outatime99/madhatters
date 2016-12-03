package com.investec.expd.rest.dto;

public class UserskillsDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5264415101884925025L;
	/**
	 * 
	 */
	
	private int userSkillsId;
	private SkillsDTO skillsDTO;
	private UserDTO userDTO;
	/**
	 * @return the userSkillsId
	 */
	public int getUserSkillsId() {
		return userSkillsId;
	}
	/**
	 * @param userSkillsId the userSkillsId to set
	 */
	public void setUserSkillsId(int userSkillsId) {
		this.userSkillsId = userSkillsId;
	}
	/**
	 * @return the skillsDTO
	 */
	public SkillsDTO getSkillsDTO() {
		return skillsDTO;
	}
	/**
	 * @param skillsDTO the skillsDTO to set
	 */
	public void setSkillsDTO(SkillsDTO skillsDTO) {
		this.skillsDTO = skillsDTO;
	}
	/**
	 * @return the userDTO
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}
	/**
	 * @param userDTO the userDTO to set
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	

}
