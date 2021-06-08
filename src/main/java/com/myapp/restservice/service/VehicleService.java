package com.myapp.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.myapp.restservice.model.Vehicle;

public class VehicleService {

	private static VehicleService service;
	private Set<Vehicle> fleet = new TreeSet<Vehicle>();
		
	private VehicleService() {
		//private constructor due singleton pattern
	}
	
	public static VehicleService getInstance() {
		
		if (service == null) {
			service = new VehicleService(); 
			
			//add vehicle here just for test purpose
			service.addVehicle(new Vehicle(1, "Renegade", "Fiat"));
			service.addVehicle(new Vehicle(2, "Compass", "Fiat"));
			
		}		
		return service;		
	}
	
	public void addVehicle(Vehicle vehicle) {
		
		fleet.add(vehicle);
	}
	
	public Vehicle addVehicle(Integer id, String model, String manufacturer) {
		
		Vehicle vehicle = new Vehicle(id, model, manufacturer);
		fleet.add(vehicle);
		
		return vehicle;
	}
	
	public List<Vehicle> getVehicle(Integer id) {
		
		List<Vehicle> vehiclesList;
		
		if (id != null) {
				
			vehiclesList = new ArrayList<Vehicle>();
			
			for (Vehicle vehicle : fleet) {
				if (vehicle.getId() == id)
					
					vehiclesList.add(vehicle);
			}
		}
		else {
			vehiclesList = new ArrayList<Vehicle>(fleet); 
		}
		
		return vehiclesList; 
	}
}
