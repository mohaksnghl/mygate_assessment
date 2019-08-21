package com.mygate.assesment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygate.assesment.document.Status;
import com.mygate.assesment.document.Truck;
import com.mygate.assesment.repo.Repo;

@Service
public class TruckService {
	
	@Autowired
	private Repo repo;
	
	public List<Truck> getAllTrucks(){
		List<Truck> trucks = repo.findAll();
		return trucks;
	}
	
	public void update(Truck truck) {
		repo.save(truck);
	}
	
	public List<Truck> getByApplicantName(String applicant) {
		List<Truck> trucks = repo.findByApplicant(applicant);
		return trucks;
	}

	public List<Truck> getByStreetName(String street) {
		List<Truck> trucks = repo.findByStreetName(street);
		return trucks;
	}
	

	public List<Truck> getByExpiryDate(String date) throws ParseException{
		List<Truck> allTrucks = getAllTrucks();
		List<Truck> expiredTrucks = new ArrayList<>();
		SimpleDateFormat sdfo = new SimpleDateFormat("dd-MM-yyyy");
		
		Date lastDate = sdfo.parse(date);
		//System.out.println(lastDate);
		for(int i=0; i<allTrucks.size(); i++) {
			
			Truck truck = allTrucks.get(i);
			
			String expirationdate = truck.getExpirationdate();
			if(expirationdate != null) {
				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
				try {
					Date d = inputFormat.parse(expirationdate);
					if(!d.after(lastDate)) {
						//System.out.println(d);
						expiredTrucks.add(truck);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return expiredTrucks;	
	}
	
	public List<Truck> autoExpire() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String date = df.format(today);
		
		List<Truck> expired = getByExpiryDate(date);
		
		for(int i=0; i<expired.size(); i++) {
			
			Truck truck = expired.get(i);
			truck.setStatus(Status.EXPIRED);
			//System.out.println(truck.getStatus());
			update(truck);
		}
		
		return getByExpiryDate(date);
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		
		Truck truck = repo.findByObjectId(Integer.toString(id));
		if(truck == null) {
			return false;
		}
		else {
			repo.delete(truck);
			return true;
		}
	}

	public boolean addTruck(Truck truck) {
		// TODO Auto-generated method stub
		Truck t = repo.findByObjectId(truck.getObjectid());
		if(t==null) {
			repo.save(truck);
			return true;
		}
		return false;
	}
}
