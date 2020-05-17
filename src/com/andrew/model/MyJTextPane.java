package com.andrew.model;

import java.awt.Dimension;

import javax.swing.JTextPane;
@SuppressWarnings("all")
public class MyJTextPane extends JTextPane{
	/*
	 *继承 JTextPane
	 *增加自动换行切换的功能
	 */
	
	private static boolean flag=false;//设置是否自动换行的标志    默认自动换行
	
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
			dimension.width+=1;//文本的宽度自增
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
