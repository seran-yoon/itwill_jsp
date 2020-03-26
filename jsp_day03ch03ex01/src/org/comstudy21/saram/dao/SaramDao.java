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
			JdbcUtil.close(conn,stmt,rs);
		}
		arr = new SaramDto[list.size()];
		list.toArray(arr);
		
		return arr;
	}
	
	public void insert(SaramDto dto){
		System.out.println(dto);
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("###입력 성공!");
				conn.commit();
			}else{
				System.out.println("###입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	
	}
	
	public SaramDto selectOne(SaramDto dto){
		SaramDto saram = null;
		
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				
				saram = new SaramDto(id, name, age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return saram;
	}
	
	public void update(SaramDto dto){
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(3, dto.getId());
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("###수정 성공!");
				conn.commit();
			}else{
				System.out.println("###수정 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public void delete(SaramDto dto){
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, dto.getId());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("###삭제 성공!");
				conn.commit();
			}else{
				System.out.println("###삭제 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	
}
