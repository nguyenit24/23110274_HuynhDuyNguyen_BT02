package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBContextSQL {
	private final String serverName = "DNGUYEN";
	private final String dbName = "ltwebsangt5";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName
					+ ";encrypt=true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			DBContextSQL DBContext = new DBContextSQL();
			Connection conn = DBContext.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO SinhVien(id, username, email) "
					+ "VALUES (1, 'Trung', '@WW')");
			ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien");
			// show data
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
