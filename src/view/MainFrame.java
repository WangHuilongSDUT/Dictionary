package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.*;

import controller.Settings;
import utils.CONSTS;

/**
 * 主视图
 * @author 
 * 这个类提供了窗体的主要视图
 */
public class MainFrame extends JFrame {
	/**
	 * 序列化ID 默认
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAINFRAME_HEIGHT_TOP_LINE=50;
	private static final int MAINFRAME_WIDTH_BUTTON_SEARCH=100;
	private static final int MAINFRAME_HEIGHT_LAST_LINE=50;
	/**
	 * 菜单栏篮篮篮篮篮
	 */
	private JMenuBar mb=new JMenuBar();
	/**
	 * 搜索单词的编辑框
	 */
	private JTextField textSearch=new JTextField();
	/**
	 * 搜索按钮
	 */
	private JButton btnSearch=new JButton();
	/**
	 * 显示单词释义的文本域
	 */
	private JTextArea textMeanings=new JTextArea();
	/**
	 * 添加到生词本按钮
	 */
	private JButton btnAddToNotepad=new JButton();
	/**
	 * 用户菜单
	 */
	private JMenu menuUser=null;
	/**
	 * 选项菜单
	 */
	private JMenu menuOption=null;
	/**
	 * 关于菜单
	 */
	private JMenu menuAbout=null;
	
	/**
	 * @return the mb
	 */
	
