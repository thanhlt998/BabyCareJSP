package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thanh.beans.Baby;

public class BabyDao {
	public static boolean addBaby(Baby baby, Connection connection) {
		String sql = "insert into babyname(name, meaning, sex, religion) values (?,?,?,?)";
		PreparedStatement statement = null;
		int rowsAffected = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, baby.getName());
			statement.setString(2, baby.getMeaning());
			statement.setString(3, baby.getSex());
			statement.setString(4, baby.getReligion());
			
			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There are something wrong when adding a baby!!");
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}

	public static boolean deleteBabyById(int id, Connection connection) {
		String sql = "delete from babyname where id=" + id;
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("There are something wrong when deleting baby by id!!!");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static boolean deleteBabyByIdList(String[] idList, Connection connection) {
		StringBuffer sql = new StringBuffer("delete from babyname where id in (");
		int i;
		int rowsAffected = 0;
		for(i = 0; i < idList.length - 1; i++) {
			sql.append(idList[i] + ", ");
		}
		
		sql.append(idList[i] + ")");
		
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql.toString());
		} catch (SQLException e) {
			System.out.println("There are something wrong when delete babies!!!");
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}

	public static ArrayList<Baby> getAllBabies(Connection connection) {
		ArrayList<Baby> babies = new ArrayList<>();
		String sql = "select * from babyname";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				babies.add(new Baby(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong when getting all babies!!!");
			e.printStackTrace();
		}
		return babies;
	}

	public static ArrayList<Baby> getBabiesStartBy(String start, Connection connection) {
		ArrayList<Baby> babies = new ArrayList<>();
		String sql = "select * from babyname where name like '" + start + "%'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				babies.add(new Baby(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong when getting babies having name start with " + start);
			e.printStackTrace();
		}
		return babies;
	}

	public static ArrayList<Baby> getBabiesByReligion(String religion, Connection connection) {
		ArrayList<Baby> babies = new ArrayList<>();
		String sql = "select * from babyname where religion='" + religion + "'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				babies.add(new Baby(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong when getting babies from " + religion);
			e.printStackTrace();
		}
		return babies;
	}
	
}
