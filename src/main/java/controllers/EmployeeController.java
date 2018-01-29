package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.CurrentEmployee;
import repository.EmployeeRepository;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees/save", method = RequestMethod.POST)
    void saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        CurrentEmployee currentEmployee = new CurrentEmployee();
        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        employeeRepository.save(currentEmployee);
    }

    @RequestMapping(value = "/employees/update", method = RequestMethod.PUT)
    ResponseEntity<String> updateEmployee(@ModelAttribute("employee") EmployeeDTO employee,
                          @ModelAttribute("updeteemployee") EmployeeDTO updatEemployee) {
        CurrentEmployee currentEmployee = employeeRepository.findByFirstNameAndLastName(employee.getLastName(),
                employee.getLastName());
        if (currentEmployee != null) {
            currentEmployee.setFirstName(updatEemployee.getFirstName());
            currentEmployee.setLastName(updatEemployee.getLastName());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/employees/update", method = RequestMethod.POST)
    ResponseEntity<String> deleteEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        CurrentEmployee currentEmployee = employeeRepository.findByFirstNameAndLastName(employee.getLastName(),
                employee.getLastName());
        if (currentEmployee != null) {
            employeeRepository.delete(currentEmployee);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
