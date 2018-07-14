package com.thanh.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Baby {
	private int id;
	String name;
	String meaning;
	String sex;
	String religion;
	
	public Baby(String name, String meaning, String sex, String religion) {
		this.name = name;
		this.meaning = meaning;
		this.sex = sex;
		this.religion = religion;
	}
	public Baby(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt("id");
		this.name = resultSet.getString("name");
		this.meaning = resultSet.getString("meaning");
		this.sex = resultSet.getString("sex");
		this.religion = resultSet.getString("religion");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	
}
