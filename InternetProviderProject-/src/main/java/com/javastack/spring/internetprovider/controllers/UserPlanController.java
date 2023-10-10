package com.javastack.spring.internetprovider.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javastack.spring.internetprovider.models.UserPlan;
import com.javastack.spring.internetprovider.services.UserPlanService;
import com.javastack.spring.internetprovider.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserPlanController {
	@Autowired
	private UserService userServ;
	@Autowired
	private UserPlanService userplanServ;
	
	@GetMapping("/homepage") // Landing page after register login
	public String dashboard(HttpSession session, Model viewModel,
			@ModelAttribute("newUserPlan") UserPlan newUserPlan) {
		

		// if nothing in session it would send directly to the main page /
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		// send a message to the service to grab the user on the saved ID in session, then save in in the model
		viewModel.addAttribute("loggedUser", userServ.findById(userID));

		return "homepage.jsp";
	}

	//This happens when user filled up the form, and add it to the db
	@PostMapping("/plan/checkout")
	public String addUserPlanToDB(@Valid @ModelAttribute("newUserPlan") UserPlan newUserPlan,
			BindingResult result, HttpSession session, Model viewModel) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		if(result.hasErrors()) {
			viewModel.addAttribute("loggedUser", userServ.findById(userID));
			return "homepage.jsp";
		} else {
			UserPlan updatedUserPlan = userplanServ.createUserPlan(newUserPlan);
			return "redirect:/plan/account/" + updatedUserPlan.getId(); 
		}
	}
//	@GetMapping("/homepage/myaccount")
//	public String myAccount() {
//		return "accountinfo.jsp";
//	}
	
	
	// this checks the account of the User
	@GetMapping("/plan/account/{id}")
	public String checkOutUser(@PathVariable Long id, HttpSession session, Model viewModel) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		// send a message to the service to grab the user on the saved ID in session, then save in in the model
		viewModel.addAttribute("loggedUser", userServ.findById(userID));
		
		// Grab the UserPlan by the ID
		viewModel.addAttribute("thisUserPlan", userplanServ.getByIdUserPlan(id));
		return "accountinfo.jsp";
	}
	
	
	// Edit the account of the specific user
	@GetMapping("/plan/edit/{id}")
	public String editUserPlan(@PathVariable Long id, HttpSession session, Model viewModel) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		// send a message to the service to grab the user on the saved ID in session, then save in in the model
		viewModel.addAttribute("loggedUser", userServ.findById(userID));
		
		// Grab the UserPlan by the ID
		viewModel.addAttribute("thisUserPlan", userplanServ.getByIdUserPlan(id));
		return "editplan.jsp";
	}
	
	// this would Edit the account if the account is exist.
	@PutMapping("/plan/editDB/{id}")
	public String editUserPlanDB(@Valid @ModelAttribute("thisUserPlan") UserPlan thisUserPlan,
			Model viewModel, @PathVariable Long id,
			BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		// if there is error, take it back to the edit plan, else redirect checkoutplan
		if (result.hasErrors()) {
			viewModel.addAttribute("thisUserPlan", userplanServ.getByIdUserPlan(id).getLastname());
			return "editplan.jsp";
		} else {
			UserPlan updatedUserPlan = userplanServ.createUserPlan(thisUserPlan);
			return "redirect:/plan/account/" + updatedUserPlan.getId();
		}

	}
	
	// Delete Account
	
	@DeleteMapping("/plan/delete/{id}")
	public String deleteAccount(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
	}
			userplanServ.deleteUserPlan(id);
			return "redirect:/homepage";
	
	}

}
