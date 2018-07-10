/**
 * 
 */
package model;

/**
 * @author wsl
 *
 */
public class Word {
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * @return the gQS
	 */
	public String getGQS() {
		return GQS;
	}
	/**
	 * @param gQS the gQS to set
	 */
	public void setGQS(String gQS) {
		GQS = gQS;
	}
	/**
	 * @return the gQFC
	 */
	public String getGQFC() {
		return GQFC;
	}
	/**
	 * @param gQFC the gQFC to set
	 */
	public void setGQFC(String gQFC) {
		GQFC = gQFC;
	}
	/**
	 * @return the xZFC
	 */
	public String getXZFC() {
		return XZFC;
	}
	/**
	 * @param xZFC the xZFC to set
	 */
	public void setXZFC(String xZFC) {
		XZFC = xZFC;
	}
	/**
	 * @return the fS
	 */
	public String getFS() {
		return FS;
	}
	/**
	 * @param fS the fS to set
	 */
	public void setFS(String fS) {
		FS = fS;
	}
	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}
	/**
	 * @param meaning the meaning to set
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	/**
	 * @return the lx
	 */
	public String getLx() {
		return lx;
	}
	/**
	 * @param lx the lx to set
	 */
	public void setLx(String lx) {
		this.lx = lx;
	}
	private int id=0;
	private String word="";
	private String GQS="";	
	private String GQFC="";
	private String XZFC="";
	private String FS="";
	private String meaning="";
	private String lx="";
	
}
