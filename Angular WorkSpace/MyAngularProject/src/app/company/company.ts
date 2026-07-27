import { Component } from '@angular/core';

@Component({
  selector: 'app-company',
  standalone: false,
  templateUrl: './company.html',
  styleUrl: './company.css'
})
export class Company {

  companyName: string = "Tech Solutions Pvt. Ltd.";
  ceo: string = "Satya Nadella";
  location: string = "Hyderabad";
  employeesCount: number = 2500;
  revenue: string = "₹150 Crores";

  logoPath: string = "1.jpg";

}