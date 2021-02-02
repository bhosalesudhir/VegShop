package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private Integer OrderId;

	@ManyToOne // veetable1-->Orders*
	@JoinColumn(name = "VegetableId", nullable = false)
	private Vegetables VegetableId;

	@ManyToOne //
	@JoinColumn(name = "CustomerId", nullable = false)
	private Role oRoleId;

	@Column(name = "orderNum")
	private Integer orderNum;

	@Column(name = "OrderStatus")
	private Integer OStatus;

	@Column(name = "PaymentMode")
	private String PaymentMode;

	@Column(name = "PaymentStatus")
	private String PaymentStatus;

	@Column(name = "OrderDate")
	private LocalDate OrderDate;

	@Column(name = "unitprice")
	private Double Unitprice;
	@Column(name = "Qty")
	private Double Qty;
	@Column(name = "amount")
	private Double TotalAmount;

	/*
	 * @OneToOne // owning side ,fk side
	 * 
	 * @JoinColumn(name="ShipmentBoyId",nullable = false) 
	 * 	 */
	@Column(name = "ShipmentBoyId")
	private Integer ShipID;

	public Orders() {
		System.out.println("in default constructor of Orders ");
	}

	public Orders(Vegetables vegetableId, Role roleId, Integer orderNum, Integer oStatus, String paymentMode,
			String paymentStatus, LocalDate orderDate, Double unitprice, Double Qty, Double TotalAmount
	,Integer shipID ) {

		VegetableId = vegetableId;
		oRoleId = roleId;
		this.orderNum = orderNum;
		OStatus = oStatus;
		PaymentMode = paymentMode;
		PaymentStatus = paymentStatus;
		OrderDate = orderDate;
		this.Unitprice = unitprice;
		this.Qty = Qty;
		this.TotalAmount = TotalAmount;
		this.ShipID = shipID; 
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		this.OrderId = orderId;
	}

	public Vegetables getVegetableId() {
		return VegetableId;
	}

	public void setVegetableId(Vegetables vegetableId) {
		VegetableId = vegetableId;
	}

	public Role getoRoleId() {
		return oRoleId;
	}

	public void setoRoleId(Role oRoleId) {
		this.oRoleId = oRoleId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOStatus() {
		return OStatus;
	}

	public void setOStatus(Integer oStatus) {
		OStatus = oStatus;
	}

	public String getPaymentMode() {
		return PaymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public LocalDate getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}

	public double getUnitprice() {
		return Unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.Unitprice = unitprice;
	}

	public double getQty() {
		return Qty;
	}

	public void setQty(Double Qty) {
		this.Qty = Qty;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double TotalAmount) {
		this.TotalAmount = TotalAmount;
	}

	public Integer getShipID() {
		return ShipID;
	}

	public void setShipID(Integer shipID) {
		this.ShipID = shipID;
	}

	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", VegetableId=" + VegetableId + ", RoleId=" + oRoleId + ", orderNum="
				+ orderNum + ", OStatus=" + OStatus + ", PaymentMode=" + PaymentMode + ", PaymentStatus="
				+ PaymentStatus + ", OrderDate=" + OrderDate + ", unitprice=" + Unitprice + ", Qty=" + Qty
				+ ", TotalAmount=" + TotalAmount  + ", ShipID=" + ShipID + "]";
	}


}