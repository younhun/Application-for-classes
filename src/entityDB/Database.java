package entityDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/lms";
	private static final String ID = "root";
	private static final String PASSWORD = "yh0705";

	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private static Database database = null;

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}

	public void connect() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		this.connection = DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public void disconnect() throws SQLException {
		if (this.connection != null)
			this.connection.close();
		if (this.pstmt != null)
			this.pstmt.close();
		if (this.rs != null)
			this.rs.close();
	}

	public ResultSet select(String tableName, String condition) throws SQLException {
		String sql = " select * from " + tableName + " where " + condition;
		this.pstmt = this.connection.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		return rs;
	}

	public ResultSet select(String tableName) throws SQLException {
		String sql = " select * from " + tableName;
		this.pstmt = this.connection.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		return rs;
	}

}
