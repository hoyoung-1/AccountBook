package accountbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import accountbook.vo.AccountVO;

public class AccountDAO {

	// DB 드라이버, connection을 만들어줌
	public static Connection connection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:hy";
		String user = "account";
		String password = "account";

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공 ");
			return con;
		} catch (SQLException e) {
			e.getMessage();
		}

		return con;
	}

	// 접속한 name으로 account를 출력
	public List<AccountVO> getList(String name) {
		List<AccountVO> list = new ArrayList<AccountVO>();

		String sql = "select name,history,expenses,income,total,updatedate from account where name = ? order by no desc"; // where name = ? 넣어야함
		try (Connection con = connection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String getName = rs.getString("name");
				String history = rs.getString("history");
				int expenses = rs.getInt("expenses");
				int income = rs.getInt("income");
				int total = rs.getInt("total");
				Date updateDate = rs.getDate("updatedate");
				AccountVO avo = new AccountVO(getName, expenses, income, total, updateDate, history);
				list.add(avo);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return list;
	}


	// insert dao 
	public boolean insert(String name ,String history, int income, int expenses,int total) {
		
		boolean flag = false;
		
		String sql = "insert into account(no,name,history,income,expenses,total) values (seq_acc.nextval,?,?,?,?,?)";
		try(Connection con = connection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			
			ps.setString(1, name);
			ps.setString(2, history);
			ps.setInt(3, income);
			ps.setInt(4, expenses);
			ps.setInt(5, total);
			
			int insert = ps.executeUpdate();
			
			if(insert >0) {
				flag = true;
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		return flag;
	}
	
	// total을 구해주는 dao 
	public int totalSum (String name) {
		int totalSum = 0 ;
		String sql = "select total from account where name like ? and no = (select max(no) from account)";
		
		try(Connection con =connection();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				totalSum = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		return totalSum;
	}

}
