package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class StudentDAO {

	DBManager manager = DBManager.getInstance();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 학생정보 입력
	public int Insert(int bun, String name, String addr, String email, String date) {

		String query = "insert into student(student_bun,student_name,student_addr,student_email,"
				+ "student_birth) values(?,?,?,?,?)";

		int row = 0;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bun);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, email);
			pstmt.setString(5, date);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;

	}

	// 학번확인
	public List<StudentVO> Hak(int bun) {

		String query = "select student_bun from student where student_bun=?";

		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = null;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bun);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new StudentVO();
				vo.setStudent_bun(rs.getInt("student_bun"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 전체 검색
	public List<StudentVO> View() {

		String query = "select * from student";

		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = null;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new StudentVO();
				vo.setStudent_bun(rs.getInt("student_bun"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_addr(rs.getString("student_addr"));
				vo.setStudent_birth(rs.getString("student_birth"));

				list.add(vo);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 이름으로 검색
	public List<StudentVO> select1(String name) {

		String query = "select * from student where student_name=?";

		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = null;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new StudentVO();
				vo.setStudent_bun(rs.getInt("student_bun"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_addr(rs.getString("student_addr"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_birth(rs.getString("student_birth"));

				list.add(vo);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 학번으로 검색
	public List<StudentVO> select2(int bun) {

		String query = "select * from student where student_bun=?";

		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = null;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bun);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new StudentVO();
				vo.setStudent_bun(rs.getInt("student_bun"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_addr(rs.getString("student_addr"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_birth(rs.getString("student_birth"));

				list.add(vo);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 학년으로 검색
	public List<StudentVO> select3(int hakn) {

		String query = "select * from student where substr(student_bun,1,1)=?"; //substr 글자하나빼기 
		
		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = null;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, hakn);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo = new StudentVO();
				vo.setStudent_bun(rs.getInt("student_bun"));
				vo.setStudent_name(rs.getString("student_name"));
				vo.setStudent_addr(rs.getString("student_addr"));
				vo.setStudent_email(rs.getString("student_email"));
				vo.setStudent_birth(rs.getString("student_birth"));

				list.add(vo);

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 수정
	public int Update(int bun, String name, String addr, String email, String birth) {

		String query = "update student set student_name =?, student_addr =?, student_email=?, student_birth=? where student_bun =?";
		int row = 0;

		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, email);
			pstmt.setString(4, birth);
			pstmt.setInt(5, bun);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 삭제
	public int Delete(int bun) {

		String query = "delete from student where student_bun=?";

		int row = 0;
		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bun);

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;

	}

	// 종료
	public int exit() {

		String query = "exit";
		int row = 0;
		try {

			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;

	}

}
