package com.investec.expd.rest.dto;
// Generated 02 Dec 2016 9:27:23 PM by Hibernate Tools 4.3.1.Final

import javax.xml.bind.annotation.XmlRootElement;

import com.investec.expd.model.Notes;

@XmlRootElement
public class NotesDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5876081124861293569L;
	private int notesId;
	private int ideaId;
	private int userID;
	private String text;
	/**
	 * @return the notesId
	 */
	
	public NotesDTO(Notes entity){
		this.setNotesId(entity.getNotesId());
		this.setText(entity.getText());
		if(entity.getIdea()!=null){
			this.setIdeaId(entity.getIdea().getIdeaId());
		}
		if(entity.getUser()!=null){
			this.setUserID(entity.getUser().getUserId());
		}
	}
	/**
	 * 
	 */
	public NotesDTO(){
		
	}
	/**
	 * 
	 * @return
	 */
	public int getNotesId() {
		return notesId;
	}
	/**
	 * @param notesId the notesId to set
	 */
	public void setNotesId(int notesId) {
		this.notesId = notesId;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	
	}
