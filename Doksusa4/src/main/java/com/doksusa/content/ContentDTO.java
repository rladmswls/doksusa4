package com.doksusa.content;

public class ContentDTO {

	int num;
	String group;
	String content;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ContentDTO [num=" + num + ", group=" + group + ", content=" + content + "]";
	}
	public ContentDTO(int num, String group, String content) {
		super();
		this.num = num;
		this.group = group;
		this.content = content;
	}
	
	
	
	
}
