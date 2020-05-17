package com.andrew.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Book;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.undo.UndoManager;

import com.andrew.control.codingcontrol.CodingActionListener;
import com.andrew.control.editcontrol.EditAcationListener;
import com.andrew.control.filecontrol.FileActionListener;
import com.andrew.control.formatcontrol.FormatActionListener;
import com.andrew.control.helpcontrol.HelpActionListener;
import com.andrew.control.highlightcontrol.TextAreaListener;
import com.andrew.model.MyJTextPane;
@SuppressWarnings("all")
public class App{
	/*
	 * ����ʾ����
	 */
	
	public static JFrame frm=null;
	public static JMenuBar mb=null;
	public static MyJTextPane ta=null;//JTextArea-->JTextPane-->MyJTextPane
	public static JScrollPane sp=null;

	public static FileActionListener mal=null;
	public static EditAcationListener eal=null;
	public static HelpActionListener hal=null;
	public static FormatActionListener dal=null;
	public static CodingActionListener cal=null;
	public static TextAreaListener tal=null;
	
	public static JFileChooser fc=null;
	public static JOptionPane op=null;
	
	public static UndoManager udm=new UndoManager();
	
	private static String enCodingAndDeCoding="UTF-8";//���ñ����ʽĬ��ΪUTF-8
	
	public static Book book=new Book();
	
	public static void main(String[] args) {
		
		frm=new JFrame();
		ta=new MyJTextPane();
		ta.getDocument().addUndoableEditListener(udm);
		sp=new JScrollPane(ta);
		addMenu();
		
		frm.setTitle("�ޱ��� - ���±�");
		frm.setIconImage(new ImageIcon("src/img/notepad.png").getImage());
		frm.setJMenuBar(mb);
		frm.add(sp);
		
		frm.setVisible(true);
		frm.setSize(700, 750);
		frm.setLocationRelativeTo(null);//λ����������Ļ�м�
		frm.setResizable(true);
		
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
		frm.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				
				FileActionListener c=new FileActionListener();
				c.exit();//�˳�����
				
			}
		});

		
	}
	
	private static void addMenu() {
		mb=new JMenuBar();
		
		JDialog jl=new JDialog();
		
		JMenu jm1=new JMenu("�ļ�(F)");
		JMenu jm2=new JMenu("�༭(E)");
		JMenu jm3=new JMenu("��ʽ(O)");
		JMenu jm4=new JMenu("�鿴(V)");
		JMenu jm5=new JMenu("����(H)");
		JMenu jm6=new JMenu("����(N)");
		
		JMenuItem it1=new JMenuItem("�½�(N)");
		JMenuItem it2=new JMenuItem("��(O)...");
		JMenuItem it3=new JMenuItem("����(S)");
		JMenuItem it4=new JMenuItem("���Ϊ(A)");
		JMenuItem it5=new JMenuItem("�˳�(X)");
		
		JMenuItem it6=new JMenuItem("����(T)");
		JMenuItem it7=new JMenuItem("����(C)");
		JMenuItem it8=new JMenuItem("ճ��(P)");
		JMenuItem it9=new JMenuItem("ɾ��(L)");
		JMenuItem it10=new JMenuItem("����(F)");
		JMenuItem it11=new JMenuItem("�滻(R)");
		JMenuItem it12=new JMenuItem("ʱ��/����(D)");
		
		JCheckBoxMenuItem it13=new JCheckBoxMenuItem("�Զ�����(W)",true);
		JMenuItem it14=new JMenuItem("����(F)...");
		
		JMenuItem it15=new JMenuItem("����(U)");
		JMenuItem it16=new JMenuItem("���ڼ��±�(A)");
		JMenuItem it17=new JMenuItem("�鿴����(H)");
		JMenuItem it18=new JMenuItem("ҳ������(U)...");
		JMenuItem it19=new JMenuItem("״̬��(S)");
		it19.setEnabled(false);
		
		JCheckBoxMenuItem it20=new JCheckBoxMenuItem("GBK");
		JCheckBoxMenuItem it21=new JCheckBoxMenuItem("UTF-8");
		it21.setSelected(true);//Ĭ��ѡ��UTF-8�����ʽ
		JCheckBoxMenuItem it22=new JCheckBoxMenuItem("Unicode");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(it20);
		bg.add(it21);
		bg.add(it22);
		
		
		jm1.add(it1);
		jm1.add(it2);
		jm1.add(it3);
		jm1.add(it4);
		jm1.addSeparator();
		jm1.add(it18);
		jm1.addSeparator();
		jm1.add(it5);
		
		jm2.add(it15);
		jm2.add(it6);
		jm2.add(it7);
		jm2.add(it8);
		jm2.add(it9);
		jm2.addSeparator();
		jm2.add(it10);
		jm2.add(it11);
		jm2.addSeparator();
		jm2.add(it12);
		
		jm3.add(it13);
		jm3.add(it14);
		
		jm4.add(it19);
		
		jm5.add(it17);
		jm5.addSeparator();
		jm5.add(it16);
		
		jm6.add(it20);
		jm6.add(it21);
		jm6.add(it22);
		
		mb.add(jm1);
		mb.add(jm2);
		mb.add(jm3);
		mb.add(jm6);
		mb.add(jm4);
		mb.add(jm5);
		
		mal=new FileActionListener();
		it1.addActionListener(mal);
		it2.addActionListener(mal);
		it3.addActionListener(mal);
		it4.addActionListener(mal);
		it5.addActionListener(mal);
		it18.addActionListener(mal);
		
		eal=new EditAcationListener();
		it6.addActionListener(eal);
		it7.addActionListener(eal);
		it8.addActionListener(eal);
		it9.addActionListener(eal);
		it10.addActionListener(eal);
		it11.addActionListener(eal);
		it12.addActionListener(eal);
		it15.addActionListener(eal);
		
		hal=new HelpActionListener();
		it16.addActionListener(hal);
		it17.addActionListener(hal);
		
		dal=new FormatActionListener();
		it13.addActionListener(dal);
		it14.addActionListener(dal);
		
		cal=new CodingActionListener();
		it20.addActionListener(cal);
		it21.addActionListener(cal);
		it22.addActionListener(cal);
		
		tal=new TextAreaListener();
		ta.getDocument().addDocumentListener(tal);
	}

	
	public static String getEnCodingAndDeCoding() {
		return enCodingAndDeCoding;
	}

	public static void setEnCodingAndDeCoding(String enCodingAndDeCoding) {
		App.enCodingAndDeCoding = enCodingAndDeCoding;
	}

	
}
