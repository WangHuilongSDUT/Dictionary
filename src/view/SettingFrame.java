package view;

import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import controller.Settings;
import utils.CONSTS;

public class SettingFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup bg=new ButtonGroup();
	private JRadioButton rdChinese=new JRadioButton();
	private JRadioButton rdEnglish=new JRadioButton();
	public SettingFrame()
	{
		this.add(rdChinese);
		this.add(rdEnglish);
		bg.add(rdChinese);
		bg.add(rdEnglish);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		int lan=Settings.getLanguage();
		this.rdChinese.setText(CONSTS.SETTINGS_RADIO_CHINESE[lan]);
		this.rdEnglish.setText(CONSTS.SETTINGS_RADIO_ENGLISG[lan]);
		this.setTitle(CONSTS.SETTINGS_TITLE[lan]);
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
		
	}
	/**
	 * @return the rdChinese
	 */
	public JRadioButton getRdChinese() {
		return rdChinese;
	}
	/**
	 * @param rdChinese the rdChinese to set
	 */
	public void setRdChinese(JRadioButton rdChinese) {
		this.rdChinese = rdChinese;
	}
	/**
	 * @return the rdEnglisg
	 */
	public JRadioButton getRdEnglish() {
		return rdEnglish;
	}
	/**
	 * @param rdEnglisg the rdEnglisg to set
	 */
	public void setRdEnglish(JRadioButton rdEnglish) {
		this.rdEnglish = rdEnglish;
	}
	/**
	 * @return the bg
	 */
	public ButtonGroup getBg() {
		return bg;
	}
	/**
	 * @param bg the bg to set
	 */
	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}
	
}
