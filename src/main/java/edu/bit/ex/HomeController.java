package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	

	
	@GetMapping("/admin/adminHome") 
	public void adminHome() { //해당 view값이 경로값과 같을 때에는 void쓴다 -> jsp 그대로 리턴
		log.info("adminHome...");
	}
	
	@GetMapping("/user/userHome") 
	public void userHome() { //해당 view값이 경로값과 같을 때에는 void쓴다 -> jsp 그대로 리턴
		log.info("adminHome...");
	}
	
		
	@GetMapping("/login/loginForm")
	public String loginForm() {
		log.info("Welcom Login Form!");
		
		return "/login/loginForm";
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied(Model model) {
		log.info("Welcom Access Denied!");

	}
	
	
}
