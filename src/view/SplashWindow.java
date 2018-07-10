/**
 * 
 */
package view;


import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author wsl
 *
 */
public class SplashWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container ct;
	//创建背景面板。
	private BackgroundPanel bgp;
	
	//创建一个按钮，用来证明我们的确是创建了背景图片，而不是一张图片。

	/**
	 * @return the ct
	 */
	public Container getCt() {
		return ct;
	}

	/**
	 * @param ct the ct to set
	 */
	public void setCt(Container ct) {
		this.ct = ct;
	}

	/**
	 * @return the bgp
	 */
	public BackgroundPanel getBgp() {
		return bgp;
	}

	/**
	 * @param bgp the bgp to set
	 */
	public void setBgp(BackgroundPanel bgp) {
		this.bgp = bgp;
	}

	public SplashWindow()
	{
		ct=this.getContentPane();
		this.setLayout(null);
		
		//在这里随便找一张400*300的照片既可以看到测试结果。
		bgp=new BackgroundPanel((new ImageIcon("splash.png")).getImage());
		ct.add(bgp);
		this.setUndecorated(true);
		this.setVisible(true);

	}
}


