package kr.bit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.bit.entity.CustomUser;
import kr.bit.entity.Member;
import kr.bit.repository.MemberRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//DB에서 사용자 정보 가져와서 member타입으로 저장
		Member member = memberRepository.findById(username).get();
		
		//member 인증 성공 유/무 체크
		if(member == null) { //member가 없으면 notFound 예외 던지기 -> 회원인증 실패
			throw new UsernameNotFoundException(username + "없음");
		}
		
		return new CustomUser(member); //user(3가지 권한정보) + member(기타 정보) = CustomUser
	}

}
