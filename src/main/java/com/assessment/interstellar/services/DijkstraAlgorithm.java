/**
 * 
 */
package com.assessment.interstellar.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.assessment.interstellar.models.Planet;
import com.assessment.interstellar.models.PlanetGraph;
import com.assessment.interstellar.models.Route;

/**
 * @author nkeng
 *
 */
public class DijkstraAlgorithm {
	
	private final List<Planet> nodes;
	private final List<Route> edges;
	private Set<Planet> settledNodes;
	private Set<Planet> unSettledNodes;
	private Map<Planet, Planet> predecessors;
	private Map<Planet, Double> distance;
	
	public DijkstraAlgorithm(PlanetGraph graph) {
		this.nodes = new ArrayList<Planet>(graph.getPlanets());
		this.edges = new ArrayList<Route>(graph.getRoutes());
	}
	
	
	
	public void execute(Planet source) {
		settledNodes = new HashSet<Planet>();
		unSettledNodes = new HashSet<Planet>();
		distance = new HashMap<Planet, Double>();
		predecessors = new HashMap<Planet, Planet>();
		distance.put(source, 0d);
		unSettledNodes.add(source);
		while(unSettledNodes.size() > 0) {
			Planet node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}
	
	
	public LinkedList<Planet> getPath(Planet target){
		LinkedList<Planet> path = new LinkedList<Planet>();
		Planet step = target;
		if(predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while(predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		
		Collections.reverse(path);
		return path;
	}
	
	
	private void findMinimalDistances(Planet node) {
		List<Planet> adjacentNodes = getNeighbours(node);
		for(Planet target : adjacentNodes) {
			if(getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target,getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target,node);
				unSettledNodes.add(target);
			}
		}
	}
	
	
	private double getDistance(Planet node, Planet target) {
		double dist = 0.0;
		for(Route edge : edges) {
			if(edge.getPlanetOrigin().equals(node) && edge.getPlanetDestination().equals(target)) {
				dist = edge.getDistance();
			}
		}
		return dist;
	}
	
	
	private List<Planet> getNeighbours(Planet node){
		List<Planet> neighbours = new ArrayList<>();
		for(Route edge : edges) {
			if(edge.getPlanetOrigin().equals(node) && !isSettled(edge.getPlanetDestination())) {
				neighbours.add(edge.getPlanetDestination());
			}
		}
		
		return neighbours;
	}
	
	private Planet getMinimum(Set<Planet> vertexes) {
		Planet minimum = null;
		for(Planet vertex : vertexes) {
			if(minimum == null) {
				minimum = vertex;
			}else {
				if(getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Planet vertex) {
		return settledNodes.contains(vertex);
	}
	
	private double getShortestDistance(Planet destination) {
		Double d = distance.get(destination);
		return  d == null ? Double.MAX_VALUE : d;
	}
}
