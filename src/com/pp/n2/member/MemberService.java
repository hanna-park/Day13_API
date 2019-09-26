package com.pp.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MemberService {

	//파일의 내용을 읽어서 파싱 작업
	public ArrayList<Member> init() {
		File f = new File("C:\\Ppp\\test","member.txt");
		ArrayList<Member> member = new ArrayList<Member>();
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String str =null;
			while((str=br.readLine()) != null) {
				
				StringTokenizer st =new StringTokenizer(str,",");
				while(st.hasMoreTokens()){
				Member user = new Member();
				user.setId(st.nextToken());
				user.setPw(st.nextToken());
				member.add(user);
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
		
		
	}
	
	
	//id, pw를 매개변수로 받아서 로그인 유무를 검증
	public String memberLogin(ArrayList<Member> member,String login) {
//		ArrayList<Member> n = new ArrayList<Member>();
		StringTokenizer st = new StringTokenizer(login,",");
		Member m = new Member();
		m.setId(st.nextToken());
		m.setPw(st.nextToken());
		login ="로그인 실패";
		for(int i=0;i<member.size();i++) {
			
			if(member.get(i).getId().equals(m.getId())
					&&member.get(i).getPw().equals(m.getPw())) {
				login ="로그인 성공";
				break;
				
			}
			
			
		}
		return login;
		
	}
}
