package org.alexis.mon1erMvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.alexis.mon1erMvc.service.UserService;
import org.alexis.mon1erMvc.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		ModelAndView model = new ModelAndView("home");
		
		UserService users = new UserServiceImpl();
		
		model.addObject("listUser", users.getUsers());
		
		return model;
	}
}
