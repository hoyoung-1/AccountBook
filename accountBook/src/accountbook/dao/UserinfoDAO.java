package accountbook.dao;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import accountbook.vo.UserinfoVO;

public class UserinfoDAO {

	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:hy";
	private final String ID = "account";
	private final String PASSWORD = "account";

	///
	public boolean get(String id, String password) {
		boolean check = false;

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		String sql = "select id,password from userinfo";
		try (Connection con = DriverManager.getConnection(URL, ID, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.println("연결 성공 ");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return check;
	}

	// 사용자 등록
	public int insert(String id, String password, String name) {
		int insertNum = 0;

		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String sql = "insert into userinfo(no,id,password,name) values (seq_acc.nextval,?,?,?)";
		try (Connection con = DriverManager.getConnection(URL, ID, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);

			insertNum = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return insertNum;
	}

	// 등록된 사용자인지 확인하는 dao
	public UserinfoVO getSignIn(String id, String password) {
		UserinfoVO vo = new UserinfoVO();

		boolean flag = false;

		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.out.println("드라이버 에러 : " + e.getMessage());
		}

		String sql = "SELECT id,password,name FROM userinfo WHERE id like ? and password like ?";
		try (Connection con = DriverManager.getConnection(URL, ID, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // select 결과가 있다면 true;
				String name = rs.getString("name");
				String rsId = rs.getString("id");
				String rsPassword = rs.getString("password");

				UserinfoVO vo1 = new UserinfoVO(rsId, rsPassword, name);
				vo = vo1;
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("sql 에러 : " + e.getMessage());
		}

		return vo;
	}

}
