/**
 * 
 */
package com.assessment.interstellar.models;

/**
 * @author nkeng
 *
 */
public class CalculateForm {
	
	private String planetOrigin;
	
	private String planetDestination;
	
	
	
	

	public CalculateForm(String planetOrigin, String planetDestination) {
		super();
		this.planetOrigin = planetOrigin;
		this.planetDestination = planetDestination;
	}

	public String getPlanetOrigin() {
		return planetOrigin;
	}

	public void setPlanetOrigin(String planetOrigin) {
		this.planetOrigin = planetOrigin;
	}

	public String getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(String planetDestination) {
		this.planetDestination = planetDestination;
	}
	
	

}
