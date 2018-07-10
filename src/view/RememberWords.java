/**
 * 
 */
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
 * @author wsl
 *
 */
public class RememberWords extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelWord=new JLabel();
	private JLabel labelMeaning=new JLabel();
	private JButton btnViewMeaning=new JButton();
	private JButton btnRemembered=new JButton();
	/**
	 * @return the labelWord
	 */
	public JLabel getLabelWord() {
		return labelWord;
	}
	/**
	 * @param labelWord the labelWord to set
	 */
	public void setLabelWord(JLabel labelWord) {
		this.labelWord = labelWord;
	}
	/**
	 * @return the labelMeaning
	 */
	public JLabel getLabelMeaning() {
		return labelMeaning;
	}
	/**
	 * @param labelMeaning the labelMeaning to set
	 */
	public void setLabelMeaning(JLabel labelMeaning) {
		this.labelMeaning = labelMeaning;
	}
	/**
	 * @return the btnViewMeaning
	 */
	public JButton getBtnViewMeaning() {
		return btnViewMeaning;
	}
	/**
	 * @param btnViewMeaning the btnViewMeaning to set
	 */
	public void setBtnViewMeaning(JButton btnViewMeaning) {
		this.btnViewMeaning = btnViewMeaning;
	}
	/**
	 * @return the btnRemembered
	 */
	public JButton getBtnRemembered() {
		return btnRemembered;
	}
	/**
	 * @param btnRemembered the btnRemembered to set
	 */
	public void setBtnRemembered(JButton btnRemembered) {
		this.btnRemembered = btnRemembered;
	}
	public RememberWords()
	{
		this.initView();
	}
	
	public void initView()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(labelWord);
		this.add(labelMeaning);
		this.add(btnViewMeaning);
		this.add(btnRemembered);
		int lan=Settings.getLanguage();
		this.setTitle(CONSTS.REMEMBER_TITLE[lan]);
		this.getBtnRemembered().setText(CONSTS.REMEMBER_BUTTON_REMEMBERED[lan]);
		this.getBtnViewMeaning().setText(CONSTS.REMEMBER_BUTTON_VIEWMEANING[lan]);
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
		labelWord.setPreferredSize(new Dimension(width-10,height/20*7));
		labelMeaning.setPreferredSize(new Dimension(width-10,height/20*7));
		btnViewMeaning.setPreferredSize(new Dimension(width-10,height/16));
		btnRemembered.setPreferredSize(new Dimension(width-10,height/16));
	}
}