	public JMenuBar getMb() {
		return mb;
	}
	/**
	 * @param mb the mb to set
	 */
	public void setMb(JMenuBar mb) {
		this.mb = mb;
	}
	/**
	 * @return the textSearch
	 */
	public JTextField getTextSearch() {
		return textSearch;
	}
	/**
	 * @param textSearch the textSearch to set
	 */
	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
	}
	/**
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}
	/**
	 * @param btnSearch the btnSearch to set
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	/**
	 * @return the textMeanings
	 */
	public JTextArea getTextMeanings() {
		return textMeanings;
	}
	/**
	 * @param textMeanings the textMeanings to set
	 */
	public void setTextMeanings(JTextArea textMeanings) {
		this.textMeanings = textMeanings;
	}
	/**
	 * @return the btnAddToNotepad
	 */
	public JButton getBtnAddToNotepad() {
		return btnAddToNotepad;
	}
	/**
	 * @param btnAddToNotepad the btnAddToNotepad to set
	 */
	public void setBtnAddToNotepad(JButton btnAddToNotepad) {
		this.btnAddToNotepad = btnAddToNotepad;
	}
	/**
	 * @return the menuUser
	 */
	public JMenu getMenuUser() {
		return menuUser;
	}
	/**
	 * @param menuUser the menuUser to set
	 */
	public void setMenuUser(JMenu menuUser) {
		this.menuUser = menuUser;
	}
	/**
	 * @return the menuOption
	 */
	public JMenu getMenuOption() {
		return menuOption;
	}
	/**
	 * @param menuOption the menuOption to set
	 */
	public void setMenuOption(JMenu menuOption) {
		this.menuOption = menuOption;
	}
	/**
	 * @return the menuAbout
	 */
	public JMenu getMenuAbout() {
		return menuAbout;
	}
	/**
	 * @param menuAbout the menuAbout to set
	 */
	public void setMenuAbout(JMenu menuAbout) {
		this.menuAbout = menuAbout;
	}
	/**
	 * 构造函数
	 */
	public MainFrame()
	{	
		this.initView();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * 在这里初始化视图
	 * 
	 */
	public void initView()
	{
		int lan=Settings.getLanguage();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//初始化字体
		/*
	     Font f = new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 11);//宋体  
	     UIManager.put("Label.font",f);  
	             UIManager.put("Label.foreground",Color.black);  
	             UIManager.put("Button.font",f);  
	             UIManager.put("Menu.font",f);  
	             UIManager.put("MenuItem.font",f);  
	             UIManager.put("List.font",f);  
	             UIManager.put("CheckBox.font",f);  
	             UIManager.put("RadioButton.font",f);  
	             UIManager.put("ComboBox.font",f);  
	             UIManager.put("TextArea.font",f);  
	             UIManager.put("EditorPane.font",f);  
	             UIManager.put("ScrollPane.font",f);  
	             UIManager.put("ToolTip.font",f);  
	             UIManager.put("TextField.font",f);  
	             UIManager.put("TableHeader.font",f);  
	             UIManager.put("Table.font",f);  
		*/
		//初始化菜单
		menuUser=new JMenu(CONSTS.MENU_STRING_USER[lan]);
		JMenuItem itemLogin = new JMenuItem(CONSTS.MENU_STRING_LOGIN[lan]);
		JMenuItem itemExit=new JMenuItem(CONSTS.MENU_STRING_EXIT[lan]);
		JMenuItem itemNotepad =new  JMenuItem(CONSTS.MENU_STRING_NOTEPAD[lan]);
		menuUser.add(itemLogin);
		menuUser.add(itemExit);	
		//menuUser.addSeparator();
		menuUser.add(itemNotepad);
		mb.add(menuUser);
		menuOption=new JMenu(CONSTS.MENU_STRING_OPTION[lan]);
		JMenuItem itemSettings=new JMenuItem(CONSTS.MENU_STRING_SETTINGS[lan]);
		menuOption.add(itemSettings);
		mb.add(menuOption);
		menuAbout=new JMenu(CONSTS.MENU_STRING_ABOUT[lan]);
		JMenuItem itemAuthor=new JMenuItem(CONSTS.MENU_STRING_AUTHOR[lan]);
		JMenuItem itemVersion=new JMenuItem(CONSTS.MENU_STRING_VERSION[lan]);
		menuAbout.add(itemAuthor);
		//menuAbout.addSeparator();
		menuAbout.add(itemVersion);
		mb.add(menuAbout);
		this.btnSearch.setText(CONSTS.MAINFRAME_BTN_SEARCH_TEXT[lan]);
		this.btnAddToNotepad.setText(CONSTS.MAINFRAME_BTN_ADDTONP_TEXT[lan]);
		this.setTitle(CONSTS.MAINFRAME_TITLE[lan]);
		
		this.setJMenuBar(mb);
		this.add(textSearch);
		this.add(btnSearch);
		this.add(textMeanings);
		this.add(btnAddToNotepad);
		this.adjustLayout();
		this.setIconImage(new ImageIcon("mainIcon.ico").getImage());
		
		this.addComponentListener(new ComponentAdapter()
				{
					@Override 
					public void componentResized(ComponentEvent e){
						adjustLayout();
					}
				});
		this.addWindowStateListener(new WindowStateListener()
				{

					@Override
					public void windowStateChanged(WindowEvent e) {
						// TODO Auto-generated method
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//adjustLayout();
						setSize(getWidth()+1,getHeight()+1);
					}
			
				});
	}
	
	/**
	 * 这个函数用来微调窗口的布局 设定制定控件的大小
	 */
	public void adjustLayout()
	{
		int widthMain=this.getWidth();
		int heightMain=this.getHeight();
		textSearch.setPreferredSize(new Dimension(widthMain-MAINFRAME_WIDTH_BUTTON_SEARCH-20,MAINFRAME_HEIGHT_TOP_LINE));
		btnSearch.setPreferredSize(new Dimension(MAINFRAME_WIDTH_BUTTON_SEARCH,MAINFRAME_HEIGHT_TOP_LINE));
		textMeanings.setPreferredSize(new Dimension(widthMain-10,heightMain-mb.getHeight()-4*MAINFRAME_HEIGHT_LAST_LINE-MAINFRAME_HEIGHT_TOP_LINE));
		btnAddToNotepad.setPreferredSize(new Dimension(widthMain-10,MAINFRAME_HEIGHT_LAST_LINE));
	}
}
