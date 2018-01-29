package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Employee;
import repository.EmplyoeeRepository;

@Service("employeeService")
public class EmployeeService {
    @Autowired
    EmplyoeeRepository employeeRepository;

    public void save(String fName, String lName) {
        Employee employee = new Employee();
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setInCompany(true);
        employeeRepository.save(employee);
    }

    public boolean update(String fName, String lName, String fNameNew, String lNameNew) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(fName, lName);
        if (employee != null && !employee.isInCompany()) return false;
        employee.setFirstName(fNameNew);
        employee.setLastName(lNameNew);
        return true;
    }

    public boolean delete(String fName, String lName) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(fName, lName);
        if (employee != null && !employee.isInCompany()) return false;
        employeeRepository.delete(employee);
        return true;
    }
}
