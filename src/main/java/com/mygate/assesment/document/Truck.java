package com.mygate.assesment.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "food_truck")
public class Truck {
	@Id
	private String id;
	private String objectid;
	private String applicant;
	private String facilitytype;
	private int cnn;
	private String locationdescription;
	private String address;
	private String blocklot;
	private String permit;
	private Status status;
	private double x;
	private double y;
	private String schedule;
	private String received;
	private int priorpermit;
	private String expirationdate;
	private Object location;
	
		public Truck(String id, String objectid, String applicant, String facilitytype, int cnn,
			String locationdescription, String address, String blocklot, String block, String lot, String permit,
			Status status, double x, double y, String latitude, String longitude, String schedule, String received,
			int priorpermit, String expirationdate, Object location, String computedRegion1, String computedRegion2, String computedRegion3,
			String computedRegion4, String computedRegion5) throws Exception {
		super();
		this.id = id;
		this.objectid = objectid;
		this.applicant = applicant;
		this.facilitytype = facilitytype;
		this.cnn = cnn;
		this.locationdescription = locationdescription;
		this.address = address;
		this.blocklot = blocklot;
		this.permit = permit;
		this.status = status;
		this.x = x;
		this.y = y;
		this.schedule = schedule;
		this.received = received;
		this.priorpermit = priorpermit;
		this.expirationdate = expirationdate;
		this.location = location;
	}
	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getFacilitytype() {
		return facilitytype;
	}
	public void setFacilitytype(String facilitytype) {
		this.facilitytype = facilitytype;
	}
	public int getCnn() {
		return cnn;
	}
	public void setCnn(int cnn) {
		this.cnn = cnn;
	}
	public String getLocationdescription() {
		return locationdescription;
	}
	public void setLocationdescription(String locationdescription) {
		this.locationdescription = locationdescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlocklot() {
		return blocklot;
	}
	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getReceived() {
		return received;
	}
	public void setReceived(String received) {
		this.received = received;
	}
	public int getPriorpermit() {
		return priorpermit;
	}
	public void setPriorpermit(int priorpermit) {
		this.priorpermit = priorpermit;
	}
	public Object getLocation() {
		return location;
	}
	public void setLocation(Object location) {
		this.location = location;
	}
	
	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	
}
