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

public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return the tipUserName
	 */
	public JLabel getTipUserName() {
		return tipUserName;
	}

	/**
	 * @param tipUserName the tipUserName to set
	 */
	public void setTipUserName(JLabel tipUserName) {
		this.tipUserName = tipUserName;
	}

	/**
	 * @return the textUserName
	 */
	public JTextField getTextUserName() {
		return textUserName;
	}

	/**
	 * @param textUserName the textUserName to set
	 */
	public void setTextUserName(JTextField textUserName) {
		this.textUserName = textUserName;
	}

	/**
	 * @return the tipPassword
	 */
	public JLabel getTipPassword() {
		return tipPassword;
	}

	/**
	 * @param tipPassword the tipPassword to set
	 */
	public void setTipPassword(JLabel tipPassword) {
		this.tipPassword = tipPassword;
	}

	/**
	 * @return the textPassword
	 */
	public JPasswordField getTextPassword() {
		return textPassword;
	}

	/**
	 * @param textPassword the textPassword to set
	 */
	public void setTextPassword(JPasswordField textPassword) {
		this.textPassword = textPassword;
	}

	/**
	 * @return the btnLogin
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @param btnLogin the btnLogin to set
	 */
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	/**
	 * @return the btnRigister
	 */
	public JButton getBtnRigister() {
		return btnRigester;
	}

	/**
	 * @param btnRigister the btnRigister to set
	 */
	public void setBtnRigister(JButton btnRigister) {
		this.btnRigester = btnRigister;
	}

	private JLabel	tipUserName=new JLabel();
	private JTextField textUserName=new JTextField();
	private JLabel tipPassword=new JLabel();
	private JPasswordField textPassword=new JPasswordField();
	private JButton btnLogin=new JButton();
	private JButton btnRigester=new JButton();
	public LoginFrame()
	{
		this.initView();
	}
	
	public void initView()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(tipUserName);
		this.add(textUserName);
		this.add(tipPassword);
		this.add(textPassword);
		this.add(btnLogin);
		this.add(btnRigester);
		int lan=Settings.getLanguage();
		this.setTitle(CONSTS.LOGIN_TITLE[lan]);
		this.tipUserName.setText(CONSTS.LOGIN_TIP_USERNAME[lan]);
		this.tipPassword.setText(CONSTS.LOGIN_TIP_PASSWORD[lan]);
		this.btnLogin.setText(CONSTS.LOGIN_BUTTON_LOGIN[lan]);
		this.btnRigester.setText(CONSTS.LOGIN_BUTTON_REGESTOR[lan]);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustLayout();
			}
		});
		this.addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				// TODO Auto-generated method
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// adjustLayout();
				setSize(getWidth() + 1, getHeight() + 1);
			}

		});
	}

	public void adjustLayout()
	{
		int width=this.getWidth();
		int height=this.getHeight();
		this.tipUserName.setPreferredSize(new Dimension(width-10,height/7));
		this.textUserName.setPreferredSize(new Dimension(width-10,height/14));
		this.tipPassword.setPreferredSize(new Dimension(width-10,height/7));
		this.textPassword.setPreferredSize(new Dimension(width-10,height/14));
		this.btnLogin.setPreferredSize(new Dimension(width-10,height/9));
		this.btnRigester.setPreferredSize(new Dimension(width-10,height/9));
	}
	
}
