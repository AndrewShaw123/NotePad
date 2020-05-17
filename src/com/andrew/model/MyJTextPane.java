package com.andrew.model;

import java.awt.Dimension;

import javax.swing.JTextPane;
@SuppressWarnings("all")
public class MyJTextPane extends JTextPane{
	/*
	 *�̳� JTextPane
	 *�����Զ������л��Ĺ���
	 */
	
	private static boolean flag=false;//�����Ƿ��Զ����еı�־    Ĭ���Զ�����
	
	@Override
	public boolean getScrollableTracksViewportWidth() {
		if(flag) {
			return false;
		}
		return super.getScrollableTracksViewportWidth();
	}
	
	@Override
	public void setSize(Dimension dimension) {
		if(flag) {
			if(dimension.width<getParent().getSize().width){
				dimension.width=getParent().getSize().width;
			}
			dimension.width+=1;//�ı��Ŀ������
			super.setSize(dimension);
		}else {
			super.setSize(dimension);
		}
	}

	//----------------------------------------------------------
	public static boolean getFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		MyJTextPane.flag = flag;
	}
	
	

}
