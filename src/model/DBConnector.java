/**
 * 
 */
package model;

import java.sql.*;

import utils.CONFIG;

/**
 * @author wsl
 *
 */
public class DBConnector {
	/**
	 * conn 
	 * 全局维护同数据库的单个连接
	 * 在程序结束之前不要close
	 */
	private static Connection conn=null;
	/**
	 * 获取同数据库的连接
	 * 若连接为null
	 * 则创建连接
	 * @return
	 * 数据库连接
	 */
	public static Connection getDatabaseConnnection()	
	{
		if(null!=conn)
		{
			return conn;
		}
		try {
            String driver =CONFIG.DATABASE_DRIVER_NAME;
            //从配置参数中获取数据库
            String url = CONFIG.DATABASE_CONNECT_STRING;
            //从配置参数中获取用户名
            String user =CONFIG.DATABASE_USER_NAME;
            //从配置参数中获取密码
            String pass = CONFIG.DATABASE_PASSWORD;
            //注册驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url,user,pass);
            //创建Statement对象
            return conn;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}
	
	public static void closeDatabaseConnection()
	{
		if(conn==null)
		{
			return ;
		}
		try {
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
