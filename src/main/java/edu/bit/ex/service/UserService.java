package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {
	
	@Inject
	private BCryptPasswordEncoder passEncoder;
	//암호화 시킬때 쓰는 클래스  -> 인코더와 디코더를 같이 해준다
	
	@Inject
	private UserMapper userMapper;
	
	public void addUser(UserVO userVO){
		String password = userVO.getPassword();
		String encode = passEncoder.encode(password);
		
		userVO.setPassword(encode);
		
		userMapper.insertUser(userVO);
		userMapper.insertAuthorities(userVO);
	}
}	
