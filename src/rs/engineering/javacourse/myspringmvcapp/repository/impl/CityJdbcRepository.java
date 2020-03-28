package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.sql.ResultSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;



@Repository
public class CityJdbcRepository implements CityRepository<City>{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CityJdbcRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(City city) {
		String query = "INSERT INTO city VALUES (?,?)";
		jdbcTemplate.update(query,city.getNumber(),city.getName());
	}

	public List<City> getAll() {
		String query = "SELECT * FROM city";
		return jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {

			City city = new City();
			city.setNumber(rs.getLong("number"));
			city.setName(rs.getString("name"));
		
			return city;
		});

	}

	@Override
	public City findById(Long id) {
		String query = "SELECT * FROM city WHERE number = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, (ResultSet rs, int rowNumber) -> {
			City city = new City();
			city.setNumber(rs.getLong("number"));
			city.setName(rs.getString("name"));
	
			return city;
		});

	}
	

}
