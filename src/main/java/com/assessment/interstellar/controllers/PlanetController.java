/**
 * 
 */
package com.assessment.interstellar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assessment.interstellar.services.PlanetServiceImpl;

/**
 * @author nkeng
 *
 */
@Controller
public class PlanetController {
	
	@Autowired
	private PlanetServiceImpl planetService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/list-planets", method = RequestMethod.GET)
	public String showAllPlanets(ModelMap model) {
		model.put("planets", planetService.getAllPlanets());
		return "list-planets";
	}

}
