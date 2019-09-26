package com.pp.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.classfile.Field;

public class Server2 {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is =null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		ArrayList<String> food = new ArrayList<String>();
		
		File f = new File("C:\\Ppp\\test","lunch.txt");
		FileReader fr = null;
		StringTokenizer st = null;
		boolean check =true;
		try {
			ss = new ServerSocket(8282);
			sc = ss.accept();
			
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			
			bw.write("1.점심   2. 저녁 "+"\r\n");
			bw.flush();
			System.out.println("클라이언트로 전송");
			
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			
			
			
			String str =  br.readLine();			
			System.out.println(str);
					

			
			if(str.equals("1")) {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				
				
				while(check) {
					String lunch = br.readLine();
					if(str == null) {
						break;
					}
					st = new StringTokenizer(lunch,"-");
					
					while(st.hasMoreTokens()) {
						food.add(st.nextToken().trim());
					}
						
						
					}
				for(int i= 0;i<food.size();i++) {
					System.out.println(food.get(i));
				}
				
				
			}else if(str.equals("2")) {
				f = new File("C:\\Ppp\\test","dinner.txt");
				String dinner = br.readLine();
				st = new StringTokenizer(dinner,",");
				
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				br.close();
				fr.close();
				ir.close();
				is.close();
				
				ow.close();
				os.close();
				
				sc.close();
				ss.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
}
