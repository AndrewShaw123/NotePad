package com.andrew.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.andrew.control.formatcontrol.NewFontActionListener;
@SuppressWarnings("all")
public class NewFont {
	/*
	 * �޸�����Ľ���
	 */
	
	public static JFrame frm=null;
	
	public static JButton b1=null;
	public static JButton b2=null;
	
	public static JLabel l1=null;
	public static JLabel l2=null;
	public static JLabel l3=null;
	
	public static JPanel p1=null;
	
	public static JPanel p2=null;
	public static JPanel p3=null;
	public static JPanel p4=null;
	public static JPanel p5=null;
	
	public static JPanel p12=null;
	
	public static JPanel p13=null;
	
	public static JList jl1=null;
	public static JList jl2=null;
	public static JList jl3=null;
	
	public static JScrollPane sp1;
	public static JScrollPane sp2;
	public static JScrollPane sp3;
	
	public static JLabel jta=null;
	
	public static final String[] FONT_STYLE= {"����","����","Times New Roman","Fixedsys"};//����
	public static final String[] FONT_SHAPE= {"��ͨ","����","б��","��б��"};//����
	public static final Integer[] FONT_SIZE= {8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};//��С
	
	
	public static NewFontActionListener nfal=null;
	
	
	public void showNewFont() {
		
		frm=new JFrame();
		frm.setAlwaysOnTop(true);
		frm.setLayout(new FlowLayout());
		
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(new GridLayout(1, 2));
		p2.setLayout(new FlowLayout());
		b1=new JButton("ȷ��");
		b2=new JButton("ȡ��");
		p2.add(b1);
		p2.add(b2);
		p1.add(p2);
		
		
		l1=new JLabel("����(F):");
		Box box1=Box.createVerticalBox();
		Box.createHorizontalGlue();
		jl1=new JList(FONT_STYLE);
		sp1 = new JScrollPane(jl1);
		sp1.setPreferredSize(new Dimension(150, 150));
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		box1.add(l1);
		box1.add(sp1);
		
		
		l2=new JLabel("����(Y):");
		Box box2=Box.createVerticalBox();
		jl2=new JList(FONT_SHAPE);
		sp2 = new JScrollPane(jl2);
		sp2.setPreferredSize(new Dimension(150, 150));
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		box2.add(l2);
		box2.add(sp2);
		
		
		l3=new JLabel("��С(S):");
		Box box3=Box.createVerticalBox();
		jl3=new JList(FONT_SIZE);
		sp3 = new JScrollPane(jl3);
		sp3.setPreferredSize(new Dimension(100, 150));
		sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		box3.add(l3);
		box3.add(sp3);
		
		p12=new JPanel();
		p12.setBorder(BorderFactory.createTitledBorder("ʾ��"));
		jta=new JLabel("AaBbYyZz");
		jta.setBackground(Color.lightGray);
		p12.add(jta);
		p12.setPreferredSize(new Dimension(400, 150));
		
		p2=new JPanel();
		p2.add(box1);
		p2.add(box2);
		p2.add(box3);
		
		p3=new JPanel();
		p3.add(p12);
		
		p13=new JPanel();
		p13.setLayout(new GridLayout(2,1));
		p13.add(p3);
		p13.add(p1);
		
		frm.add(p2);
		//frm.add(p3);
		//frm.add(p1);
		frm.add(p13);
		
		
		frm.setTitle("����");
		frm.setVisible(true);
		frm.setSize(450,450);
		//frm.setLocation(450,250);
		frm.setLocationRelativeTo(null); 
		frm.setResizable(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		nfal=new NewFontActionListener();
		b1.addActionListener(nfal);
		b2.addActionListener(nfal);
		jl1.addListSelectionListener(nfal);
		jl2.addListSelectionListener(nfal);
		jl3.addListSelectionListener(nfal);
		
		jl1.setSelectedIndex(0);//����Ĭ��ֵ
		jl2.setSelectedIndex(0);
		jl3.setSelectedIndex(0);
	}

}
