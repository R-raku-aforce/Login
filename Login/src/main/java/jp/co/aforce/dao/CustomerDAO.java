package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Customer;

public class CustomerDAO extends DAO{

	public Customer search(String username, String password)
		throws Exception{
		
		//  // 获取数据库连接
		Customer customer = null;
		
		Connection con= getConnection();
		
		PreparedStatement st;
		//// 创建 SQL 查询语句，使用 ? 占位符表示参数
		st=con.prepareStatement("select * from login where username=? and password=?");
		  // 设置查询语句中的参数，第一个 ? 用用户名替换
		st.setString(1, username);
		 // 第二个 ? 用密码替换
		st.setString(2, password);
		// 执行查询
		ResultSet rs= st.executeQuery();
		
		// 遍历结果集
		while(rs.next()) {
			// 创建 Customer 对象
			customer = new Customer(username, password);
			// 从结果集中获取 id 并设置到 Customer 对象中
			customer.setId(rs.getInt("id"));
			// 从结果集中获取用户名并设置到 Customer 对象中
			customer.setUsername(rs.getString("username"));
			 // 从结果集中获取密码并设置到 Customer 对象中
			customer.setPassword(rs.getString("password"));
		}
		  // 关闭 PreparedStatement
		st.close();
		 // 关闭数据库连接
		con.close();
		 // 返回查询到的 Customer 对象，如果没有找到用户则返回 null
		return customer;
	}
	
	 public void addCustomer(Customer customer) throws Exception {
		 
		  // 获取数据库连接
	        Connection con = getConnection();
	        PreparedStatement st = null;
	        try {
	            // 编写 SQL 插入语句   // 编写 SQL 插入语句，使用 ? 占位符表示参数
	            String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
	            st = con.prepareStatement(sql);
	            // 设置参数
	            st.setString(1, customer.getUsername());
	            st.setString(2, customer.getPassword());
	            // 执行插入操作
	            st.executeUpdate();
	        } finally {
	            // 关闭资源
	            if (st != null) {
	                st.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        }
	    }
}

//search 方法：用于在数据库中查找用户，
//如果找到匹配的记录则返回一个 Customer 对象，否则返回 null。
//addCustomer 方法：用于在数据库中添加一个新的用户，执行插入操作。