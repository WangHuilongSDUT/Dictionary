/**
 * 
 */
package model;

import java.sql.*;

/**
 * @author wsl
 *
 */
public class UserDao {
	//SQL预处理语句
	private static String SQL_CREATE_USER="insert into user values(null,?,?,null)";
	private static String SQL_GET_USER="select * from user where name=?";
	private static String SQL_UPDATE_WORDS="update user set words=? where name=?";
	//数据库列表项名称
	private static String FIELD_ID="id";
	private static String FIELD_NAME="name";
	private static String FIELD_PASSWORD="psd";
	private static String FIELD_WORDS="words";
	/**
	 * 这个函数用来创建一个用户 你只需要提供用户名和密码
	 * @param uName 用户名	
	 * @param password	密码
	 */
	public void createUser(String uName,String password)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(SQL_CREATE_USER);
			ps.setString(1, uName);
			ps.setString(2, password);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取一个用户的数据库信息 包括id姓名密码词库
	 * @param uName 用户名
	 * @return
	 */
	public User getUser(String uName)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		User usr=new User();
		try {
			ps=conn.prepareStatement(SQL_GET_USER);
			ps.setString(1, uName);
			rs=ps.executeQuery();
			while(rs.next())
			{
				usr.setId(rs.getInt(FIELD_ID));
				usr.setName(rs.getString(FIELD_NAME));
				usr.setPassword(rs.getString(FIELD_PASSWORD));
				usr.setWords(rs.getString(FIELD_WORDS));
				break;
			}
			if(null!=rs)
			{
				rs.close();
			}
			if(null!=ps)
			{
				ps.close();
			}
			return usr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检测一个用户是否存在了
	 * @param uName	用户名
	 * @return
	 */
	public boolean isUserExist(String uName)
	{
		if(0!=this.getUser(uName).getId())
		{
			return true;
		}
		return false;
	}
	/**
	 * 更新用户的单词本
	 * @param uName 用户名
	 * @param words 新单词本
	 */
	public void updateUserWords(String uName,String words)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(SQL_UPDATE_WORDS);
			ps.setString(1, words);
			ps.setString(2, uName);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
