package com.hibernate.onetomany.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cart")
@SequenceGenerator(
name = "cart_seq", 
sequenceName = "cart_seq" ,
initialValue = 1, allocationSize = 1)
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@Column(name="cart_id")
	private int id;
	
	@Column(name="total")
	private double total;
	
	@Column(name="cname")
	private String name;
	
	@OneToMany(mappedBy="cart",cascade = CascadeType.ALL)
	private Set<Items> items;
	
	
	public Cart() {}

	public Cart(int id, double total, String name, Set<Items> items1) {
		this.id = id;
		this.total = total;
		this.name = name;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", name=" + name + ", items1=" + items + "]";
	}
	
	
}
