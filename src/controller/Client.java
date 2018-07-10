package controller;

import view.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.*;
import utils.CONSTS;

public class Client {


	/**
	 * @return the windowSplash
	 */
	public static SplashWindow getWindowSplash() {
		return windowSplash;
	}

	/**
	 * @param windowSplash the windowSplash to set
	 */
	public static void setWindowSplash(SplashWindow windowSplash) {
		Client.windowSplash = windowSplash;
	}

	/**
	 * @return the windowMain
	 */
	public static MainFrame getWindowMain() {
		return windowMain;
	}

	/**
	 * @param windowMain the windowMain to set
	 */
	public static void setWindowMain(MainFrame windowMain) {
		Client.windowMain = windowMain;
	}

	/**
	 * @return the windowLogin
	 */
	public static LoginFrame getWindowLogin() {
		return windowLogin;
	}

	/**
	 * @param windowLogin the windowLogin to set
	 */
	public static void setWindowLogin(LoginFrame windowLogin) {
		Client.windowLogin = windowLogin;
	}

	/**
	 * @return the windowNP
	 */
	public static NotePad getWindowNP() {
		return windowNP;
	}

	/**
	 * @param windowNP the windowNP to set
	 */
	public static void setWindowNP(NotePad windowNP) {
		Client.windowNP = windowNP;
	}

	/**
	 * @return the windowRem
	 */
	public static RememberWords getWindowRem() {
		return windowRem;
	}

	/**
	 * @param windowRem the windowRem to set
	 */
	public static void setWindowRem(RememberWords windowRem) {
		Client.windowRem = windowRem;
	}

	private static SplashWindow windowSplash=null;
	private static MainFrame windowMain=null;
	private static LoginFrame windowLogin=null;
	private static NotePad windowNP=null;
	private static RememberWords windowRem=null;
	private static SettingFrame windowSettings=null;
	private static User mainUser=null;
	private static NotepadList npList=null;
	/**
	 * @return the tempWords
	 */
	public static List<String> getTempWords() {
		return tempWords;
	}

	/**
	 * @param tempWords the tempWords to set
	 */
	public static void setTempWords(List<String> tempWords) {
		Client.tempWords = tempWords;
	}

	private static List<String> tempWords=null;
	private static void initViewSizes()
	{
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		Client.windowSplash.setSize(width/3,height/3);
		Client.windowSplash.setLocation(width/3,height/3);
		Client.windowSplash.getBgp().setBounds(0,0,width/3,height/3);
		
		Client.windowMain.setSize(width/3,height/3*2);
		Client.windowMain.setLocation(width/3,height/6);
		Client.windowMain.adjustLayout();
		
		Client.windowLogin.setSize(width/5,height/5);
		Client.windowLogin.setLocation(width/5*2,height/5*2);
		Client.windowLogin.adjustLayout();
		
		Client.windowNP.setSize(width/3,height/3*2);
		Client.windowNP.setLocation(width/3,height/6);
		Client.windowNP.adjustLayout();
		
		Client.windowRem.setSize(width/3,height/3*2);
		Client.windowRem.setLocation(width/3,height/6);
		Client.windowRem.adjustLayout();
		
		Client.windowSettings.setSize(width/6,height/6);
		Client.windowSettings.setLocation(width/12*5,height/12*5);
		Client.windowSettings.adjustLayout();
	}
	
