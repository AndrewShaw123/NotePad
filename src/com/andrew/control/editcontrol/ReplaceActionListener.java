package com.andrew.control.editcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.andrew.view.App;
import com.andrew.view.Replace;

public class ReplaceActionListener implements ActionListener{
	/*
	 * 替换选项功能的监听器
	 */
	
	private String replacer=null;
	private String needFind=null;
	private String text=null;
	private boolean flag=true;
	private boolean isIgnoreCase=false;

	@Override
	public void actionPerformed(ActionEvent e) {//不要去掉空格也不要加空格##########跟控件名称绑定
		
		String temp=e.getActionCommand();
		
		if(temp.equals("查找下一个(F)")) {
			findNext();
		}else if(temp.equals("      替换(R)     ")) {
			replace();
		}else if(temp.equals("  全部替换(A)  ")) {
			replaceAll();
		}else if(temp.equals("        取消         ")) {
			exitReplace();
		}else if(Replace.cb.isSelected()) {
			isIgnoreCase=true;
		}else if(!(Replace.cb.isSelected())) {
			isIgnoreCase=false;
		}
	}
	
	private void findNext() {
		
		ignoreCase(isIgnoreCase);
		
		int temp=text.indexOf(needFind,App.ta.getSelectionEnd());
		if(temp==-1) {
			JOptionPane.showMessageDialog(Replace.frm, "找不到"+Replace.tf1.getText(), "记事本",JOptionPane.INFORMATION_MESSAGE);
			flag=false;
		}else {
			App.ta.setSelectionStart(temp);
			App.ta.setSelectionEnd(temp+needFind.length());
			flag=true;
		}
		
	}
	
	private void replace() {
		
		if(Replace.tf1.getText().equals("")) {
			return;
		}
		
		ignoreCase(isIgnoreCase);
		
		findNext();
		if(flag){
			//App.ta.replaceRange(Replace.tf2.getText(),App.ta.getSelectionStart(),App.ta.getSelectionEnd());
			App.ta.replaceSelection(Replace.tf2.getText());
		}
		
	}
	
	private void replaceAll() {//通过字符串拼接的方式全部替换   如：替换BB  aaBBCC-->aa+bb+CC
		
		if(Replace.tf1.getText().equals("")||Replace.tf1.getText().equals(Replace.tf2.getText())) {
			return;
		}
		
		ignoreCase(isIgnoreCase);
		
		int next=0;//索引开始查找的位置
		int index=-1;
		String temp1="";
		String temp2="";
		
		while(true) {
			index=text.indexOf(needFind,next);
			if(index==-1) {
				break;
			}else {
				
				temp1=text.substring(0,index);
				temp2=text.substring(index+needFind.length(), App.ta.getText().length());
				
				text=temp1+replacer+temp2;
				App.ta.setText(App.ta.getText().substring(0,index)+Replace.tf2.getText()+App.ta.getText().substring(index+needFind.length(),App.ta.getText().length()));
				
				next=text.indexOf(needFind,next);
			}
			
		}
		
		
	}
	
	private void exitReplace() {
		Replace.frm.dispose();
	}
	
	private void ignoreCase(boolean isIgnoreCase) {
		
		if(isIgnoreCase) {
			needFind=Replace.tf1.getText().toUpperCase();
			replacer=Replace.tf2.getText().toUpperCase();
			text=App.ta.getText().toUpperCase();
		}else {
			needFind=Replace.tf1.getText();
			replacer=Replace.tf2.getText();
			text=App.ta.getText();
		}
		
		
	}

}
