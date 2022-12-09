package kr.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.bit.entity.Member;
import kr.bit.entity.Role;
import kr.bit.repository.MemberRepository;

@SpringBootTest
class SpringFmvc11ApplicationTests {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	void createMember() {
		Member m = new Member();
		m.setUsername("eastzi2");
		m.setPassword(encoder.encode("12345")); //pw 암호화
		m.setName("이스트2");
		m.setRole(Role.MANAGER);
		m.setEnabled(true);
		memberRepository.save(m); //회원가입
	}

}
