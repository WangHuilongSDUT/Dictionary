/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author wsl
 *
 */
public class WordCountDao {
	/**
	 * 查询用的sql语句语句语句语句emmm
	 */
	private static String SQL_GET_SORTED_ALL="select * from summary order by count desc";
	/**
	 * 拿到排序好的表表白哦表白哦呵o
	 * @return
	 */
	public List<WordCount> getSortedWordCountTable()
	{
		//返回列表 数据库连接 预处理表达式 结果集
		List<WordCount> retList=new ArrayList<WordCount>();
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//连接并查询
		try {
			ps=conn.prepareStatement(SQL_GET_SORTED_ALL);
			rs=ps.executeQuery();
			
			//对结果集处理
			while(rs.next())
			{
				WordCount wc=new WordCount();
				wc.setWord(rs.getString("word"));
				wc.setCount(rs.getInt("count"));
				retList.add(wc);
			}
			//释放和返回
			if(null!=rs)
			{
				rs.close();
			}
			if(null!=ps)
			{
				ps.close();
			}
			return retList;		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
}
