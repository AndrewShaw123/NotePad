package com.andrew.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.andrew.view.App;

public class Utils {
	/*
	 * 工具类
	 */
	
	public static String readFile(File file,String code){//读取
		FileInputStream fis=null;
		BufferedReader br=null;
		try {
			
			fis=new FileInputStream(file);
			br=new BufferedReader(new InputStreamReader(fis,code));//用InputStreamReader可采取定义编码格式
			String temp;
			StringBuilder sb=new StringBuilder();//用StringBuilder可节省内存
			while((temp=br.readLine())!=null) {
				sb.append(temp);
			}
			return sb.toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void saveFile(File file,String temp,String code) {//保存
		
		FileOutputStream fos=null;
		BufferedWriter bw=null;
		try {
			
			fos=new FileOutputStream(file);
			bw=new BufferedWriter(new OutputStreamWriter(fos,code));//用OutputStreamWriter可采取定义编码格式
			bw.write(temp);
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	public static void createNew(String path) {//创建新文件
		File file=new File(path);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
	}
	
	public static boolean isChange(String text,File file) {//判断文本是否改变
		
		String temp=readFile(file,App.getEnCodingAndDeCoding());//调用上面的读取
		if(temp.equals(text)) {
			return false;
		}
		return true;
		
	}

}
