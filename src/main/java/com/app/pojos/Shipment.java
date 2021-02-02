package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Shipment")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shipmentID;
	@Column(name="ShipmentName")
	private String SName;
	@Column (name="ContactDetails")
	private String SContactNumber;
	
	@Column(name="TotalOrder")
	private int TotalOrderDeliver;
	
	
	/*
	 * @OneToOne(mappedBy = "ShipID" ,cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private Orders Oid;
	 */
	public Shipment() {
		System.out.println("in "+getClass().getName());
	}
	public Shipment(Integer shipmentID, String sName, String sContactNumber, int totalOrderDeliver) {
		super();
		this.shipmentID = shipmentID;
		SName = sName;
		SContactNumber = sContactNumber;
		TotalOrderDeliver = totalOrderDeliver;
	}


	public Integer getShipmentID() {
		return shipmentID;
	}


	public void setShipmentID(Integer shipmentID) {
		this.shipmentID = shipmentID;
	}


	public String getSName() {
		return SName;
	}


	public void setSName(String sName) {
		SName = sName;
	}


	public String getSContactNumber() {
		return SContactNumber;
	}


	public void setSContactNumber(String sContactNumber) {
		SContactNumber = sContactNumber;
	}


	public int getTotalOrderDeliver() {
		return TotalOrderDeliver;
	}


	public void setTotalOrderDeliver(int totalOrderDeliver) {
		TotalOrderDeliver = totalOrderDeliver;
	}


	@Override
	public String toString() {
		return "Shipment [shipmentID=" + shipmentID + ", SName=" + SName + ", SContactNumber=" + SContactNumber + "]";
	}
	
	
	
	
}
