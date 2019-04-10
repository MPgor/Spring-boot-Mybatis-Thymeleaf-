package com.wjs.demo.domain;

import java.sql.Timestamp;

public class Bond {
	private Integer id;
	private Integer MK;
	private String title;
	private String publishTime;
	private String pdfUrl;
	private String type;
	private Timestamp createTime;
	private String obsPath;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMK() {
		return MK;
	}
	public void setMK(Integer mK) {
		MK = mK;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getObsPath() {
		return obsPath;
	}
	public void setObsPath(String obsPath) {
		this.obsPath = obsPath;
	}

}

