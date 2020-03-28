package rs.engineering.javacourse.myspringmvcapp.service;

import java.util.List;


public interface CompanyService<T> {
	void save(T companyDto);
	List<T> getAll();
	T findById(Long id);
	void remove(Long id);
	void edit(T companyDto);;

}
