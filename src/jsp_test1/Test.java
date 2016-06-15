package jsp_test1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql:///yawei?user=root&password=root";
		Connection conn = DriverManager.getConnection(url);
		
		String sql = "{call p_get_page(?,?,?,?)}";
		CallableStatement cs=conn.prepareCall(sql);
		cs.setString(1, "v_result");
		cs.setInt(2, 5);
		cs.setInt(3, 2);

		ResultSet rs = cs.executeQuery();
		int total = cs.getInt(4);
		System.out.println("总共"+total+"条数据 第1页数据为：");
		while(rs.next()){
			System.out.println(rs.getString("stuname")+":"+rs.getInt("score"));
		}
		cs.close();
		conn.close();
	}
}
