package com.investec.expd.rest.dto;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MappingsDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8060487223081215258L;
	private int mappingsId;
	private IdeaDTO ideaDTO;
	private TasksDTO tasksDTO;
	private UserDTO userDTO;
	/**
	 * @return the mappingsId
	 */
	public int getMappingsId() {
		return mappingsId;
	}
	/**
	 * @param mappingsId the mappingsId to set
	 */
	public void setMappingsId(int mappingsId) {
		this.mappingsId = mappingsId;
	}
	/**
	 * @return the ideaDTO
	 */
	public IdeaDTO getIdeaDTO() {
		return ideaDTO;
	}
	/**
	 * @param ideaDTO the ideaDTO to set
	 */
	public void setIdeaDTO(IdeaDTO ideaDTO) {
		this.ideaDTO = ideaDTO;
	}
	/**
	 * @return the tasksDTO
	 */
	public TasksDTO getTasksDTO() {
		return tasksDTO;
	}
	/**
	 * @param tasksDTO the tasksDTO to set
	 */
	public void setTasksDTO(TasksDTO tasksDTO) {
		this.tasksDTO = tasksDTO;
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
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
}
