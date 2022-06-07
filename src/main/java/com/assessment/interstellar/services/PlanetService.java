/**
 * 
 */
package com.assessment.interstellar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment.interstellar.models.Planet;

/**
 * @author nkeng
 *
 */
@Service
public interface PlanetService {

	void savePlanets(List<Planet> planetList);
	
	
}
