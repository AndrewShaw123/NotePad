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
	 * ��ʽ�����ܵļ�����
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp=e.getActionCommand();
		if(temp.equals("�Զ�����(W)")) {
			wrap();
		}else if(temp.equals("����(F)...")) {
			font();
		}
		
	}
	
	private void wrap() {
		//App.ta.setLineWrap(flag);JTextAreaʹ��������л�ΪJTextPane��û���������������ʹ�ü̳�JTextPane�ķ�����ʵ��
		MyJTextPane.setFlag(!(MyJTextPane.getFlag()));
	}
	
	private void font() {
		NewFont nf=new NewFont();
		nf.showNewFont();
	}    
    
    
}
