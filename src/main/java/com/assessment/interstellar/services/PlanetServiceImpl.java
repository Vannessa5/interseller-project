/**
 * 
 */
package com.assessment.interstellar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.interstellar.models.Planet;
import com.assessment.interstellar.repository.PlanetRepository;

/**
 * @author nkeng
 *
 */
@Service
public class PlanetServiceImpl implements PlanetService {
	
	private PlanetRepository planetRepository;
	
	
	public PlanetServiceImpl(final PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	

	public List<Planet> getAllPlanets(){
		return this.planetRepository.findAll();
	}
	
	public Planet getPlanetById(String id) {
		return this.planetRepository.getById(id);
	}
	
	@Override
	public void savePlanets(List<Planet> planetList) {
		planetList.stream().forEach(planet -> {
			this.planetRepository.save(planet);
		});

	}

}
