package com.mygate.assesment.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mygate.assesment.service.TruckService;
import com.mygate.assesment.document.Truck;

@RestController
public class Controller {

	private TruckService truckService;
	
	
	public Controller(TruckService truckService) {
		super();
		this.truckService = truckService;
	}
	
	@GetMapping("")
	public String hello() {
		return "Hello";
	}	
	
	//All Trucks
	@GetMapping("trucks")
	public List<Truck> getAll(){
		List<Truck> trucks = truckService.getAllTrucks();
		return trucks;
	}
	
	//Search by name of applicant
	@GetMapping("{applicant}")
	public List<Truck> getByApplicant(@PathVariable("applicant") String applicant){
		List<Truck> trucks = truckService.getByApplicantName(applicant);
		
		return trucks;
	}
	
	//Search by expiration date, to find whose permits have expired
	@GetMapping("trucks/expired/{date}")
	public List<Truck> getExpiredTrucks(@PathVariable("date") String date) throws ParseException{
		List<Truck> trucks = truckService.getByExpiryDate(date);
		return trucks;
	}
	
	//Search by street name
	@GetMapping("trucks/{street}")
	public List<Truck> getByStreet(@PathVariable("street") String street){
		List<Truck> trucks = truckService.getByStreetName(street);
		return trucks;
	}
	
	//Add new food truck
	@PostMapping("trucks")
	public ResponseEntity<Truck> createEntry(@RequestBody Truck truck){
		boolean isAdded = truckService.addTruck(truck);
		
		if(!isAdded) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(truck, HttpStatus.CREATED);
	}
	
	//Delete a food truck by objectId
	@DeleteMapping("trucks/{id}")
	public ResponseEntity<Integer> deleteEntry(@PathVariable("id") int id){
		boolean isRemoved = truckService.delete(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	
	//Auto expiry of licenses
	@PutMapping("trucks/autoexpire")
	public ResponseEntity<List<Truck>> autoexpire() throws ParseException {
		List<Truck> trucks = truckService.autoExpire();
		return new ResponseEntity<>(trucks, HttpStatus.OK);
	}	
}
