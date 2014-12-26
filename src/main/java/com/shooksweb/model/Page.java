package com.shooksweb.model;

public class Page {
	private String name;
	private String parent;
	private String title;
	private String description;
	private String keywords;
	private Boolean hasHeader;
	private Boolean hasFooter;
	private Boolean hasNavigation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Boolean getHasHeader() {
		return hasHeader;
	}

	public void setHasHeader(Boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	public Boolean getHasFooter() {
		return hasFooter;
	}

	public void setHasFooter(Boolean hasFooter) {
		this.hasFooter = hasFooter;
	}

	public Boolean getHasNavigation() {
		return hasNavigation;
	}

	public void setHasNavigation(Boolean hasNavigation) {
		this.hasNavigation = hasNavigation;
	}
}
