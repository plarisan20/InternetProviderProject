package com.javastack.spring.internetprovider.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javastack.spring.internetprovider.models.LoginUser;
import com.javastack.spring.internetprovider.models.User;
import com.javastack.spring.internetprovider.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	@Autowired

	
	// Base WebPage
	@GetMapping("/")
	public String webPage() {
		return "webpage.jsp";
	}
	
	@GetMapping("/register") // Display the login/registration page
	public String regPage(@ModelAttribute("registerUser") User registerUser) {
		return "registration.jsp";
	}
	
	// User Registration
	@PostMapping("/register") // Handle registration from form
	public String processRegistration(@Valid @ModelAttribute("registerUser") 
		User newUser, BindingResult result,
		@ModelAttribute("loginUser")LoginUser loginUser, HttpSession session) {
		User newAccount = userServ.register(newUser, result);
		if(result.hasErrors()) {
			return "registration.jsp";
		} else {
			// this woudld Register the user in the DB
			// Save the ID of the logged in user in session
			session.setAttribute("userId", newAccount.getId());
			return "redirect:/homepage";		
		}
	}
	
	// User Log in Get Mapping if user already has an Account
	@GetMapping("/login") // Display the login/registration page
	public String loginPage(@ModelAttribute("loginUser") LoginUser loginUser) {
		return "login.jsp";
	}
	
	@PostMapping("/login") // Handle the login form
	public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result, Model model,
			HttpSession session) {
		
		//perform the validation, and get the User if the credentials are correct
		User foundUser= userServ.login(loginUser, result);
		if (result.hasErrors()) { // if the validation is incorrect
			model.addAttribute("registerUser", new User());
			return "login.jsp"; 
		} else {
			// if everything is good
			session.setAttribute("userId", foundUser.getId());
			return "redirect:/homepage";
			
			
		}
	}
	// Fix this later in order for the existing user to connect directly to their account
//	@PostMapping("/login")
//	public String processLogin(
//			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
//	        BindingResult result, Model model,
//	        HttpSession session, RedirectAttributes redirectAttributes) {
//	    // perform the validation, and get the User if the credentials are correct
//	    User foundUser = userServ.login(loginUser, result);
//	    if (result.hasErrors()) { // if the validation is incorrect
//	        model.addAttribute("registerUser", new User());
//	        return "login.jsp";
//	    } else {
//	        // if everything is good
//	        session.setAttribute("userId", foundUser.getId());
//	        // Redirect to the desired URL and pass the id as a parameter
//	        redirectAttributes.addAttribute("id", foundUser.getId());
//	        return "redirect:/plan/account/{id}";
//	    }
//	}
//
//	

	
	@GetMapping("/logout")  // Logging out from the app
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	


}
