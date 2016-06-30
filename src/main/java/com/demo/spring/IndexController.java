package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.spring.model.Salon;
import com.demo.spring.service.SalonService;

@Controller
public class IndexController {
	
	private SalonService salonService;
	
	@Autowired(required=true)
	@Qualifier(value="salonService")
	public void setSalonService(SalonService ps){
		this.salonService = ps;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listSalons(Model model) {
		model.addAttribute("salon", new Salon());
		model.addAttribute("listSalons", this.salonService.listSalons());
		return "salon";
	}
	
}
