package com.andrew.control.editcontrol;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.undo.UndoManager;

import com.andrew.view.App;
import com.andrew.view.Find;
import com.andrew.view.Replace;
@SuppressWarnings("all")
public class EditAcationListener implements ActionListener{
	/*
	 * 编辑栏功能的监听器
	 */
	
	public Clipboard clipboard = App.frm.getToolkit().getSystemClipboard();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("剪切(T)")) {
			cutting();
		}else if(temp.equals("复制(C)")) {
			copy();
		}else if(temp.equals("粘贴(P)")) {
			paste();
		}else if(temp.equals("删除(L)")) {
			delete();
		}else if(temp.equals("查找(F)")) {
			find();
		}else if(temp.equals("替换(R)")) {
			replace();
		}else if(temp.equals("时间/日期(D)")) {
			time();
		}else if(temp.equals("撤销(U)")) {
			undo();
		}
	}
	
	private void cutting() {//调用复制和删除的方法
		
		App.ta.requestFocus();
		copy();
		delete();
		
	}
	
	private void copy() {
		
		App.ta.requestFocus();
		String text=App.ta.getSelectedText();
		StringSelection select=new StringSelection(text);
		clipboard.setContents(select,null);
		
	}
	
	private void paste() {
		
		 App.ta.requestFocus();
		 Transferable contents=clipboard.getContents(this);
		 if(contents==null) {
			 return;
			 }
		 
		 String text="";
		 try{
			 text=(String)contents.getTransferData(DataFlavor.stringFlavor);
		 }catch (Exception e){
			 e.printStackTrace();
		}
		 
		 App.ta.replaceSelection(text);
		 
	}
	
	private void delete() {
		
		App.ta.requestFocus();
		App.ta.replaceSelection("");
		
	}
	
	private void find() {
		
		Find f=new Find();//查找的页面
		f.showFind();
		
	}
	
	private void replace() {
		
		Replace r=new Replace();//替换的页面
		r.showReplace();
	}
	
	private void time() {
		
		Date date=new Date();
		DateFormat sd=new SimpleDateFormat("HH:mm yyyy/MM/dd");
		String day=sd.format(date);
		App.ta.replaceSelection(day);
		
	}
	
	private void undo() {
		
		if(App.udm.canUndo()) {
			App.udm.undo();
		}
		
	}
	
	

}
