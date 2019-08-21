package com.mygate.assesment.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygate.assesment.document.Truck;

@Repository
public interface Repo extends MongoRepository<Truck, String>{
	
	List<Truck> findByApplicant(String applicant);
	
	@Query(value = "{objectid: ?0}")
	Truck findByObjectId(String id);
	
	@Query(value = "{address: {$regex: ?0}}")
	List<Truck> findByStreetName(String street);

	
	
	
	//List<Truck> findByExpiryDate(Date date);
}
