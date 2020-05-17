package com.andrew.view;


import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.andrew.control.editcontrol.ReplaceActionListener;
@SuppressWarnings("all")
public class Replace {
	/*
	 * 替换界面
	 */
	
	public static JFrame frm=null;
	
	public static JLabel label1=null;
	public static JLabel label2=null;
	
	public static JTextField tf1=null;
	public static JTextField tf2=null;
	
	public static JButton b1=null;
	public static JButton b2=null;
	public static JButton b3=null;
	public static JButton b4=null;
	
	public static JCheckBox cb=null;
	
	public static JPanel p1=null;
	public static JPanel p2=null;
	public static JPanel p3=null;
	public static JPanel p4=null;
	public static JPanel p5=null;
	public static JPanel p6=null;
	public static JPanel p7=null;
	public static JPanel p8=null;
	public static JPanel p9=null;
	
	public static ReplaceActionListener ral=null;
	
	public void showReplace() {
		
		frm=new JFrame();
		frm.setAlwaysOnTop(true);
		frm.setLayout(new FlowLayout());
		
		label1=new JLabel("查找内容(N):");
		label2=new JLabel("替换为(P):    ");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		
		tf1=new JTextField(20);
		tf2=new JTextField(20);
		
		/*
		 * 不要去掉空格也不要加空格##########跟事件处理绑定
		 */
		b1=new JButton("查找下一个(F)");
		b2=new JButton("      替换(R)     ");
		b3=new JButton("  全部替换(A)  ");
		b4=new JButton("        取消         ");
		
		cb=new JCheckBox("不区分大小写(C)");
		
		
		p1.setLayout(new FlowLayout());
		p1.add(label1);
		p1.add(tf1);
		
		
		p2.setLayout(new FlowLayout());
		p2.add(label2);
		p2.add(tf2);
		
		p3.setLayout(new GridLayout(2,2));
		p3.add(p1);
		p3.add(p2);
		
		p4.setLayout(new FlowLayout());
		p4.add(b1);
		p5.setLayout(new FlowLayout());
		p5.add(b2);
		p6.setLayout(new FlowLayout());
		p6.add(b3);
		p7.setLayout(new FlowLayout());
		p7.add(b4);
		
		p8.setLayout(new GridLayout(1,1));
		p8.add(cb);
		
		p9.setLayout(new GridLayout(4,1));
		p9.add(p4);
		p9.add(p5);
		p9.add(p6);
		p9.add(p7);
		
		frm.add(p3);
		frm.add(p9);
		frm.add(p8);
		
		frm.setTitle("替换");
		frm.setVisible(true);
		frm.setSize(500,250);
		//frm.setLocation(450,250);
		frm.setLocationRelativeTo(null); 
		frm.setResizable(false);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		
		ral=new ReplaceActionListener();
		b1.addActionListener(ral);
		b2.addActionListener(ral);
		b3.addActionListener(ral);
		b4.addActionListener(ral);
		cb.addActionListener(ral);
		
	}

}
