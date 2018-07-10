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
public class NotePad extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> cmWords=new JList<String>();
	private JList<String> cmMeaning=new JList<String>();
	private JButton btnRemove=new JButton();
	private JButton btnRememberWords=new JButton();
	/**
	 * @return the cmWords
	 */
	public JList<String> getCmWords() {
		return cmWords;
	}
	/**
	 * @param cmWords the cmWords to set
	 */
	public void setCmWords(JList<String> cmWords) {
		this.cmWords = cmWords;
	}
	/**
	 * @return the cmMeaning
	 */
	public JList<String> getCmMeaning() {
		return cmMeaning;
	}
	/**
	 * @param cmMeaning the cmMeaning to set
	 */
	public void setCmMeaning(JList<String> cmMeaning) {
		this.cmMeaning = cmMeaning;
	}
	/**
	 * @return the btnRemove
	 */
	public JButton getBtnRemove() {
		return btnRemove;
	}
	/**
	 * @param btnRemove the btnRemove to set
	 */
	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}
	/**
	 * @return the btnRememberWords
	 */
	public JButton getBtnRememberWords() {
		return btnRememberWords;
	}
	/**
	 * @param btnRememberWords the btnRememberWords to set
	 */
	public void setBtnRememberWords(JButton btnRememberWords) {
		this.btnRememberWords = btnRememberWords;
	}
	
	public NotePad()
	{
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		this.cmWords.setModel(listModel );
		DefaultListModel<String> listModel1 = new DefaultListModel<String>();
		this.cmMeaning.setModel(listModel1 );
		this.initView();
	}

	public void initView() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(cmWords);
		this.add(cmMeaning);
		this.add(btnRemove);
		this.add(btnRememberWords);
		this.btnRemove.setText(CONSTS.NOTEPAD_BUTTON_REMOVE[Settings.getLanguage()]);
		this.btnRememberWords.setText(CONSTS.NOTEPAD_BUTTON_REMEBER[Settings.getLanguage()]);
		this.setTitle(CONSTS.NOTEPAD_TITLE[Settings.getLanguage()]);
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
		cmMeaning.setPreferredSize(new Dimension(width/2-10,height/10*7+height/15));
		cmWords.setPreferredSize(new Dimension(width/2-10,height/10*7+height/15));
		btnRemove.setPreferredSize(new Dimension(width-10,height/15));
		btnRememberWords.setPreferredSize(new Dimension(width-10,height/15));
	}
}
