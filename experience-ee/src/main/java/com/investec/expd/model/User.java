package com.investec.expd.model;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "[user]")
@NamedQueries({ 
	@NamedQuery(name = "user.FindAll", query = "select u from User u"),
	@NamedQuery(name = "user.FindByUserID", query = "select u from User u where u.userId=:userId"),
	})
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5417140424440074479L;
	private int userId;
	private Businessunit businessunit;
	private String name;
	private String surname;
	private Date dateofBirth;
	private Date joiningDate;
	private String userName;
	private String password;
	private String EMail;
	private Set<Idea> ideas = new HashSet<Idea>(0);
	private Set<Notes> noteses = new HashSet<Notes>(0);
	private Set<Mappings> mappingses = new HashSet<Mappings>(0);
	private Set<Userskills> userskillses = new HashSet<Userskills>(0);

	public User() {
	}

	public User(int userId, Businessunit businessunit, String name, String surname) {
		this.userId = userId;
		this.businessunit = businessunit;
		this.name = name;
		this.surname = surname;
	}

	public User(int userId, Businessunit businessunit, String name, String surname, Date dateofBirth, Date joiningDate,
			String userName, String password, String EMail, Set<Idea> ideas, Set<Notes> noteses,
			Set<Mappings> mappingses, Set<Userskills> userskillses) {
		this.userId = userId;
		this.businessunit = businessunit;
		this.name = name;
		this.surname = surname;
		this.dateofBirth = dateofBirth;
		this.joiningDate = joiningDate;
		this.userName = userName;
		this.password = password;
		this.EMail = EMail;
		this.ideas = ideas;
		this.noteses = noteses;
		this.mappingses = mappingses;
		this.userskillses = userskillses;
	}

	@Id

	@Column(name = "UserID", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUID", nullable = false)
	public Businessunit getBusinessunit() {
		return this.businessunit;
	}

	public void setBusinessunit(Businessunit businessunit) {
		this.businessunit = businessunit;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Surname", nullable = false, length = 50)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateofBirth", length = 19)
	public Date getDateofBirth() {
		return this.dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JoiningDate", length = 19)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Column(name = "UserName", length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "[E-mail]", length = 100)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Idea> getIdeas() {
		return this.ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Notes> getNoteses() {
		return this.noteses;
	}

	public void setNoteses(Set<Notes> noteses) {
		this.noteses = noteses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Mappings> getMappingses() {
		return this.mappingses;
	}

	public void setMappingses(Set<Mappings> mappingses) {
		this.mappingses = mappingses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Userskills> getUserskillses() {
		return this.userskillses;
	}

	public void setUserskillses(Set<Userskills> userskillses) {
		this.userskillses = userskillses;
	}

}
