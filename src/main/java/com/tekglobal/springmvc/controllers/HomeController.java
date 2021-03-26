package com.tekglobal.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekglobal.springmvc.models.Message;
import com.tekglobal.springmvc.models.User;
import com.tekglobal.springmvc.services.MessageDao;
import com.tekglobal.springmvc.services.UserDao;


@Controller
public class HomeController {
	public String contactname;
	public String username = "Anonymous";
	public String usermail;
	UserDao ud = new UserDao();
	MessageDao md = new MessageDao();
	
	@GetMapping("/")
	public String startPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Valid User user) {
		System.out.println(user.toString());
		ud.addUser(user);
		return "login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("loguser") User loguser, Model model) {
		if (ud.validate(loguser)) {
			username = ud.getUser(loguser.getEmail()).getName();
		}
		model.addAttribute("loguser", username);
		if (ud.validate(loguser)){
			usermail = loguser.getEmail();
			return "index";
		}else {return "login";}
	}
	
	@GetMapping("/index")
	public String showIndexPage(Model model) {
		model.addAttribute("loguser", username);
		return "index";
	}
	
	@GetMapping("/about_me")
	public String showAboutMe() {
		return "about_me";
	}
	
	@GetMapping("/contact")
	public String showContact(Model model) {
		model.addAttribute("message", new Message());
		return "contact";
	}
	@PostMapping("/contact")
	public String sentMessage(@ModelAttribute("message") Message message, Model model) {
		contactname = message.getName();
		model.addAttribute("contactname", contactname);
		md.addMessage(message);
		System.out.println(contactname);
		return "acknowledged_message";
	}
	
}