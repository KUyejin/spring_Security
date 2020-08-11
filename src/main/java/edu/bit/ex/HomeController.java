package edu.bit.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/admin/adminHome")
	public void adminHome() { // 해당 view값이 경로값과 같을 때에는 void쓴다 -> jsp 그대로 리턴
		log.info("adminHome...");
	}

	@GetMapping("/user/userHome")
	public void userHome() { // 해당 view값이 경로값과 같을 때에는 void쓴다 -> jsp 그대로 리턴
		log.info("adminHome...");
	}

	@GetMapping("/login/loginForm")
	public String loginForm() {
		log.info("Welcom Login Form!");

		return "login/loginForm";
	}

	@GetMapping("/login/accessDenied")
	public void accessDenied(Model model) {
		log.info("Welcom Access Denied!");

	}

	@GetMapping("/loginInfo")
	public String loginInfo(Principal principal) {
		log.info("Welcom loginInfo!");

		String user_id;

		// 1. [SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용할수있음)]=====================================
		// UserDetails에서 유저아이디, 비번을 가져온다
		// SecurityContextHolder안에 Authentication(인증)있다 -> Authentication 안에는 principal이 있다 ->
		// principal안에는 userDetails있다. -> userDetails 안에는 user있다
			  		  
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  user_id = auth.getName(); 
		  UserDetails userDetails = (UserDetails)auth.getPrincipal();
		  
		  System.out.println("유저 아이디:" + userDetails.getUsername());		 
		

		// 2. [Controller를 통하여 Principal객체로 가져오는 방법]=========================================================
		UserDetails userDetail = (UserDetails) principal;
		System.out.println(userDetails.getUsername());

		// 3. [User 클래스로 변환하여 가져오는 방법]=====================================================================
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		

		return "home";
	}

}
