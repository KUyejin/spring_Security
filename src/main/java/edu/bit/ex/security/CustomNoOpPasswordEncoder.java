package edu.bit.ex.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	
	
	@Override
	public String encode(CharSequence rawPassword) { 
		log.warn("before encode :" + rawPassword);
		return rawPassword.toString(); 		
		// rawPassword.toString()는 암호화을 안시키겠다는 것 - 날 것 그대로
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) { 
		log.warn("matches: " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		//원래있던 패스워드 비교해서 리턴시켜라
	}

}
