/**
 * 
 */
package com.assessment.interstellar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.interstellar.models.PlanetRoute;

/**
 * @author nkeng
 *
 */
@Repository
public interface RouteRepository extends JpaRepository<PlanetRoute, Integer> {

}
