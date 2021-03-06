package com.investec.expd.model;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Businessunit generated by hbm2java
 */
@Entity
@Table(name = "businessunit")
public class Businessunit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4388696025685104457L;
	private int buid;
	private String buname;
	private Set<User> users = new HashSet<User>(0);

	public Businessunit() {
	}

	public Businessunit(int buid, String buname) {
		this.buid = buid;
		this.buname = buname;
	}

	public Businessunit(int buid, String buname, Set<User> users) {
		this.buid = buid;
		this.buname = buname;
		this.users = users;
	}

	@Id

	@Column(name = "BUID", unique = true, nullable = false)
	public int getBuid() {
		return this.buid;
	}

	public void setBuid(int buid) {
		this.buid = buid;
	}

	@Column(name = "BUName", nullable = false, length = 50)
	public String getBuname() {
		return this.buname;
	}

	public void setBuname(String buname) {
		this.buname = buname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessunit")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
