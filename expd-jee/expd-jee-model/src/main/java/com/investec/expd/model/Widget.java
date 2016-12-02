package com.investec.expd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@NamedQueries({
	@NamedQuery(
	name = "findWidgetByName",
	query = "from Widget w where w.widgetName = :widgetName"
	)
})
@Entity
@Table(name = "widget")
public class Widget implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("widget_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "widget_id", unique = true, nullable = false)
	private int widgetId;
	
	@JsonProperty("widget_name")
	@Column(name = "widget_name", unique = true, nullable = false, length = 100)
	private String widgetName;
	
	@JsonProperty("is_active")
	@Column(name = "is_active")
	private Boolean isActive;
	
	@JsonProperty("changed_time")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+2")
	@Column(name = "created_time")
	private Date changedTime;

	public Widget() {
	}

	public Widget(int widgetId) {
		this.widgetId = widgetId;
		this.setIsActive(false);
	}

	public int getWidgetId() {
		return this.widgetId;
	}

	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	
	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}	
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getChangedTime() {
		return changedTime;
	}

	public void setChangedTime(Date changedTime) {
		this.changedTime = changedTime;
	}

	@Override
	public String toString() {
		return "Widget [widgetId=" + widgetId + ", widgetName=" + widgetName
				+ ", isActive=" + isActive + ", changedTime=" + changedTime
				+ "]";
	}	
	

}
