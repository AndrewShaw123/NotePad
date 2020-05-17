package com.andrew.control.highlightcontrol;


import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.andrew.view.App;
@SuppressWarnings("all")
public class TextAreaListener implements DocumentListener{
	/*
	 * 监听文本区域内的改变情况，从而判断是否需要对改变内容进行字体改变
	 * 有Bug待改善
	 */
	
	private Style keyWordStyle;
	private Style whiteWordStyle;
	private Style blackWordStyle;
	
	private int start=0;
	private int len=0;
	
	private StyledDocument doc;
	
	private String text;
	private final String regex="(?<!\\w)(public|private|protected|static|void|import|package|class|;)(?!\\w)";//正则表达式
	private Pattern p=Pattern.compile(regex);
	
	
	{
		/*
		 * 设置高亮代码的字体类型
		 */
		keyWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("keyWordStyle",null);
		whiteWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("whiteWordStyle",null);
		blackWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("blackWordStyle",null);
		StyleConstants.setForeground(keyWordStyle,Color.RED);//代码高亮的字体
		StyleConstants.setBold(keyWordStyle,true);
		StyleConstants.setForeground(whiteWordStyle,Color.WHITE);//尚未用到
		StyleConstants.setBold(whiteWordStyle,true);
		StyleConstants.setForeground(blackWordStyle,Color.BLACK);////尚未用到
	}
	
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		
		/*
		 * 为了使用StyledDocument的setCharacterAttributes(int offset, int length, AttributeSet s, boolean replace);方法
		 * 把Document强转为StyledDocument（StyledDocument继承Document）
		 */
		doc=(StyledDocument)e.getDocument();
		text=App.ta.getText();
		
		Matcher m=p.matcher(text);//获得文本内容去匹配正则
				
		while(m.find()) {
			
			start=text.indexOf(m.group(),start);
			len=m.group().length();
			
			//System.out.println("找到的组---->"+m.group());
			
			if(start!=-1){
				//System.out.println("："+start+"："+len);
				SwingUtilities.invokeLater(new HighLight(doc,start,len,keyWordStyle));//开启一个新的线程去改变StyledDocument的属性（HighLight是个内部类在下面有解释）
			}
			start=start+m.group().length();
			
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		
		//doc=(StyledDocument)e.getDocument();
		//text=App.ta.getText();
		//SwingUtilities.invokeLater(new HighLight(doc,start,len,normalWordStyle));
		//TODO
		
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		//不需要
	}
	
	
	private class HighLight implements Runnable {
		/*
		 *  doc.setCharacterAttributes(start,len,style,true);
		 *  这个方法直接在Swing的主线程里使用会出现错误，所以把它放到另一个类里开启一个新的线程
		 * 	然后在使用时调用SwingUtilities.invokeLater
		 * 
		 */
		private StyledDocument doc;
		private Style style;
		private int start;
		private int len;

		public HighLight(StyledDocument doc, int start, int len, Style style) {
			this.doc = doc;
			this.start = start;
			this.len = len;
			this.style = style;
		}

		public void run() {
			doc.setCharacterAttributes(start,len,style,true);//改变指定区域的字体
		}
		
	}


}



