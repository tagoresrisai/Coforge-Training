import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.html',
  styleUrl: './employee.css',
})
export class EmployeeComponent {

  employee: Employee = new Employee();
  result: string = "";

  constructor(private employeeService: EmployeeService) {}

  insertEmployee(data: any) {
    this.employee.eid = data.eid;
    this.employee.ename = data.ename;
    this.employee.esalary = data.esalary;
    this.employee.dno = data.dno;

    this.employeeService.insertEmployee(this.employee).subscribe({
      next: (response: any) => {
        this.result = response;
      },
      error: (error) => {
        this.result = error.error;
      }
    });
  }
  updateEmployee(data: any) {
  this.employee.eid = data.eid;
  this.employee.ename = data.ename;
  this.employee.esalary = data.esalary;
  this.employee.dno = data.dno;

  this.employeeService.updateEmployee(this.employee).subscribe({
    next: (response: any) => {
      this.result = response;
    },
    error: (error) => {
      this.result = error.error;
    }
  });
}

deleteEmployee(data: any) {

  this.employeeService.deleteEmployee(data.eid).subscribe({
    next: (response: any) => {
      this.result = response;
    },
    error: (error) => {
      this.result = error.error;
    }
  });
}
}