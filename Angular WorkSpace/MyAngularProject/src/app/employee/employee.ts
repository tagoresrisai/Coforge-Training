import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.html',
  styleUrl: './employee.css'
})
export class Employee {

  employeeId: number = 101;
  employeeName: string = "Rahul Sharma";
  department: string = "Development";
  salary: number = 65000;

}