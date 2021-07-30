package com.yskkkkkk.july.news;

public class News {

	private String title;
	private String desc;
	private String link;
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(String title, String desc, String link) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

//	@Override
//	public String toString() {
//		return "News [title=" + title + ", desc=" + desc + ", link=" + link + "]";
//	}

	@Override
	public String toString() {
		return title;
	}
	
	
}
