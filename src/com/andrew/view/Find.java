package com.andrew.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.andrew.control.editcontrol.FindActionListener;
@SuppressWarnings("all")
public class Find {
	/*
	 * 查找的界面
	 */
	
	public static JFrame frm=null;
	public static JPanel p1=null;
	public static JPanel p2=null;
	public static JPanel p3=null;
	public static JPanel p4=null;
	public static JPanel p5=null;
	public static JPanel p6=null;
	public static JPanel p7=null;
	
	public static JLabel l=null;
	
	public static JTextField tf=null;
	
	public static JCheckBox cb=null;
	
	public static JButton b1=null;
	public static JButton b2=null;
	
	public static JRadioButton rb1=null;
	public static JRadioButton rb2=null;
	
	public static ButtonGroup bg=null;
	
	public static FindActionListener dal=null;
	
	
	public void showFind() {
		
		frm=new JFrame();
		frm.setAlwaysOnTop(true);
		frm.setLayout(new FlowLayout());
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		
		l=new JLabel("查找内容(N):");
		
		tf=new JTextField(20);
		
		cb=new JCheckBox("不区分大小写(C)");
		
		/*
		 * 不要去掉空格也不要加空格##########跟事件处理绑定
		 */
		b1=new JButton("查找下一个(F)");
		b2=new JButton("       取消         ");
		
		rb1=new JRadioButton("向上(U)",false);
		rb2=new JRadioButton("向下(D)",true);
		
		
		p1.setLayout(new FlowLayout());
		p1.add(l);
		p1.add(tf);
		p2.setLayout(new GridLayout(1,1));
		p2.add(p1);
		
		p3.setLayout(new FlowLayout());
		p3.add(b1);
		p4.setLayout(new FlowLayout());
		p4.add(b2);
		p5.setLayout(new GridLayout(2,1));
		p5.add(p3);
		p5.add(p4);
		
		p6.setLayout(new FlowLayout());
		p6.add(rb1); 
		p6.add(rb2);
		p7.setLayout(new GridLayout(1,2));
		p7.setBorder(BorderFactory.createTitledBorder("方向"));
		p7.add(p6);
		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		
		frm.add(p2);
		frm.add(p5);
		frm.add(cb);
		frm.add(p7);
		
		frm.setTitle("查找");
		frm.setVisible(true);
		frm.setSize(500,200);
		//frm.setLocation(450, 250);
		frm.setLocationRelativeTo(null); 
		frm.setResizable(false);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		dal=new FindActionListener();
		b1.addActionListener(dal);
		b2.addActionListener(dal);
		rb1.addActionListener(dal);
		rb2.addActionListener(dal);
		cb.addActionListener(dal);
		
	}

}
