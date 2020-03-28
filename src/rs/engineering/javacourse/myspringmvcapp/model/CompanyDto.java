package rs.engineering.javacourse.myspringmvcapp.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.catalina.tribes.tipis.AbstractReplicatedMap.MapMessage;


public class CompanyDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank(message = "Unesite ime")
	private String name;
	@NotBlank(message = "Unesite Adresu")
	private String address;
	@NotBlank(message = "Broj ulice")
	private String number;
	@NotNull(message = "Must choose a city")
	private CityDto cityDto;

	public CompanyDto() {
		super();
	}
	

	public CompanyDto(@NotEmpty(message = "name cannot be empty") String name,
			@NotEmpty(message = "address cannot be empty") String address, String number, CityDto citydto) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityDto = citydto;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto citydto) {
		this.cityDto = citydto;
	}


	


	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + ", cityDto="
				+ cityDto + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CompanyDto(Long id, @NotBlank(message = "Unesite ime") String name,
			@NotBlank(message = "Unesite Adresu") String address, @NotBlank(message = "Broj ulice") String number,
			CityDto cityDto) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityDto = cityDto;
	}
	
	

}
