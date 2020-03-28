package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CompanyJpaRepository implements CompanyRepository<Company> {

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(Company company) {
		
		
		entityManager.persist(company);
		
	}

	@Override
	public List<Company> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT c FROM Company c").getResultList();
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Company.class, id);
	}

	@Override
	public void remove(Long id) {
		Company company = findById(id);
		entityManager.remove(company);
	}

	@Override
	public void edit(Company company) {
		// TODO Auto-generated method stub
		entityManager.merge(company);
		
	}

}
