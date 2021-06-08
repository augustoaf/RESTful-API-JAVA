package com.myapp.restservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.restservice.model.Vehicle;
import com.myapp.restservice.service.VehicleService;

@RestController
public class VehicleController {

	private VehicleService vehicleService = VehicleService.getInstance();
	
	
	@GetMapping("/vehicle")
	public List<Vehicle> vehicle(@RequestParam(value = "id", defaultValue = "null") String id) {
		
		if (!id.equals("null")) {
			return vehicleService.getVehicle(Integer.valueOf(id));  
		}
		
		return vehicleService.getVehicle(null);
		
	}
	
	//@RequestBody is a annotation to extract the HTTP request Body
	//JSONObject is a class from com.googlecode.json-simple package which encode/decode a JSON Body type to a Java Object
	@PostMapping("/vehicle")
	//@ResponseBody
	public Vehicle addVehicle(@RequestBody JSONObject payload) {
		
		Vehicle vehicle = null;
		
		if (this.isJSONValid(payload.toString())) {
			Integer id = (Integer)payload.get("id");
			String model = (String)payload.get("model");
			String manufacturer = (String)payload.get("manufacturer");
			
			
			vehicle = vehicleService.addVehicle(id, model, manufacturer);
		}
		
		return vehicle;
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(vehicle.getId().toString()).build().toUri();
		//return ResponseEntity.created(uri).body(vehicle);
	}
	
	//candidate to abstract class
	private boolean isJSONValid(String jsonInString) {
	    try {
	       return new ObjectMapper().readTree(jsonInString) != null;
	    } catch (IOException e) {
	       return false;
	    }
	}
}
