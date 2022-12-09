package kr.bit.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member { //사용자 계정정보 저장 클래스, 스프링시큐리티와 관련없음.
	
	//사용자 계정정보 db 저장용
	@Id
	private String username; //사용자 아이디(이름 아님)
	private String password;
	private String name;
	
	@Enumerated(EnumType.STRING) //열거형타입
	private Role role;
	private boolean enabled; //계정 활성화 유무 여부
	
}
