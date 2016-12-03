package com.investec.expd.model;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mappings generated by hbm2java
 */
@Entity
@Table(name = "mappings")
public class Mappings implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8060487223081215258L;
	private int mappingsId;
	private Idea idea;
	private Tasks tasks;
	private User user;

	public Mappings() {
	}

	public Mappings(int mappingsId, Idea idea, Tasks tasks, User user) {
		this.mappingsId = mappingsId;
		this.idea = idea;
		this.tasks = tasks;
		this.user = user;
	}

	@Id

	@Column(name = "MappingsID", unique = true, nullable = false)
	public int getMappingsId() {
		return this.mappingsId;
	}

	public void setMappingsId(int mappingsId) {
		this.mappingsId = mappingsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdeaID", nullable = false)
	public Idea getIdea() {
		return this.idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TaskID", nullable = false)
	public Tasks getTasks() {
		return this.tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}