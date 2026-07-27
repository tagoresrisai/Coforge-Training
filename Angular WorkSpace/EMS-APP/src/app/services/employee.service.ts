import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  emsUrl: string = '/api/v1/ems';
  constructor(private http: HttpClient) { }

    insertEmployee(employee: Employee) {
  return this.http.post(this.emsUrl + "/employees", employee, {
    responseType: 'text'
  });
}
updateEmployee(employee: Employee) {
  return this.http.put(
    this.emsUrl + "/employees/" + employee.eid,
    employee,
    { responseType: 'text' }
  );
}

deleteEmployee(eid: number) {
  return this.http.delete(
    this.emsUrl + "/employees/" + eid,
    { responseType: 'text' }
  );
}
}
