package com.doksusa.content;

public class ContentDTO {

	String content;
	int num;
	String group;

	public ContentDTO() {
		super();
	}

	public ContentDTO(String content, int num, String group) {
		super();
		this.content = content;
		this.num = num;
		this.group = group;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	@Override
	public String toString() {
		return "ContentDTO [content=" + content + ", num=" + num + ", group=" + group + "]";
	}

}
