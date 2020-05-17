package com.andrew.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.andrew.control.filecontrol.PageSettingActionListener;
@SuppressWarnings("all")
public class PageSetting {
	/*
	 * 页面设置的界面
	 */
	
	public static JFrame frm=null;
	
	public static JButton b1=null;
	public static JButton b2=null;
	public static JRadioButton rb1=null;
	public static JRadioButton rb2=null;
	
	public static JPanel p1=null;
	public static JPanel p2=null;
	public static JPanel p3=null;
	
	public static JPanel p4=null;
	public static JPanel p5=null;
	public static ButtonGroup bg=null;
	
	public static JPanel p6=null;
	public static JPanel p7=null;
	public static JPanel p8=null;
	
	public static JPanel p9=null;
	
	public static JPanel p10=null;
	
	public static JPanel p11=null;
	
	public static JTextField tf1=null;
	public static JTextField tf2=null;
	public static JTextField tf3=null;
	public static JTextField tf4=null;
	
	public static JLabel l3=null;
	public static JLabel l4=null;
	public static JLabel l5=null;
	public static JLabel l6=null;
	
	public static JLabel l7=null;
	public static JLabel l8=null;
	
	public static JLabel l1=null;
	public static JLabel l2=null;
	
	public static JComboBox cb1=null;
	public static JComboBox cb2=null;
	
	public static PageSettingActionListener psal=null;
	
	public static ImageIcon img1=new ImageIcon("src/img/previewVertical.png");
	public static ImageIcon img2=new ImageIcon("src/img/previewHorizontal.png");
	
	public void showPageSetting() {
		frm=new JFrame();
		frm.setAlwaysOnTop(true);
		frm.setLayout(new FlowLayout());
		
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.setLayout(new GridLayout(2,1));
		p1.setBorder(BorderFactory.createTitledBorder("纸张"));
		l1=new JLabel("大小(Z):");
		l2=new JLabel("来源(S):");
		cb1=new JComboBox();
		cb1.addItem("信纸");
		cb1.addItem("A4");
		cb1.setVisible(true);
		cb1.setSelectedIndex(0);//设置默认
		cb1.setPreferredSize(new Dimension(200, 30));
		cb2=new JComboBox();
		cb2.addItem("自动选择");
		cb2.setVisible(true);
		cb2.setSelectedIndex(0);//设置默认
		cb2.setPreferredSize(new Dimension(200, 30));
		p2.add(l1);
		p2.add(cb1);
		p3.add(l2);
		p3.add(cb2);
		p1.add(p2);
		p1.add(p3);
		p1.setPreferredSize(new Dimension(400, 100));
		//----------------------------------------------------------------------
		rb1=new JRadioButton("横向(A)",false);
		rb2=new JRadioButton("纵向(O)",true);
		p4=new JPanel();
		p5=new JPanel();
		p4.setLayout(new FlowLayout());
		p4.add(rb1); 
		p4.add(rb2);
		p5.setLayout(new GridLayout(1,2));
		p5.setBorder(BorderFactory.createTitledBorder("方向"));
		p5.add(p4);
		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		p5.setPreferredSize(new Dimension(100, 100));
		//----------------------------------------------------------------------
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		tf1=new JTextField(3);
		tf1.setText("25");
		tf2=new JTextField(3);
		tf2.setText("25");
		tf3=new JTextField(3);
		tf3.setText("25");
		tf4=new JTextField(3);
		tf4.setText("25");
		l3=new JLabel("左(L):");
		l4=new JLabel("右(R):");
		l5=new JLabel("上(T):");
		l6=new JLabel("下(B):");
		p6.add(l3);
		p6.add(tf1);
		p6.add(l4);
		p6.add(tf2);
		p7.add(l5);
		p7.add(tf3);
		p7.add(l6);
		p7.add(tf4);
		p8.add(p6);
		p8.add(p7);
		p8.setBorder(BorderFactory.createTitledBorder("页边距(毫米)"));
		p8.setLayout(new GridLayout(2, 1));
		p8.setPreferredSize(new Dimension(300, 100));
		//----------------------------------------------------------------------
		p9=new JPanel();//图片
		p11=new JPanel();
		p11.setBorder(BorderFactory.createTitledBorder(""));
		l7=new JLabel(img1,JLabel.CENTER);
		l8=new JLabel(img2,JLabel.CENTER);
		p9.add(l7);
		p9.add(l8);
		l8.setVisible(false);//默认竖着
		p9.setPreferredSize(new Dimension(200, 150));
		//p9.setBorder(BorderFactory.createDashedBorder(Color.gray));
		//p9.setBackground(Color.white);
		p11.add(p9);
		
		//----------------------------------------------------------------------
		b1=new JButton("确定");
		b2=new JButton("取消");
		p10=new JPanel();
		p10.add(b1);
		p10.add(b2);
		//----------------------------------------------------------------------
		frm.add(p11);
		frm.add(p1);
		frm.add(p8);
		frm.add(p5);
		frm.add(p10);
		
		frm.setTitle("页面设置");
		frm.setVisible(true);
		frm.setSize(450,500);
		frm.setLocationRelativeTo(null); 
		frm.setResizable(false);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		psal=new PageSettingActionListener();
		cb1.addActionListener(psal);
		cb2.addActionListener(psal);
		rb1.addActionListener(psal);
		rb2.addActionListener(psal);
		tf1.addActionListener(psal);
		tf2.addActionListener(psal);
		tf3.addActionListener(psal);
		tf4.addActionListener(psal);
		b1.addActionListener(psal);
		b2.addActionListener(psal);
		tf1.getDocument().addDocumentListener(psal);
		tf2.getDocument().addDocumentListener(psal);
		tf3.getDocument().addDocumentListener(psal);
		tf4.getDocument().addDocumentListener(psal);
	}

}
