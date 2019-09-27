package com.pp.n2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.pp.n2.network.Network;

public class Client4 {
	
	public static void main(String[] args) {
		//Id 입력
		//Pw 입력
		//서버로 전송
		//
		Network network = new Network();
		Scanner scc = new Scanner(System.in);
		
		try {
			Socket sc = new Socket("211.238.142.30",8282);
			
			System.out.println("ID를 입력하세요.");
			String str = scc.next();
			System.out.println("비밀번호를 입력하세요.");
			String str2 = scc.next();
			
			
			network.send(sc, str+","+str2);
			System.out.println("로그인 시도중");
			
			str = network.receive(sc);
			System.out.println(str);
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
