package repository;

import org.springframework.data.repository.CrudRepository;

public interface EmplyoeeRepository extends CrudRepository<Employee,Long> {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
