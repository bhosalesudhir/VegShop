package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	@Column(name = "FNAME", length = 10)
	private String Fname;
	@Column(name = "LNAME", length = 10)
	private String Lname;
	@Column(name = "GENDER", length = 6)
	private String Gender;
	

	@Column(length = 10,nullable = false)
	private String ContactNo;
	
	private LocalDate DOR;
	

	// Users, Adddress have has relation ship so its Entity ->value relationship
	@Embedded // optional
	private Address Uaddre;


	@OneToOne()// owning side 
	@JoinColumn(name = "roleid",nullable = false)
	private Role RoleID;

	
	public Users() {
		System.out.println("Users default constructor class");
	}


	


	public Users(String fname, String lname, String gender, String contactNo, LocalDate dOR, Address uaddre,
			Role roleID) {
		
		Fname = fname;
		Lname = lname;
		Gender = gender;
		ContactNo = contactNo;
		DOR = dOR;
		Uaddre = uaddre;
		RoleID = roleID;
	}





	public Integer getUserId() {
		return UserId;
	}


	public void setUserId(Integer userId) {
		UserId = userId;
	}


	public String getFname() {
		return Fname;
	}


	public void setFname(String fname) {
		Fname = fname;
	}


	public String getLname() {
		return Lname;
	}


	public void setLname(String lname) {
		Lname = lname;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public Address getUaddre() {
		return Uaddre;
	}


	public void setUaddre(Address uaddre) {
		Uaddre = uaddre;
	}


	public Role getRoleID() {
		return RoleID;
	}


	public void setRoleID(Role roleID) {
		RoleID = roleID;
	}


	// add helper method for Customer->address (Entity -> value ) on Entity p-> c only
	public void addAddress(Address a)
	{
		this.Uaddre=a;
	}
	public void removeAddress()
	{
		this.Uaddre=null;
	}





	@Override
	public String toString() {
		return "Users [UserId=" + UserId + ", Fname=" + Fname + ", Lname=" + Lname + ", Gender=" + Gender
				+ ", ContactNo=" + ContactNo + ", DOR=" + DOR + ", Uaddre=" + Uaddre + ", RoleID=" + RoleID + "]";
	}
	
}
