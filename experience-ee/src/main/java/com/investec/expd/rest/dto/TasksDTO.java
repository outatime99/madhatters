package com.investec.expd.rest.dto;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Tasks;

@XmlRootElement
public class TasksDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2634148332648793772L;
	private int taskId;
	private int ideaId;
	private String taskName;
	private double percentageComplete;
	private BigDecimal value;
	private Date dueDate;
	
	public TasksDTO(Tasks entity) {
		this.setTaskId(entity.getTaskId());
		this.setDueDate(entity.getDueDate());
		this.setIdeaId(entity.getIdea().getIdeaId());
		this.setTaskName(entity.getTaskName());
		this.setPercentageComplete(entity.getPercentageComplete());
		this.setValue(entity.getValue());
				
	}
	
	public TasksDTO(){
		
	}

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
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
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the percentageComplete
	 */
	public double getPercentageComplete() {
		return percentageComplete;
	}

	/**
	 * @param percentageComplete the percentageComplete to set
	 */
	public void setPercentageComplete(double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
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

}
