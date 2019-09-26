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
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		//ServerSocket
		//Socket
		
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		boolean check =true;
		
		try {
			
			ss = new ServerSocket(8282);
			sc = ss.accept();
			while(check) {
				
				
				System.out.println("클라이언트 접속받을 준비중");
				
				
				is = sc.getInputStream();
				ir = new InputStreamReader(is); //char
				br = new BufferedReader(ir);
				String str = br.readLine();
				
				if(str == null) {
					break;
				}
				
				System.out.println(str);
				
				
				System.out.println("클라이언트로 전송할 메시지 입력");
				str = ssc.next();
				
				if(str.toUpperCase().equals("Q")) {
					break;
				}
				
				os = sc.getOutputStream(); // byte를 처리
				ow = new OutputStreamWriter(os); // char
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("클라이언트로 전송 완료");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				bw.close(); // 역순으로
				ow.close();
				os.close();
				
				br.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
