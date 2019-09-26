package com.pp.n2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.pp.n2.member.Member;
import com.pp.n2.member.MemberService;
import com.pp.n2.network.Network;

public class Server4 {
	public static void main(String[] args) {
		
		MemberService ms = new MemberService();
		Network network = new Network();
		ArrayList<Member> member = new ArrayList<Member>();
		
		member= ms.init();
		
		ServerSocket ss;
		try {
			ss = new ServerSocket(8282);
			Socket sc = ss.accept();
			
			String u =network.receive(sc);
			
			String login = ms.memberLogin(member, u);
			
			network.send(sc, login);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
