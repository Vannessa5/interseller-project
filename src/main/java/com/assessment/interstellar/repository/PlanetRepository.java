/**
 * 
 */
package com.assessment.interstellar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.interstellar.models.Planet;

/**
 * @author nkeng
 *
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {

}
