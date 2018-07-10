package model;

import java.util.ArrayList;
import java.util.List;

import utils.CONSTS;

public class NotepadList {
	private List<String> words=new ArrayList<String>();

	/**
	 * @return the words
	 */
	public List<String> getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(List<String> words) {
		this.words = words;
	}
	
	public void parseWords(String userWords)
	{
		String[] datas=userWords.split(CONSTS.WORD_LIST_SPLIT);
		for(String s:datas)
		{
			this.words.add(s);
		}
	}
	
	public void syncUserWords(String uName)
	{
		String update="";
		if(this.words.size()==0)
		{
			new UserDao().updateUserWords(uName,update);
			return ;
		}
		for(String s:this.words)
		{
			update+=s+"#";
		}
		update=update.substring(0, update.length()-1);
		new UserDao().updateUserWords(uName,update);
	}
}
