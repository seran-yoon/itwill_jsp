package org.comstudy21.employe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.employe.dto.EmployeDto;
import org.comstudy21.util.JdbcUtil;

public class EmployeDao {
	
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	private String selectAll = "SELECT * FROM EMPLOYE";
	private String insert = "INSERT INTO EMPLOYE VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private String selectOne = "SELECT * FROM EMPLOYE WHERE NAME=?";
//	private String update = "UPDATE EMPLOYE SET course=?, jumin1=?, jumin2=?, address=?, phone=?, mobile=?, payment=?, start_day=?, end_day=?, collect_person_info=? WHERE NAME=?";
	private String delete = "DELETE FROM EMPLOYE WHERE NAME=?";
	
	public EmployeDao() {
		// TODO Auto-generated constructor stub
	}

	public EmployeDao(Connection conn) {
		this.conn = conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public EmployeDto[] selectAll(){
		EmployeDto[] arr = null;
		ArrayList<EmployeDto> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectAll);
			
			while(rs.next()){
				String course = rs.getString("course");
				String name = rs.getString("name");
				String jumin1 = rs.getString("jumin1");
				String jumin2 = rs.getString("jumin2");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String mobile = rs.getString("mobile");
				String payment = rs.getString("payment");
				String start_day = rs.getString("start_day");
				String end_day = rs.getString("end_day");
				String collect_person_info = rs.getString("collect_person_info");
				
				list.add(new EmployeDto(course, name, jumin1, jumin2, address, phone, mobile, payment, start_day, end_day, collect_person_info));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		
		arr = new EmployeDto[list.size()];
		list.toArray(arr);
		
		return arr;
		
	}
	
	public void insert(EmployeDto dto){
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, dto.getCourse());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getJumin1());
			pstmt.setString(4, dto.getJumin2());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getMobile());
			pstmt.setString(8, dto.getPayment());
			pstmt.setString(9, dto.getStart_day());
			pstmt.setString(10, dto.getEnd_day());
			pstmt.setString(11, dto.getCollect_person_info());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println("###입력 성공!");
				conn.commit();
			}else{
				System.out.println("###입력 실패");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}

	public EmployeDto selectOne(EmployeDto dto) {
		EmployeDto emplist = null;
		
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				String course = rs.getString("course");
				String name = rs.getString("name");
				String jumin1 = rs.getString("jumin1");
				String jumin2 = rs.getString("jumin2");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String mobile = rs.getString("mobile");
				String payment = rs.getString("payment");
				String start_day = rs.getString("start_day");
				String end_day = rs.getString("end_day");
				String collect_person_info = rs.getString("collect_person_info");
				
				emplist = new EmployeDto(course, name, jumin1, jumin2, address, phone, mobile, payment, start_day, end_day, collect_person_info);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return emplist;
	}
	
	public void delete(EmployeDto dto){
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, dto.getName());
			
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
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	

}
