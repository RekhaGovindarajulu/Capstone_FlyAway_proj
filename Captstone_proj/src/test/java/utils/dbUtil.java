package utils;

import static org.testng.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbUtil {

	private static Connection ct = null;
	private static Statement st = null;

	public static void dbConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "");

	}

	public static void dbQuery(String emailID) throws SQLException {
		st = ct.createStatement();
		ResultSet rs = st.executeQuery("select * from f_user");

		while (rs.next()) {
			if (rs.getString("email").equals(emailID)) {
				assertTrue(true);
				break;
			}
		}

	}

	public static void dbClose() {
		if (ct == null) {
			return;
		}

		try {
			ct.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("db connection closed");

	}

}
