package com.seok.home.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.member.MemberDAO;
import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private MemberDAO memberDAO;
	
	public boolean getLogin(MemberDTO memberDTO) throws Exception {
		
		memberDTO = memberDAO.getLogin(memberDTO);
		
		boolean chk = false;
		
		if(memberDTO!=null) {			
			List<RoleDTO> roles = memberDTO.getRoleDTOs();
			
			for(RoleDTO role : roles) {
				if(role.getRoleName().equals("관리자")) {
					chk = true;
				}
			}
		}
		
		
		return chk;
	}
	
	public void getAuth() {
		//아이디 패스워드 맞는지 확인
		//권한추가
		adminDAO.getAuth();
	}

}
