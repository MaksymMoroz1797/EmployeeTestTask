package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees/save", method = RequestMethod.POST)
    void saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        employeeService.save(employee.getFirstName(), employee.getLastName());
    }

    @RequestMapping(value = "/employees/update", method = RequestMethod.PUT)
    ResponseEntity<String> updateEmployee(@ModelAttribute("employee") EmployeeDTO employee,
                          @ModelAttribute("updateEmployee") EmployeeDTO updateEemployee) {
        boolean result = employeeService.update(employee.getFirstName(), employee.getLastName(),
                updateEemployee.getFirstName(), updateEemployee.getLastName());
        if (result) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/employees/delete", method = RequestMethod.DELETE)
    ResponseEntity<String> deleteEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        boolean result = employeeService.delete(employee.getFirstName(), employee.getLastName());
        if (result) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