	private static void initListeners()
	{
		int menuCount=Client.windowMain.getMb().getMenuCount();
		ActionListener menuItemListener=new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_LOGIN[Settings.getLanguage()]))
						{
							Client.windowLogin.setVisible(true);						
						}
						else if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_EXIT[Settings.getLanguage()]))
						{
							Client.exitProgram();
						}
						else if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_NOTEPAD[Settings.getLanguage()]))
						{
							if(Client.getMainUser()==null)
							{
								JOptionPane.showMessageDialog(Client.windowMain,CONSTS.MAIN_FRAME_LOGIN_FIRST[Settings.getLanguage()]);
								return ;
							}
							
							List<String> listWords=Client.npList.getWords();
							DefaultListModel<String> modelWord = (DefaultListModel<String>)Client.windowNP.getCmWords().getModel();
							DefaultListModel<String> modelMeaning = (DefaultListModel<String>)Client.windowNP.getCmMeaning().getModel();
							modelWord.removeAllElements();
							modelMeaning.removeAllElements();
							WordDao wd=new WordDao();

							for(String s:listWords)
							{
								Word w=wd.queryWord(s);
								modelWord.addElement(s);
								modelMeaning.addElement(w.getMeaning());
							}
							Client.windowNP.setVisible(true);
						}				
						else if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_SETTINGS[Settings.getLanguage()]))
						{
							if(Settings.getLanguage()==CONSTS.LANGUAGE_CHINESE)
							{
								Client.windowSettings.getRdChinese().setSelected(true);
							}
							else
							{
								Client.windowSettings.getRdEnglish().setSelected(true);
							}
							Client.windowSettings.setVisible(true);
						}
						else if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_VERSION[Settings.getLanguage()]))
						{
							JOptionPane.showMessageDialog(windowMain,CONSTS.VERSION );
						}
						else if(arg0.getActionCommand().equals(CONSTS.MENU_STRING_AUTHOR[Settings.getLanguage()]))
						{
							JOptionPane.showMessageDialog(windowMain,CONSTS.AUTHOR);
						}
					}
			
				};		

		for(int i=0;i<menuCount;i++)
		{
			JMenu m=Client.windowMain.getMb().getMenu(i);
			int itemCount=m.getItemCount();
			for(int j=0;j<itemCount;j++)
			{
				JMenuItem item=m.getItem(j);
				item.addActionListener(menuItemListener);
			}
		}
		Client.windowMain.addWindowListener(new WindowAdapter() {
			 
			 
			public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
				exitProgram();
			 }
		}
);
		Client.windowMain.getBtnSearch().addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String word=Client.windowMain.getTextSearch().getText();
						Word w=new WordDao().queryWord(word);
						if(0==w.getId())
						{
							Client.windowMain.getTextMeanings().setText("");
							return ;
						}
						Client.windowMain.getTextMeanings().setText(w.getMeaning()+"\r\n"+w.getLx());
					}
					
				}
				);
		Client.windowMain.getBtnAddToNotepad().addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(Client.mainUser!=null)
						{
							List<String> words=Client.getNpList().getWords();
							String word=Client.getWindowMain().getTextSearch().getText().trim();
							if(words.contains(word.toLowerCase())||words.contains(word.toUpperCase()))
							{
								return ;
							}
							words.add(word);
						}
					}
					
				}
				);
		Client.windowLogin.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String userName=Client.windowLogin.getTextUserName().getText().trim();
				String password=String.valueOf(Client.windowLogin.getTextPassword().getPassword());
				User u=new UserDao().getUser(userName);
				if(!u.getPassword().equals(password))
				{
					JOptionPane.showMessageDialog(windowLogin, CONSTS.LOGIN_STRING_LOGIN_FAILED[Settings.getLanguage()]);
					return ;
				}
				Client.setMainUser(u);	
				NotepadList np=new NotepadList();
				if(u.getWords()==null||u.getWords().equals(""))
				{
					u.setWords("");
				}
				else
				{
					np.parseWords(u.getWords());
				}
				
				Client.setNpList(np);
				Client.windowLogin.setVisible(false);
			}
			
		});
		Client.getWindowLogin().getBtnRigister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String userName=Client.windowLogin.getTextUserName().getText().trim();
				String password=String.valueOf(Client.windowLogin.getTextPassword().getPassword());
				UserDao ud=new UserDao();
				if(ud.isUserExist(userName))
				{
					JOptionPane.showMessageDialog(windowLogin, CONSTS.LOGIN_USER_ALREADY_EXISTS[Settings.getLanguage()]);				
					return ;
				}
				ud.createUser(userName, password);
				JOptionPane.showMessageDialog(windowLogin, CONSTS.LOGIN_USER_REG_SUCCESS[Settings.getLanguage()]);				
	
			}
			
		});
		Client.windowNP.getBtnRemove().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultListModel<String> modelWord = (DefaultListModel<String>)Client.windowNP.getCmWords().getModel();
				DefaultListModel<String> modelMeaning = (DefaultListModel<String>)Client.windowNP.getCmMeaning().getModel();
				int index=Client.windowNP.getCmWords().getSelectedIndex();
				if(-1==index)
				{
					return ;
				}
				String wordrm=modelWord.get(index);
				Client.npList.getWords().remove(wordrm);
				modelWord.remove(index);
				modelMeaning.remove(index);
			}
			
		});
		Client.windowNP.getBtnRememberWords().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Client.npList.getWords().size()==0)
				{
					JOptionPane.showMessageDialog(windowRem, CONSTS.REMEMBER_TIP_YOUNOWORDS[Settings.getLanguage()]);				
					return ;
				}
				Client.windowNP.setVisible(false);
				Client.windowRem.setVisible(true);
				tempWords=new ArrayList<String>();
				tempWords.addAll(Client.npList.getWords());
				Client.setTempWords(tempWords);
				Client.windowRem.getLabelWord().setText(tempWords.get(0));
			}
		});
		Client.windowRem.getBtnViewMeaning().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Client.windowRem.getLabelMeaning().setText(new WordDao().queryWord(Client.windowRem.getLabelWord().getText().trim()).getMeaning());
			}
			
		});
		Client.windowRem.getBtnRemembered().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Client.windowRem.getLabelMeaning().setText("");
				String word=Client.windowRem.getLabelWord().getText().trim();
				int positon=Client.tempWords.indexOf(word);
				Client.tempWords.remove(word);
				if(Client.tempWords.size()==0)
				{
					JOptionPane.showMessageDialog(windowRem, CONSTS.REMEMBER_TIP_ALL[Settings.getLanguage()]);
					Client.windowRem.setVisible(false);
					return ;
				}
				Client.windowRem.getLabelWord().setText(Client.tempWords.get(positon));
			}
			
		});
		ActionListener settingListener=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(Client.windowSettings.getRdChinese().isSelected())
				{
					Settings.setLanguage(CONSTS.LANGUAGE_CHINESE);
					JOptionPane.showMessageDialog(windowRem, CONSTS.SETTINGS_SET_SUCCESS[Settings.getLanguage()]);
				}
				else if(Client.windowSettings.getRdEnglish().isSelected())
				{
					Settings.setLanguage(CONSTS.LANGUAGE_ENGLISH);
					JOptionPane.showMessageDialog(windowRem, CONSTS.SETTINGS_SET_SUCCESS[Settings.getLanguage()]);
				}
			}
			
		};
		Client.windowSettings.getRdChinese().addActionListener(settingListener);
		Client.windowSettings.getRdEnglish().addActionListener(settingListener);
		
	}
	
	private static void initProgram()
	{

		Settings.initSettings();
		Font f = new Font("华文行楷",Font.PLAIN,18);
		String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
				"JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
				"TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
				"OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
				"ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
				"PasswordField","TextField", "Table", "Label", "Viewport",
				"RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
		}; 
		for (String item : names) {
			 UIManager.put(item+ ".font",f); 
		}
		windowSplash=new SplashWindow();
		windowMain=new MainFrame();
		windowLogin=new LoginFrame();
		windowNP=new NotePad();
		windowRem=new RememberWords();
		windowSettings=new SettingFrame();
		initViewSizes();
		initListeners();
	}
	
	private static void runProgram()
	{
		initProgram();
		windowSplash.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		windowSplash.setVisible(false);
		windowMain.setVisible(true);
	}
	
	private static void exitProgram()
	{
		if(Client.mainUser!=null)
		{
			Client.npList.syncUserWords(Client.mainUser.getName());
		}
		Settings.saveSettings();
		DBConnector.closeDatabaseConnection();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runProgram();
	}

	/**
	 * @return the mainUser
	 */
	public static User getMainUser() {
		return mainUser;
	}

	/**
	 * @param mainUser the mainUser to set
	 */
	public static void setMainUser(User mainUser) {
		Client.mainUser = mainUser;
	}

	/**
	 * @return the npList
	 */
	public static NotepadList getNpList() {
		return npList;
	}

	/**
	 * @param npList the npList to set
	 */
	public static void setNpList(NotepadList npList) {
		Client.npList = npList;
	}

	/**
	 * @return the windowSettings
	 */
	public static SettingFrame getWindowSettings() {
		return windowSettings;
	}

	/**
	 * @param windowSettings the windowSettings to set
	 */
	public static void setWindowSettings(SettingFrame windowSettings) {
		Client.windowSettings = windowSettings;
	}
	

}
