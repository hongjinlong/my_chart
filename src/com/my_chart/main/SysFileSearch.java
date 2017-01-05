package com.my_chart.main;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SysFileSearch {
	
	public static void main(String[] args) {
		Long sTime = System.currentTimeMillis();
		disEachDrive(getDrives());
		System.out.println("-- 总耗时"+(System.currentTimeMillis()-sTime)/60000+"分，"+(System.currentTimeMillis()-sTime)%60000/1000+"秒");
		
	}
	
	
	public static File[] getDrives(){
		return File.listRoots();
	}
	
	public static void disEachDrive(File[] drives){
		for (int i = 0; i < drives.length; i++) {
			System.out.println("-- "+drives[i]);
			if(drives[i].canRead()){
				//displayFile(drives[i]);
				//deepLoop(drives[i]);
				widLoop(drives[i]);
			}else if(!drives[i].canRead()){
				System.out.println("---- 此盘符不可读");
			}
		}
	}
	
	public static void displayFile(File drive){
		File[] fList = drive.listFiles();
		if(fList!=null){
			for (File file : fList) {
				System.out.println("---- "+file.getAbsolutePath());
				//displayFile(file);
			}
		}else if(fList == null){
			System.out.println("---- 没有下级目录或下级目录为空");
		}
	}
	
	//深度优先原则，树遍历
	public static void deepLoop(File drive){
		Stack<File> fStack = new Stack<File>();
		File[] fList = drive.listFiles();
		for (int i = 0; i < fList.length; i++) {
			fStack.push(fList[i]);
		}
		do{
			File popFile = fStack.pop();
			System.out.println("---- "+popFile.getAbsolutePath());
			File[] pfList = popFile.listFiles();
			if(pfList!=null){
				for (int j = 0; j < pfList.length; j++) {
					fStack.push(pfList[j]);
				}
			}
		}while(!fStack.isEmpty());
	}
	
	//广度优先原则
	public static void widLoop(File drive){
		LinkedList<File> fQueue = new LinkedList<File>();
		File[] fList = drive.listFiles();
		for (int i = 0; i < fList.length; i++) {
			fQueue.add(fList[i]);
		}
		do{
			File pollFile = fQueue.pollFirst();
			if(pollFile!=null){
				System.out.println("---- "+pollFile.getAbsolutePath());
				File[] pfList = pollFile.listFiles();
				if(pfList!=null){
					for (int i = 0; i < pfList.length; i++) {
						fQueue.add(pfList[i]);
					}
				}
			}
		}while(!fQueue.isEmpty());
	}
	
}
