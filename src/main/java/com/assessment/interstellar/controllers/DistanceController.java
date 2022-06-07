/**
 * 
 */
package com.assessment.interstellar.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.interstellar.models.CalculateForm;
import com.assessment.interstellar.models.Planet;
import com.assessment.interstellar.services.DijkstraAlgorithm;
import com.assessment.interstellar.services.DistanceCalculator;

/**
 * @author nkeng
 *
 */

@Controller
public class DistanceController {

	@Autowired
	private DistanceCalculator distanceCalculator;
	
	private LinkedList<Planet> shortestDistance = null;
	
	
	@RequestMapping(value="/calculate-distance", method=RequestMethod.GET)
	public String showCalculatePage(ModelMap model) {
		model.addAttribute("calculateForm", new CalculateForm("A","B"));
		return "calculate";
	}
	
	@RequestMapping(value= "/calculate-distance", method = RequestMethod.POST)
	public String calculateDistance(ModelMap model,CalculateForm calculateForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "calculate";
		}
		
		this.shortestDistance = distanceCalculator
				.calculateDistance(
						calculateForm.getPlanetOrigin(),
						calculateForm.getPlanetDestination()
						);
		
		model.put("nodes", shortestDistance);
		
		
		return "calculate";
	}
	
}
