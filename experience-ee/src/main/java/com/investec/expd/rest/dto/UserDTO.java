package com.investec.expd.rest.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.investec.expd.model.Idea;
import com.investec.expd.model.Notes;
import com.investec.expd.model.User;

@XmlRootElement
public class UserDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5417140424440074479L;
	private int userId;
	private BusinessunitDTO businessunit;
	private String name;
	private String surname;
	private Date dateofBirth;
	private Date joiningDate;
	private String userName;
	private String password;
	private String EMail;
	private Set<IdeaDTO> ideas = new HashSet<IdeaDTO>();
	private Set<NotesDTO> noteses = new HashSet<NotesDTO>();
	private Set<MappingsDTO> mappingses = new HashSet<MappingsDTO>();
	private Set<UserskillsDTO> userskillses = new HashSet<UserskillsDTO>();

	public UserDTO(User entity) {
		this.setUserId(entity.getUserId());
		if(entity.getBusinessunit()!=null){
			this.setBusinessunit(new BusinessunitDTO(entity.getBusinessunit()));
		}
		
		this.setName(entity.getName());
		this.setSurname(entity.getSurname());
		this.setDateofBirth(entity.getDateofBirth());
		this.setJoiningDate(entity.getJoiningDate());
		this.setUserName(entity.getUserName());
		this.setPassword(entity.getPassword());
		this.setEMail(entity.getEMail());
				
		if(entity.getIdeas()!=null&&!entity.getIdeas().isEmpty()){
			for (Idea idea : entity.getIdeas()) {
				ideas.add(new IdeaDTO(idea));
			}			
		}
		
		if(entity.getNoteses()!=null&&!entity.getNoteses().isEmpty()){
			for (Notes note : entity.getNoteses()) {
				noteses.add(new NotesDTO(note));
			}
		}		
	}
	
	public User fromUserDTO(User entity,UserDTO dto) {
		entity.setUserId(dto.getUserId());
		//entity.setBusinessunit(dto.getBusinessunit());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setDateofBirth(dto.getDateofBirth());
		entity.setJoiningDate(dto.getJoiningDate());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setEMail(dto.getEMail());
		
		//todo:dddd
		//this.setIdeas(entity.getIdeas());
		//this.setNoteses(user.get);
		
		return entity;
	}
	
	public UserDTO(){
		
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the businessunitDTO
	 */
	public BusinessunitDTO getBusinessunit() {
		return businessunit;
	}

	/**
	 * @param businessunitDTO the businessunitDTO to set
	 */
	public void setBusinessunit(BusinessunitDTO businessunitDTO) {
		this.businessunit = businessunitDTO;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the dateofBirth
	 */
	public Date getDateofBirth() {
		return dateofBirth;
	}

	/**
	 * @param dateofBirth the dateofBirth to set
	 */
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the eMail
	 */
	public String getEMail() {
		return EMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void setEMail(String eMail) {
		EMail = eMail;
	}

	/**
	 * @return the ideas
	 */
	@JsonIgnore
	public Set<IdeaDTO> getIdeas() {
		return ideas;
	}

	/**
	 * @param ideas the ideas to set
	 */
	public void setIdeas(Set<IdeaDTO> ideas) {
		this.ideas = ideas;
	}

	/**
	 * @return the noteses
	 */
	public Set<NotesDTO> getNoteses() {
		return noteses;
	}

	/**
	 * @param noteses the noteses to set
	 */
	public void setNoteses(Set<NotesDTO> noteses) {
		this.noteses = noteses;
	}

	/**
	 * @return the mappingsesDTO
	 */
	@JsonIgnore
	public Set<MappingsDTO> getMappingses() {
		return mappingses;
	}

	/**
	 * @param mappingsesDTO the mappingsesDTO to set
	 */
	public void setMappingses(Set<MappingsDTO> mappingsesDTO) {
		this.mappingses = mappingsesDTO;
	}

	/**
	 * @return the userskillsesDTO
	 */
	public Set<UserskillsDTO> getUserskillses() {
		return userskillses;
	}

	/**
	 * @param userskillsesDTO the userskillsesDTO to set
	 */
	public void setUserskillses(Set<UserskillsDTO> userskillsesDTO) {
		this.userskillses = userskillsesDTO;
	}

			
}
