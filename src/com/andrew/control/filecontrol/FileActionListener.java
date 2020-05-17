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
	 * �ļ������ܵļ�����
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp=e.getActionCommand();
		if(temp.equals("�½�(N)")) {
			createNewFile();
		}else if(temp.equals("��(O)...")) {
			openFile();
		}else if(temp.equals("����(S)")) {
			saveFile();
		}else if(temp.equals("���Ϊ(A)")) {
			saveAs();
		}else if(temp.equals("�˳�(X)")) {
			exit();
		}else if(temp.equals("ҳ������(U)...")) {
			pageset();
		}
		
	}
	
	
	private void createNewFile() {//�½�����
		
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
	
	private void openFile() {//���ļ�����
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
	
	private void saveFile() {//���湦��
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
	
	private void saveAs() {//���Ϊ����
		
		if(App.fc==null) {
			App.fc=new JFileChooser();
		}
		
		int temp=App.fc.showSaveDialog(App.frm);
		if(temp==JFileChooser.APPROVE_OPTION){
			saveFile();
		}
		
	}
	
	public void exit() {//�˳�����
		
		if(App.fc==null&&(App.ta.getText().equals(""))) {//û��ѡ��·������Ϊ��ʱֱ���˳�
			System.exit(0);
		}
		else if(App.fc==null) {//���ݲ�Ϊ�� û��ѡ��·��ʱ �����˳�
			remindExit();
		}else if(App.fc.getSelectedFile()!=null&&Utils.isChange(App.ta.getText(),App.fc.getSelectedFile())) {//ѡ��·�� �ı������ı�ʱ�����˳�
			remindExit();
		}else if(!App.ta.getText().equals("")&&App.fc.getSelectedFile()==null) {//�ı���Ϊ�� û��ѡ��·����ʱ�����˳�
			remindExit();
		}else {//�������ֱ���˳�
			System.exit(0);
		}
		
	}
	
	private void remindExit() {//�����˳�����
		int result = JOptionPane.showOptionDialog(App.frm, "�Ƿ񽫸��ı��浽  "+App.frm.getTitle()+"?","���±�", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"����","������","ȡ��"}, JOptionPane.CANCEL_OPTION); 
		if(result == JOptionPane.OK_OPTION){
			saveFile();
		}else if(result==JOptionPane.CANCEL_OPTION) {
			 return;
		}else {
			System.exit(0);
		}
	}
	
	private void setNewTitle(File file) {//�ı�������Ʒ���
		
		file=App.fc.getSelectedFile();
		String path=file.getAbsolutePath();
		int index=path.lastIndexOf("\\"); 
		String sub=path.substring(index+1);//���·�������ļ�����
		App.frm.setTitle(sub);
		
	}
	
	private void pageset() {//ҳ�����ù���
		
		//PageFormat pf=new PageFormat();
		//PrinterJob.getPrinterJob().pageDialog(pf);//�����������ֱ�ӳ���ҳ�����ý���
		
		PageSetting page=new PageSetting();//ҳ�����ý���
		page.showPageSetting();
	}

}
