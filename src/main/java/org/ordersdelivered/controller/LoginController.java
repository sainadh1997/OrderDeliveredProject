package org.ordersdelivered.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/")

	private String index() {
		return "enterlogin";

	}

	@PostMapping("/ServletClass")
	private String menu(ModelMap model, @RequestParam String uname, @RequestParam String psw) {
		if (uname.equals("sainadh") && psw.equals("password")) {
			model.addAttribute(uname, "username");
			return "homepage";
		} else {
			model.put("error", "Invalid username and password");
			return "login";
		}
	}

}
