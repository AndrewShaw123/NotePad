package com.andrew.control.helpcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpActionListener implements ActionListener{
	/*
	 * ���������ܵļ�����
	 * ûʲô��������������
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("�鿴����(H)")) {
			help();
		}else if(temp.equals("���ڼ��±�(A)")){
			about();
		}
		
	}
	
	private void help() {
		System.out.println("https://www.baidu.com");
	}
	
	private void about() {
		System.out.println("���--��2��--Ф����");
	}
	
	
	
	

}
