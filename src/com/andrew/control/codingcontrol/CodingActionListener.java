package com.andrew.control.codingcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.andrew.view.App;

public class CodingActionListener implements ActionListener{
	/*
	 * 设置App中的编码格式
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("GBK")) {
			App.setEnCodingAndDeCoding("GBK");
		}else if(temp.equals("UTF-8")){
			App.setEnCodingAndDeCoding("UTF-8");
		}else if(temp.equals("Unicode")) {
			App.setEnCodingAndDeCoding("Unicode");
		}
		
	}

}
