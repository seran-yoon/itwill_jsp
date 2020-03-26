package org.comstudy21.saram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.saram.dto.SaramDto;
import org.comstudy21.util.JdbcUtil;

public class SaramDao {
	
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	private String selectAll = "SELECT * FROM SARAM";
	private String insert = "INSERT INTO SARAM VALUES(?,?,?)";
	private String selectOne = "SELECT * FROM SARAM WHERE ID=?";
	private String update = "UPDATE SARAM SET NAME=?, AGE=? WHERE ID=?";
	private String delete = "DELETE FROM SARAM WHERE ID=?";
	
	public SaramDao(){
		
	}

	public SaramDao(Connection conn) {
		this.conn = conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public SaramDto[] selectAll(){
		SaramDto[] arr = null;
		ArrayList<SaramDto> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectAll);
			
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new SaramDto(id, name, age));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn,pstmt,rs);
		}
		arr = new SaramDto[list.size()];
		list.toArray(arr);
		
		return arr;
	}
	
	public void insert(SaramDto dto){
		
	
	}
	
	public SaramDto selectOne(SaramDto dto){
		
		return null;
	}
	
	public void update(SaramDto dto){
		
	}
	
	public void delete(SaramDto dto){
		
	}
	
	
}
