package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeRepository")
public interface EmployeeRepository  extends CrudRepository<CurrentEmployee,Long> {
    CurrentEmployee findByFirstNameAndLastName(String firstName, String lastName);
}
