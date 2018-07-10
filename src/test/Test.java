package test;

import view.NotePad;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Splash Window Size Test
		 * SplashWindow s=new SplashWindow();
		 
		//s.setSize(500, 500);
		s.setVisible(true);*/
		
		//*DB Connect Test
		/*try {
            String driver ="org.mariadb.jdbc.Driver";
            //从配置参数中获取数据库url
            String url = "jdbc:mariadb://localhost:3306/";
            //从配置参数中获取用户名
            String user = "root";
            //从配置参数中获取密码
            String pass = "";

            //注册驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url,user,pass);
            //创建Statement对象
            Statement stmt = conn.createStatement();


            System.out.println(stmt);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

		//Connection conn=DBConnector.getDatabaseConnnection();
		//System.out.println(conn);
		//DBConnector.closeDatabaseConnection(conn);
		/*List<WordCount> lst=new WordCountDao().getSortedWordCountTable();
		for(WordCount wc:lst)
		{
			System.out.printf("%s\t:count%d\n",wc.getWord(),wc.getCount());
		}*/
		//new UserDao().createUser("wxl", "123456");
		//new UserDao().updateUserWords("wsl", "abc");
		/*Word ww=new WordDao().queryWord("wsl");
		System.out.println(ww.getId());
		System.out.println(ww.getWord());
		System.out.println(ww.getGQFC());
		System.out.println(ww.getGQS());
		System.out.println(ww.getXZFC());
		System.out.println(ww.getFS());
		System.out.println(ww.getMeaning());
		System.out.println(ww.getLx());*/
		//LoginFrame lf=new LoginFrame();
		//lf.getTipUserName().setText("Hello World!");	
		//lf.setSize(500,500);
		//lf.setLocation(400,400);
		//lf.adjustLayout();
		//lf.setVisible(true);
		NotePad np=new NotePad();
		np.setSize(500,500);
		np.setLocation(400,400);
		np.adjustLayout();
		np.setVisible(true);
	}//Main End

}
