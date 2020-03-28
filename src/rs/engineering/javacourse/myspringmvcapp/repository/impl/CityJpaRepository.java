package rs.engineering.javacourse.myspringmvcapp.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CityJpaRepository implements CityRepository<City> {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void save(City city) {
		entityManager.persist(city);
		
	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT c from City c").getResultList();
	}

	@Override
	public City findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(City.class, id);
	}



}
