package org.alexis.mon1erMvc.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.alexis.mon1erMvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		ModelAndView model = new ModelAndView("home");
				
		model.addObject("listUser", userService.getUsers());
		
		return model;
	}
}
