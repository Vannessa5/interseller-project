/**
 * 
 */
package com.assessment.interstellar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment.interstellar.models.PlanetRoute;
import com.assessment.interstellar.repository.RouteRepository;

/**
 * @author nkeng
 *
 */
@Service
public class RouteServiceImpl implements RouteService {
	
	private RouteRepository routeRepository;
	
	public RouteServiceImpl(final RouteRepository repo) {
		this.routeRepository = repo;
	}

	public List<PlanetRoute> getAllRoutes(){
		return this.routeRepository.findAll();
	}
	
	public PlanetRoute findRouteById(int id) {
		return this.routeRepository.getById(id);
	}
	
	
	@Override
	public void saveRoutes(List<PlanetRoute> routeList) {
		routeList.stream().forEach(route -> {
			this.routeRepository.save(route);
		});

	}

}
