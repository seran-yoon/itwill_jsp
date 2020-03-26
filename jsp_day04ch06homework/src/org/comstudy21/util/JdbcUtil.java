package org.comstudy21.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	public static Connection getConnection(){
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");
			Connection conn = ds.getConnection();

			return conn;
		} catch (Exception e) {
		
		}
		
		return null;
	}
	
	public static void close(Connection conn) {
	      if (conn != null)
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	   public static void close(Statement stmt) {
	      if (stmt != null)
	         try {
	            stmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }
	   public static void close(ResultSet rs) {
	      if (rs != null)
	         try {
	            rs.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }

	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		close(rs);
		close(stmt);
		close(conn);
	}

}


