package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Employee;
import repository.EmplyoeeRepository;
import repository.Event;
import repository.EventRepository;

import java.util.Date;

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
        Event event = new Event();
        event.setAction(Event.Action.CREATE);
        event.setDate(new Date(System.currentTimeMillis()));
        employee.getHistory().add(event);
    }

    public boolean update(String fName, String lName, String fNameNew, String lNameNew) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(fName, lName);
        if (employee == null || !employee.isInCompany()) return false;
        employee.setFirstName(fNameNew);
        employee.setLastName(lNameNew);
        Event event = new Event();
        event.setAction(Event.Action.UPDATE);
        event.setDate(new Date(System.currentTimeMillis()));
        employee.getHistory().add(event);
        return true;
    }

    public boolean delete(String fName, String lName) {
        Employee employee = employeeRepository.findByFirstNameAndLastName(fName, lName);
        if (employee == null || !employee.isInCompany()) return false;
        employeeRepository.delete(employee);
        Event event = new Event();
        event.setAction(Event.Action.DELETE);
        event.setDate(new Date(System.currentTimeMillis()));
        employee.getHistory().add(event);
        return true;
    }
}
