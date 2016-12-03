package com.investec.expd.rest.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Businessunit;

@XmlRootElement
public class BusinessunitDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2845743410518346610L;
	/**
	 * 
	 */
	
	private int buid;
	private String buname;
	private Set<UserDTO> users = new HashSet<UserDTO>(0);

	public BusinessunitDTO() {
	}

	public BusinessunitDTO(Businessunit entity) {
		this.setBuid(entity.getBuid());
		this.setBuname(entity.getBuname());
	}

	/**
	 * @return the buid
	 */
	public int getBuid() {
		return buid;
	}

	/**
	 * @param buid the buid to set
	 */
	public void setBuid(int buid) {
		this.buid = buid;
	}

	/**
	 * @return the buname
	 */
	public String getBuname() {
		return buname;
	}

	/**
	 * @param buname the buname to set
	 */
	public void setBuname(String buname) {
		this.buname = buname;
	}

	/**
	 * @return the users
	 */
	public Set<UserDTO> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	}
