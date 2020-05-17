package com.andrew.control.filecontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.andrew.utils.Utils;
import com.andrew.view.App;
import com.andrew.view.PageSetting;
@SuppressWarnings("all")
public class FileActionListener implements ActionListener{
	/*
	 * 文件栏功能的监听器
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("新建(N)")) {
			createNewFile();
		}else if(temp.equals("打开(O)...")) {
			openFile();
		}else if(temp.equals("保存(S)")) {
			saveFile();
		}else if(temp.equals("另存为(A)")) {
			saveAs();
		}else if(temp.equals("退出(X)")) {
			exit();
		}else if(temp.equals("页面设置(U)...")) {
			pageset();
		}
		
	}
	
	
	private void createNewFile() {//新建功能
		
		if(App.fc==null) {
			App.fc=new JFileChooser();
		}
		
		int temp=App.fc.showSaveDialog(App.frm);
		if(temp==JFileChooser.APPROVE_OPTION){
			String path=(App.fc.getSelectedFile()).getAbsolutePath();
			Utils.createNew(path);
			
			File file=App.fc.getSelectedFile();
			Utils.saveFile(file,App.ta.getText(),App.getEnCodingAndDeCoding());
			setNewTitle(file);
		}
	}
	
	private void openFile() {//打开文件功能
		int temp=0;
		File file;
		App.fc=new JFileChooser();
		temp=App.fc.showOpenDialog(App.frm);
		if(temp==JFileChooser.APPROVE_OPTION){
			file=App.fc.getSelectedFile();
			App.ta.setText(Utils.readFile(file,App.getEnCodingAndDeCoding()));
			
			setNewTitle(file);
		}
		
	}
	
	private void saveFile() {//保存功能
		if(App.fc==null) {
			App.fc=new JFileChooser();
		}
		
		String temp=App.ta.getText();
		File file=null;
		
		if((App.fc.getSelectedFile())==null) {
			int i=App.fc.showSaveDialog(App.frm);
			if(i==JFileChooser.APPROVE_OPTION){
				file=App.fc.getSelectedFile();
				Utils.createNew(file.getAbsolutePath());
				Utils.saveFile(file,temp,App.getEnCodingAndDeCoding());
				setNewTitle(file);
			}
		}else {
			
			file=App.fc.getSelectedFile();
			Utils.saveFile(file,temp,App.getEnCodingAndDeCoding());
			setNewTitle(file);
		}
		
	}
	
	private void saveAs() {//另存为功能
		
		if(App.fc==null) {
			App.fc=new JFileChooser();
		}
		
		int temp=App.fc.showSaveDialog(App.frm);
		if(temp==JFileChooser.APPROVE_OPTION){
			saveFile();
		}
		
	}
	
	public void exit() {//退出功能
		
		if(App.fc==null&&(App.ta.getText().equals(""))) {//没有选择路径内容为空时直接退出
			System.exit(0);
		}
		else if(App.fc==null) {//内容不为空 没有选择路径时 提醒退出
			remindExit();
		}else if(App.fc.getSelectedFile()!=null&&Utils.isChange(App.ta.getText(),App.fc.getSelectedFile())) {//选择路径 文本发生改变时提醒退出
			remindExit();
		}else if(!App.ta.getText().equals("")&&App.fc.getSelectedFile()==null) {//文本不为空 没有选择路径是时提醒退出
			remindExit();
		}else {//其他情况直接退出
			System.exit(0);
		}
		
	}
	
	private void remindExit() {//提醒退出方法
		int result = JOptionPane.showOptionDialog(App.frm, "是否将更改保存到  "+App.frm.getTitle()+"?","记事本", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"保存","不保存","取消"}, JOptionPane.CANCEL_OPTION); 
		if(result == JOptionPane.OK_OPTION){
			saveFile();
		}else if(result==JOptionPane.CANCEL_OPTION) {
			 return;
		}else {
			System.exit(0);
		}
	}
	
	private void setNewTitle(File file) {//改变标题名称方法
		
		file=App.fc.getSelectedFile();
		String path=file.getAbsolutePath();
		int index=path.lastIndexOf("\\"); 
		String sub=path.substring(index+1);//获得路径最后的文件名称
		App.frm.setTitle(sub);
		
	}
	
	private void pageset() {//页面设置功能
		
		//PageFormat pf=new PageFormat();
		//PrinterJob.getPrinterJob().pageDialog(pf);//调用这个可以直接出来页面设置界面
		
		PageSetting page=new PageSetting();//页面设置界面
		page.showPageSetting();
	}

}
