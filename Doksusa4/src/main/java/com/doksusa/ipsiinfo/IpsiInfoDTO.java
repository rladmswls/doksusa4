package com.doksusa.ipsiinfo;

public class IpsiInfoDTO {

	String university;
	String link;
	String logo;

	public IpsiInfoDTO() {
		super();
	}

	public IpsiInfoDTO(String university, String link, String logo) {
		super();
		this.university = university;
		this.link = link;
		this.logo = logo;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "IpsiInfoDTO [university=" + university + ", link=" + link + ", logo=" + logo + "]";
	}

}
