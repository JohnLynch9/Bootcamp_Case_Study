package com.Tek_Systems.case_study_final.Controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Tek_Systems.case_study_final.Models.Art;
import com.Tek_Systems.case_study_final.Models.Message;
import com.Tek_Systems.case_study_final.Models.User;
import com.Tek_Systems.case_study_final.Services.ArtDaoI;
import com.Tek_Systems.case_study_final.Services.MessageDaoI;
import com.Tek_Systems.case_study_final.Services.UserDaoI;


@Controller
public class HomeController {
	public String contactname = "Anonymous";
	public String username = "Anonymous";
	public String usermail;
	public User user;
	
	@Autowired
	UserDaoI ud;
	@Autowired
	MessageDaoI md;
	@Autowired
	ArtDaoI ad;
	
	// Get Started creating the users
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
	public String registerUser(@ModelAttribute("user") @Validated User user) {
		System.out.println(user.toString());
		ud.save(user);
		return "login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("loguser") User loguser, Model model) {
		List<User> lu = ud.findAll();
		for (User u: lu) {
			if (loguser.getEmail().equals(u.getEmail()) && loguser.getPassword().equals(u.getPassword())) {
				username = u.getName();
				model.addAttribute("loguser", username);
				user = loguser;
				return "index";
			}
		}
		return "login";
	}
	//finished with users
	
	// Misc. Pages
	@GetMapping("/index")
	public String showIndexPage(Model model) {
		model.addAttribute("loguser", username);
		return "index";
	}
	@GetMapping("/about_me")
	public String showAboutMe() {
		return "about_me";
	}
	
	// Messaging in our project
	@GetMapping("/contact")
	public String showContact(Model model) {
		model.addAttribute("message", new Message());
		return "contact";
	}
	@PostMapping("/contact")
	public String sentMessage(@ModelAttribute("message") @Validated Message message) {
		message.setUser(user);
		md.save(message);
		return "acknowledgedmessage";
	}
	@GetMapping("/acknowledged_message")
	public String showAcknowledgedmessage() {
		return "acknowledged_message";
	}
	@GetMapping("/forum")
	public String showForum(Model model) {
		Message message = new Message();
		List<Message> lm = md.findAll();
		model.addAttribute("message", message);
		model.addAttribute("list", lm);
		return "forum";
	}
	@GetMapping("/deleteMessage")
	public String deleteMessage(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Message currentMessage = md.findById(id).orElse(null);
		md.delete(currentMessage);
		return "redirect:/forum";
	}
	@GetMapping("/editMessage")
	public String editMessage(Integer id, Model model) {
		Message currMessage = md.findById(id).orElse(null);
		model.addAttribute("currMessage", currMessage);
		md.delete(currMessage);
		return "edit";
	}
	@PostMapping("/editMessage")
	public String finishEdit(Model model, Message currMessage) {
		currMessage.setUser(user);
		md.save(currMessage);
		Message message = new Message();
		List<Message> lm = md.findAll();
		model.addAttribute("message", message);
		model.addAttribute("list", lm);
		return "forum";
	}
	//finished messaging
	
	
	// Art Code
	@GetMapping("/gallery")
	public String showGallery(Model model) {
		Art artl = new Art();
		List<Art> listArt = ad.findAll();
		model.addAttribute("artl", artl);
		model.addAttribute("listArt", listArt);
		
		model.addAttribute("art", new Art());
		return "gallery";
	}
	@PostMapping("/saveArt")
	public String fileUpload(@ModelAttribute("art") @Validated Art art, Model model) {
		art.setUser(user);
		ad.save(art);
		model.addAttribute("art", art);
		return "redirect:./gallery";
	}
	//finished art
	
	
	
}