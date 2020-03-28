package rs.engineering.javacourse.myspringmvcapp.repository;

import java.util.List;



public interface CityRepository<T> {
	void save(T city);
	List<T> getAll();
	T findById(Long id);
}
