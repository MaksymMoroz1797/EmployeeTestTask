package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("emplyoeeRepository")
public interface EmplyoeeRepository extends CrudRepository<Employee,Long> {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
