package com.andrew.control.editcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.andrew.view.App;
import com.andrew.view.Find;

public class FindActionListener implements ActionListener{
	/*
	 * 查找选项功能的监听器
	 */
	
	private String needFind=null;
	private String text=null;
	private boolean isIgnoreCase=false;
	private boolean isDown=true;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp=e.getActionCommand();
			
		if(Find.rb2.isSelected()) {
			isDown=true;
		}else if(Find.rb1.isSelected()) {
			isDown=false;
		}
		
		
		if(temp.equals("查找下一个(F)")) {
			findNext();
		}else if(temp.equals("       取消         ")) {
			exitReplace();
		}else if(Find.cb.isSelected()) {
			isIgnoreCase=true;
		}else if(!(Find.cb.isSelected())) {
			isIgnoreCase=false;
		}
		
	}
	
	private void findNext() {
		
		ignoreCase(isIgnoreCase);
		if(isDown) {
			findDown();
		}else {
			findUp();
		}
		
	}
	
	private void exitReplace() {
		Find.frm.dispose();
	}
	
	private void ignoreCase(boolean isIgnoreCase) {
		if(isIgnoreCase) {
			needFind=Find.tf.getText().toUpperCase();
			text=App.ta.getText().toUpperCase();
		}else {
			needFind=Find.tf.getText();
			text=App.ta.getText();
		}
	}
	
	private void findDown() {
		
		int temp=text.indexOf(needFind,App.ta.getSelectionEnd());
		if(temp==-1) {
			JOptionPane.showMessageDialog(Find.frm, "找不到"+Find.tf.getText(), "记事本",JOptionPane.INFORMATION_MESSAGE);
		}else {
			App.ta.setSelectionStart(temp);
			App.ta.setSelectionEnd(temp+needFind.length());
		}
		
	}
	
	
	private void findUp() {
		
		int temp=text.lastIndexOf(needFind,App.ta.getCaretPosition()-needFind.length()-1);
		
		if(temp==-1) {
			JOptionPane.showMessageDialog(Find.frm, "找不到"+Find.tf.getText(), "记事本",JOptionPane.INFORMATION_MESSAGE);
		}else {
			App.ta.select(temp, temp+needFind.length());
		}
		
	}
	

}
