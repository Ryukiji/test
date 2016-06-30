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
public class SalonController {
	
	private SalonService salonService;
	
	@Autowired(required=true)
	@Qualifier(value="salonService")
	public void setSalonService(SalonService ps){
		this.salonService = ps;
	}
	
	@RequestMapping(value = "/salons", method = RequestMethod.GET)
	public String listSalons(Model model) {
		model.addAttribute("salon", new Salon());
		model.addAttribute("listSalons", this.salonService.listSalons());
		return "salon";
	}
	
	//For add and update salon both
	@RequestMapping(value= "/salon/add", method = RequestMethod.POST)
	public String addSalon(@ModelAttribute("salon") Salon p){
		
		if(p.getId() == 0){
			//new salon, add it
			this.salonService.addSalon(p);
		}else{
			//existing salon, call update
			this.salonService.updateSalon(p);
		}
		
		return "redirect:/salons";
		
	}
	
	@RequestMapping("/removeSalon/{id}")
    public String removeSalon(@PathVariable("id") int id){
		
        this.salonService.removeSalon(id);
        return "redirect:/salons";
    }
 
    @RequestMapping("/editSalon/{id}")
    public String editSalon(@PathVariable("id") int id, Model model){
        model.addAttribute("salon", this.salonService.getSalonById(id));
        model.addAttribute("listSalons", this.salonService.listSalons());
        return "salon";
    }
	
}
