package com.pp.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//1단계
		Socket  sc= null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		
		ServerSocket ss = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		
		try {
			
			boolean check = true;
			sc = new Socket("211.238.142.44", 8282);
				while(check) {
					
				
				
				System.out.println("서버로 전송할 메시지 입력");
				String str = ssc.next();
				
				if(str.toUpperCase().equals("Q")) {
					check = false;
					break;
					
				}
				os = sc.getOutputStream(); // byte를 처리
				ow = new OutputStreamWriter(os); // char
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("서버로 전송 완료");
				
			
				
				System.out.println("서버 접속받을 준비중");
				
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				str = br.readLine();
				
				if(str ==null) {
					break;
				}
				
				System.out.println(str);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				br.close();
				ir.close();
				is.close();
				
				bw.close();
				ow.close();
				os.close();
				sc.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
