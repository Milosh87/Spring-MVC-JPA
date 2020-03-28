package rs.engineering.javacourse.myspringmvcapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "company")
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431859546014606188L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String number;
	@OneToOne
	@JoinColumn(name = "cityDto", referencedColumnName = "number")
	private City city;
	public Company(String name, String address, City city) {
		super();

		this.name = name;
		this.address = address;
		this.city = city;
	}

	
	public Company() {
		super();
	}


	public Company(String name, String address, String number, City city) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.city = city;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", number=" + number + ", city=" + city + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Company(Long id, String name, String address, String number, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.city = city;
	}

	
	
	

}
