package com.hibernate.onetoone.model;

import java.util.Date;


public class Transactions {
	private int id;
	private Date date;
	private int total;
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", date=" + date + ", total=" + total + ", customer=" + customer + "]";
	}
	
	
}
