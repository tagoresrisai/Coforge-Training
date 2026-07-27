import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-component',
  standalone: false,
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {
  result: string = "";

  saveEmployee(data: any) {
    this.result = "Employee Saved Successfully with ID: " + data.eid + ", Name: " + data.ename + ", Salary: " + data.esalary + ", Dno: "+ data.dno;
  }
}
