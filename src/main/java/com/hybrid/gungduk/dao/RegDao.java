package com.hybrid.gungduk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hybrid.gungduk.dto.RegDto;

public class RegDao {
	
	private Connection conn;
	
	public RegDao() {
		try {
			String dbURL = "jdbc:mysql://nydb.c284tnijrgky.ap-northeast-2.rds.amazonaws.com/gungduk";
			String dbID = "user";
			String dbPassword = "nynydbdb1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int registerCheck(String email){ //중복되는 아이디 있는지 체크
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String SQL = "SELECT * FROM USER WHERE email = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return 0; //이미 존재하는 회원
			}else{
				return 1; //가입 가능한 회원 아이디
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;//DB오류
	}
	
	public int register(String email, String pw, String phoneNum){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String SQL = "INSERT INTO USER VALUES (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			pstmt.setString(3, phoneNum);
			return pstmt.executeUpdate();//실행된 SQL 개수 반환 -> 1
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;//DB오류
	}
}
