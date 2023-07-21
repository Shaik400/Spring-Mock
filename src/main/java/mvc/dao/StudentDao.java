package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mvc.dto.Student;

@Component
public class StudentDao {

	@Autowired
	EntityManager manager;

	public void save(Student student) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	public List<Student> fetchAll() {
		return manager.createQuery("select x from Student x").getResultList();
	}

	public List<Student> fetchByName(String name) {
		return manager.createQuery("select x from Student x where name=?1").setParameter(1, name).getResultList();
	}

}
