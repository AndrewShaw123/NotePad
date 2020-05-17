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
	 * �༭�����ܵļ�����
	 */
	
	public Clipboard clipboard = App.frm.getToolkit().getSystemClipboard();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("����(T)")) {
			cutting();
		}else if(temp.equals("����(C)")) {
			copy();
		}else if(temp.equals("ճ��(P)")) {
			paste();
		}else if(temp.equals("ɾ��(L)")) {
			delete();
		}else if(temp.equals("����(F)")) {
			find();
		}else if(temp.equals("�滻(R)")) {
			replace();
		}else if(temp.equals("ʱ��/����(D)")) {
			time();
		}else if(temp.equals("����(U)")) {
			undo();
		}
	}
	
	private void cutting() {//���ø��ƺ�ɾ���ķ���
		
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
		
		Find f=new Find();//���ҵ�ҳ��
		f.showFind();
		
	}
	
	private void replace() {
		
		Replace r=new Replace();//�滻��ҳ��
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
