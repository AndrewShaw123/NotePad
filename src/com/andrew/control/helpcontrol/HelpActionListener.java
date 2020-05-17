package com.andrew.control.helpcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpActionListener implements ActionListener{
	/*
	 * 帮助栏功能的监听器
	 * 没什么用拿来凑数的类
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("查看帮助(H)")) {
			help();
		}else if(temp.equals("关于记事本(A)")){
			about();
		}
		
	}
	
	private void help() {
		System.out.println("https://www.baidu.com");
	}
	
	private void about() {
		System.out.println("大二--软工2班--肖嘉鑫");
	}
	
	
	
	

}
