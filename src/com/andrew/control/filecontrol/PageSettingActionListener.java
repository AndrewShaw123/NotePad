package com.andrew.control.filecontrol;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.andrew.view.App;
import com.andrew.view.PageSetting;
@SuppressWarnings("all")
public class PageSettingActionListener implements ActionListener,Printable,DocumentListener{
	/*
	 * ҳ������ѡ��ܵļ�����
	 */
	
	public static PageFormat pf=new PageFormat();
	public static Paper p=new Paper();
	private static boolean flag=true;//�жϺ�����flag
	
	private int left=Integer.parseInt(PageSetting.tf1.getText());//��ȡ����
	private int right=Integer.parseInt(PageSetting.tf2.getText());
	private int top=Integer.parseInt(PageSetting.tf3.getText());
	private int down=Integer.parseInt(PageSetting.tf4.getText());
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp=e.getActionCommand();
		int size=PageSetting.cb1.getSelectedIndex();
		//int autoSelect=PageSetting.cb2.getSelectedIndex();
		
		if(PageSetting.rb1.isSelected()) {
			pf.setOrientation(PageFormat.PORTRAIT);//����ֽ��Ϊ����
			PageSetting.l8.setVisible(flag);
			PageSetting.l7.setVisible(!flag);
		}else if(PageSetting.rb2.isSelected()) {
			pf.setOrientation(PageFormat.LANDSCAPE);//����ֽ��Ϊ����
			PageSetting.l8.setVisible(!flag);
			PageSetting.l7.setVisible(flag);
		}
		
		if(temp.equals("ȷ��")) {
			App.book.append(this,pf);//����ʵ�ֺ����Ĵ�ӡ����
			PageSetting.frm.dispose();
		}else if(temp.equals("ȡ��")) {
			PageSetting.frm.dispose();
		}
		
		
		if(size==0) {//��ֽ
			p.setSize(240,139);
			p.setImageableArea(72, 72,240,139);
			pf.setPaper(p);
		}else if(size==1) {//A4
			p.setSize(590, 840);
			p.setImageableArea(72, 72, 590, 840);
			pf.setPaper(p);
		}
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		//TODO
		return Printable.PAGE_EXISTS;
	}
	//-------------------------------------------------------------------------
	
	/*
	 * ����JTextField�仯������
	 * �ﵽ�ı�߾��Ч��
	 */

	@Override
	public void insertUpdate(DocumentEvent e) {
		/*
		PageSetting.l7.setBorder(new EmptyBorder(top, left, down, right));
		PageSetting.l8.setBorder(new EmptyBorder(top, left, down, right));		
		PageSetting.l7.repaint();
		*/
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		/*
		PageSetting.l7.setBorder(new EmptyBorder(/top, left, down, right));
		PageSetting.l8.setBorder(new EmptyBorder(top, left, down, right));
		PageSetting.l7.repaint();
		*/
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		//����Ҫ
	}


}
