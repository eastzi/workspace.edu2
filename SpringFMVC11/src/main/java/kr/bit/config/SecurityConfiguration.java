package kr.bit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	//비밀번호 암호화 설정
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeHttpRequests()
			.antMatchers("/", "/member/**").permitAll() //해당 경로는 모두 허용
			.antMatchers("/board/**").authenticated() //해당 경로는 인증 필요
			
			.and()
			.formLogin() //사용자 지정 로그인 페이지 사용
			.loginPage("/member/login") //로그인 페이지 이동 경로
			.defaultSuccessUrl("/board/list") //로그인 성공 시 이동 페이지
			
			.and()
			.logout() //로그아웃 설정
			.logoutUrl("/member/logout") //로그아웃 페이지 이동 경로
			.logoutSuccessUrl("/"); //로그아웃 성공 시 이동 페이지 
			
		//loadByUserName으로 인증처리 후 위의 authorizeHttpRequests 설정에 따라 동작
		http.userDetailsService(userDetailsService); 
		
		return http.build();
	}
	
	
}
