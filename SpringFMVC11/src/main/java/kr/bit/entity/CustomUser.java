package kr.bit.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class CustomUser extends User{
	
	private Member member;
	
	//아이디, 비번, 권한정보를 user 클래스가 관리하도록 설정
	public CustomUser(Member member) {
		//super(username, password, authorities);
		super(member.getUsername(), member.getPassword(), 
				//ROLE_ADMIN / ROLE_MEMBER / ROLE_MANAGER
				AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
		this.member = member;
	}

}
