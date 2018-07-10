package model;
import java.sql.*;
public class WordDao {
	/**
	 * 插入SQL预处理语句
	 */
	private static String SQL_INSERT_WORD="insert words values(null,?,?,?,?,?,?,?)";
	/**
	 * 删除SQL预处理语句
	 */	
	private static String SQL_DELETE_WORD="delete from words  where Word=?";
	/**
	 * 查询SQL预处理语句
	 */	
	private static String SQL_QUERY_WORD="select * from words where Word=?";
	/**
	 * 更新SQL预处理语句
	 */
	private static String SQL_UPDATE_WORD="update words set GQS=?,GQFC=?,XZFC=?,FS=?,meaning=?,lx=? where Word=?";
	/**
	 * 数据库项ID
	 */
	private static String FIELD_ID="ID";
	/**
	 * 数据库项Word
	 */
	private static String FIELD_WORD="Word";
	/**
	 * 数据库项GQS
	 */
	private static String FIELD_GQS="GQS";
	/**
	 * 数据库项GQFC
	 */
	private static String FIELD_GQFC="GQFC";
	/**
	 * 数据库项XZFC
	 */
	private static String FIELD_XZFC="XZFC";
	/**
	 * 数据库项FS
	 */
	private static String FIELD_FS="FS";
	/**
	 * 数据库项meaning
	 */
	private static String FIELD_MEANING="meaning";
	/**
	 * 数据库项lx
	 */
	private static String FIELD_LX="lx";
	/**
	 * 在数据库中添加一个单词 由参数word提供单词的所有信息
	 * @param w 要添加的单词
	 */
	public void addWord(Word w)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		try
		{
			ps=conn.prepareStatement(SQL_INSERT_WORD);
			ps.setString(1, w.getWord());
			ps.setString(2, w.getGQS());
			ps.setString(3, w.getGQFC());
			ps.setString(4, w.getXZFC());
			ps.setString(5, w.getFS());
			ps.setString(6, w.getMeaning());
			ps.setString(7, w.getLx());
			ps.executeQuery();
			if(null!=ps)
			{
				ps.close();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据库中的一个单词 你只需要提供单词名
	 * @param word 单词名
	 */
	public void deleteWord(String word)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		try
		{
			ps=conn.prepareStatement(SQL_DELETE_WORD);
			ps.setString(1, word);
			ps.executeQuery();
			if(null!=ps)
			{
				ps.close();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 查询一个单词的相关信息 需要提供单词名
	 * @param word 单词名
	 * @return 单词的所有信息
	 */
	public Word queryWord(String word)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		Word ret=new Word();
		ResultSet rs=null;
		try
		{
			ps=conn.prepareStatement(SQL_QUERY_WORD);
			ps.setString(1, word);
			rs=ps.executeQuery();
			while(rs.next())
			{
				ret.setId(rs.getInt(FIELD_ID));
				ret.setWord(rs.getString(FIELD_WORD));
				ret.setGQFC(rs.getString(FIELD_GQFC));
				ret.setGQS(rs.getString(FIELD_GQS));
				ret.setXZFC(rs.getString(FIELD_XZFC));
				ret.setFS(rs.getString(FIELD_FS));
				ret.setMeaning(rs.getString(FIELD_MEANING));
				ret.setLx(rs.getString(FIELD_LX));
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
			return ret;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 更新一个单词 你需要提供单词的相关信息
	 * @param word 单词及其相关信息
	 */
	public void updateWord(Word word)
	{
		Connection conn=DBConnector.getDatabaseConnnection();
		PreparedStatement ps=null;
		try
		{
			ps=conn.prepareStatement(SQL_UPDATE_WORD);
			ps.setString(1,word.getGQS());
			ps.setString(2,word.getGQFC());
			ps.setString(3,word.getXZFC());
			ps.setString(4,word.getFS());
			ps.setString(5,word.getMeaning());
			ps.setString(6,word.getLx());
			ps.setString(7,word.getWord());
			ps.executeQuery();
			if(null!=ps)
			{
				ps.close();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
