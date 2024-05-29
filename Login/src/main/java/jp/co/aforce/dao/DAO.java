package jp.co.aforce.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	
	//声明了一个静态的 DataSource 类型的变量 ds，用于存储数据源。
	static DataSource ds;
    // 获取数据库连接的方法	
	public Connection getConnection()throws Exception{
		
		//如果数据源 ds 为 null，则执行下面的代码块
		if (ds == null) {
			// 创建 InitialContext 实例，初始上下文环境
			InitialContext ic = new InitialContext();
			 // 查找数据源，名称为 "java:/comp/env/jdbc/login_db"
			ds= (DataSource)ic.lookup("java:/comp/env/jdbc/login_db");
		}
		// 返回数据源的连接
		return ds.getConnection();
	}
}
//不需要web.xml文件也可以连接，用注释就好了
