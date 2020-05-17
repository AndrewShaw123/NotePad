package com.andrew.control.formatcontrol;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.andrew.view.App;
import com.andrew.view.NewFont;
@SuppressWarnings("all")
public class NewFontActionListener implements ActionListener,ListSelectionListener{
	/*
	 * 字体选项功能的监听器
	 */
	
	int[] f=new int[]{Font.PLAIN,Font.BOLD,Font.ITALIC,Font.BOLD+Font.ITALIC};
	int[] s=new int[]{8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
	
	private int temp1=0;
	private int temp2=0;
	private int temp3=0;
	
	private String style;
	private int cfont;
	private int size;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp=e.getActionCommand();
		
		if(temp.equals("确认")) {
			setFont();
		}else if(temp.equals("取消")) {
			exitFont();
		}
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		boolean flag1=NewFont.jl1.getValueIsAdjusting();
		boolean flag2=NewFont.jl2.getValueIsAdjusting();
		boolean flag3=NewFont.jl3.getValueIsAdjusting();
		
		if(flag1||flag2||flag3) {
			Font font=getFont();
			NewFont.jta.setFont(font);
		}
		
	}
	
	private void exitFont() {
		NewFont.frm.dispose();
	}
	
	private void setFont() {
		Font font=null;
		font=getFont();
		App.ta.setFont(font);
		NewFont.frm.dispose();
	}
	
	private Font getFont() {
		
		temp1=NewFont.jl1.getSelectedIndex();
		temp2=NewFont.jl2.getSelectedIndex();
		temp3=NewFont.jl3.getSelectedIndex();
		
		style=NewFont.FONT_STYLE[temp1];
		cfont=f[temp2];
		size=s[temp3];
		
		Font font=new Font(style,cfont,size);
		return font;
	}

	

}
