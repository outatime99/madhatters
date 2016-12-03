package com.investec.expd.rest.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Idea;
import com.investec.expd.model.Ideaskills;
import com.investec.expd.model.Notes;
import com.investec.expd.model.Tasks;
import com.investec.expd.model.User;

@XmlRootElement
public class IdeaDTO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2013948993195317053L;
	private int ideaId;
	private int userID;
	private String ideaName;
	private String description;
	private BigDecimal roi;
	private Date dueDate;
	private String roidescription;
	private Integer votes;
	private Set<IdeaSkillsDTO> ideaskillses = new HashSet<IdeaSkillsDTO>();
	private Set<TasksDTO> taskses = new HashSet<TasksDTO>();
	private Set<NotesDTO> noteses = new HashSet<NotesDTO>();
	
	public IdeaDTO(Idea entity){
		this.setIdeaId(entity.getIdeaId());
		if(entity.getUser()!=null){
			this.setUserID(entity.getUser().getUserId());
		}
		this.setIdeaName(entity.getIdeaName());
		this.setDescription(entity.getDescription());
		this.setRoi(entity.getRoi());
		this.setDueDate(entity.getDueDate());
		this.setRoidescription(entity.getRoidescription());
		this.setVotes(entity.getVotes());
		if(entity.getIdeaskillses()!=null&&!entity.getIdeaskillses().isEmpty()){
			for (Ideaskills ideaSkills : entity.getIdeaskillses()) {
				this.ideaskillses.add(new IdeaSkillsDTO(ideaSkills));
			}
		}
		if(entity.getTaskses()!=null&&!entity.getTaskses().isEmpty()){
			for (Tasks tasks : entity.getTaskses()) {
				this.taskses.add(new TasksDTO(tasks));
			}
		}
		if(entity.getNoteses()!=null&&!entity.getNoteses().isEmpty()){
			for (Notes notes : entity.getNoteses()) {
				this.noteses.add(new NotesDTO(notes));
			}
		}		
	}
	
	public IdeaDTO(){
		
	}
	/**
	 * 
	 * @param entity
	 * @param dto
	 * @param em
	 * @return
	 */
	public Idea fromIdeaDTO(Idea entity,EntityManager em){
		if(entity==null){
			entity=new Idea();
		}
		
		entity.setIdeaId(this.getIdeaId());
		User user=null;
		TypedQuery<User> findByIdQuery = em.createNamedQuery("user.FindByUserID", User.class);
		findByIdQuery.setParameter("userId", this.getUserID());
		
		try
        {
			user = findByIdQuery.getSingleResult();
        }
        catch (javax.persistence.NoResultException nre)
        {
        	user = null;
        }
		
		entity.setUser(user);
		entity.setIdeaName(this.getIdeaName());
		entity.setDescription(this.getDescription());
		entity.setRoi(this.getRoi());
		entity.setDueDate(this.getDueDate());
		entity.setRoidescription(this.getRoidescription());
		entity.setVotes(this.getVotes());
		if(this.getIdeaskillses()!=null&&!this.getIdeaskillses().isEmpty()){
			for (IdeaSkillsDTO ideaSkillsdto : this.getIdeaskillses()) {
				TypedQuery<Ideaskills> findByIdQuerySkill = em.createNamedQuery("ideaskills.FindBySkillID", Ideaskills.class);
				findByIdQuerySkill.setParameter("ideaSkillsId", ideaSkillsdto.getIdeaSkillsId());
				Ideaskills skill=null;
				try
		        {
					skill = findByIdQuerySkill.getSingleResult();
					entity.getIdeaskillses().add(skill);
		        }
		        catch (javax.persistence.NoResultException nre)
		        {
		        	user = null;
		        }
			}
		}
		
		if(!this.getTaskses().isEmpty()){
			for (TasksDTO taskDTO : this.getTaskses()) {
				TypedQuery<Tasks> findByTaskIdQueryTask = em.createNamedQuery("tasks.FindByTaskID", Tasks.class);
				findByTaskIdQueryTask.setParameter("taskId", taskDTO.getTaskId());
				Tasks tasks=null;
				try
		        {
					tasks = findByTaskIdQueryTask.getSingleResult();
					entity.getTaskses().add(tasks);
		        }
		        catch (javax.persistence.NoResultException nre)
		        {
		        	tasks = null;
		        }
			}
		}
		
		if(!this.getNoteses().isEmpty()){
			for (NotesDTO notesDTO : this.getNoteses()) {
				TypedQuery<Notes> findByNotesIdQueryTask = em.createNamedQuery("note.FindByNoteID", Notes.class);
				findByNotesIdQueryTask.setParameter("notesId", notesDTO.getNotesId());
				Notes note=null;
				try
		        {
					note = findByNotesIdQueryTask.getSingleResult();
					entity.getNoteses().add(note);
		        }
		        catch (javax.persistence.NoResultException nre)
		        {
		        	note = null;
		        }
			}
		}
		em.merge(entity);
		return entity;
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
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the ideaName
	 */
	public String getIdeaName() {
		return ideaName;
	}
	/**
	 * @param ideaName the ideaName to set
	 */
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
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
	/**
	 * @return the roi
	 */
	public BigDecimal getRoi() {
		return roi;
	}
	/**
	 * @param roi the roi to set
	 */
	public void setRoi(BigDecimal roi) {
		this.roi = roi;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the roidescription
	 */
	public String getRoidescription() {
		return roidescription;
	}
	/**
	 * @param roidescription the roidescription to set
	 */
	public void setRoidescription(String roidescription) {
		this.roidescription = roidescription;
	}
	/**
	 * @return the votes
	 */
	public Integer getVotes() {
		return votes;
	}
	/**
	 * @param votes the votes to set
	 */
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	/**
	 * @return the ideaskillses
	 */
	public Set<IdeaSkillsDTO> getIdeaskillses() {
		return ideaskillses;
	}
	/**
	 * @param ideaskillses the ideaskillses to set
	 */
	public void setIdeaskillses(Set<IdeaSkillsDTO> ideaskillses) {
		this.ideaskillses = ideaskillses;
	}
	/**
	 * @return the taskses
	 */
	public Set<TasksDTO> getTaskses() {
		return taskses;
	}
	/**
	 * @param taskses the taskses to set
	 */
	public void setTaskses(Set<TasksDTO> taskses) {
		this.taskses = taskses;
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
	
	

}
