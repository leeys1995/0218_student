package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	private DBManager() {
	}

	private static DBManager instance = new DBManager(); // �ڱ��ڽ��� ȣ��

	public static DBManager getInstance() {

		return instance; // �ּ� ��ȯ
	}

	public Connection getConnection() throws Exception {

		Connection conn = null;

		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "hr";
		String myPW = "1234";

		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL, myID, myPW);
			// System.out.println("����̹� �ε� �� Ŀ�ؼ� ���� Ȯ��");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
