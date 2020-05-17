package com.andrew.control.formatcontrol;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import com.andrew.model.MyJTextPane;
import com.andrew.view.App;
import com.andrew.view.NewFont;
@SuppressWarnings("all")
public class FormatActionListener implements ActionListener{
	/*
	 * 格式栏功能的监听器
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp=e.getActionCommand();
		if(temp.equals("自动换行(W)")) {
			wrap();
		}else if(temp.equals("字体(F)...")) {
			font();
		}
		
	}
	
	private void wrap() {
		//App.ta.setLineWrap(flag);JTextArea使用这个，切换为JTextPane后没有这个方法，所以使用继承JTextPane的方法来实现
		MyJTextPane.setFlag(!(MyJTextPane.getFlag()));
	}
	
	private void font() {
		NewFont nf=new NewFont();
		nf.showNewFont();
	}    
    
    
}
