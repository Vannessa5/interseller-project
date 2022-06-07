/**
 * 
 */
package com.assessment.interstellar.services;

import java.util.List;

import com.assessment.interstellar.models.PlanetRoute;

/**
 * @author nkeng
 *
 */
public interface RouteService {

	void saveRoutes(List<PlanetRoute> routeList);
}
