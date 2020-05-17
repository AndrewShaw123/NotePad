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
	 * �����ı������ڵĸı�������Ӷ��ж��Ƿ���Ҫ�Ըı����ݽ�������ı�
	 * ��Bug������
	 */
	
	private Style keyWordStyle;
	private Style whiteWordStyle;
	private Style blackWordStyle;
	
	private int start=0;
	private int len=0;
	
	private StyledDocument doc;
	
	private String text;
	private final String regex="(?<!\\w)(public|private|protected|static|void|import|package|class|;)(?!\\w)";//������ʽ
	private Pattern p=Pattern.compile(regex);
	
	
	{
		/*
		 * ���ø����������������
		 */
		keyWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("keyWordStyle",null);
		whiteWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("whiteWordStyle",null);
		blackWordStyle=((StyledDocument)App.ta.getDocument()).addStyle("blackWordStyle",null);
		StyleConstants.setForeground(keyWordStyle,Color.RED);//�������������
		StyleConstants.setBold(keyWordStyle,true);
		StyleConstants.setForeground(whiteWordStyle,Color.WHITE);//��δ�õ�
		StyleConstants.setBold(whiteWordStyle,true);
		StyleConstants.setForeground(blackWordStyle,Color.BLACK);////��δ�õ�
	}
	
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		
		/*
		 * Ϊ��ʹ��StyledDocument��setCharacterAttributes(int offset, int length, AttributeSet s, boolean replace);����
		 * ��DocumentǿתΪStyledDocument��StyledDocument�̳�Document��
		 */
		doc=(StyledDocument)e.getDocument();
		text=App.ta.getText();
		
		Matcher m=p.matcher(text);//����ı�����ȥƥ������
				
		while(m.find()) {
			
			start=text.indexOf(m.group(),start);
			len=m.group().length();
			
			//System.out.println("�ҵ�����---->"+m.group());
			
			if(start!=-1){
				//System.out.println("��"+start+"��"+len);
				SwingUtilities.invokeLater(new HighLight(doc,start,len,keyWordStyle));//����һ���µ��߳�ȥ�ı�StyledDocument�����ԣ�HighLight�Ǹ��ڲ����������н��ͣ�
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
		//����Ҫ
	}
	
	
	private class HighLight implements Runnable {
		/*
		 *  doc.setCharacterAttributes(start,len,style,true);
		 *  �������ֱ����Swing�����߳���ʹ�û���ִ������԰����ŵ���һ�����￪��һ���µ��߳�
		 * 	Ȼ����ʹ��ʱ����SwingUtilities.invokeLater
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
			doc.setCharacterAttributes(start,len,style,true);//�ı�ָ�����������
		}
		
	}


}



