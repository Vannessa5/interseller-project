/**
 * 
 */
package com.assessment.interstellar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.interstellar.models.PlanetRoute;
import com.assessment.interstellar.services.RouteServiceImpl;

/**
 * @author nkeng
 *
 */

@RestController
public class RouteController {
	
	@Autowired
	private RouteServiceImpl routeService;
	
	@RequestMapping(value="/routes" ,method=RequestMethod.GET)
	public List<PlanetRoute> getAllRoutes(){
		return this.routeService.getAllRoutes();
	}

}
