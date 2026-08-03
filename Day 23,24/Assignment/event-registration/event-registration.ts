import { Component } from '@angular/core';

@Component({
  selector: 'app-event-registration',
  standalone: false,
  templateUrl: './event-registration.html',
  styleUrl: './event-registration.css'
})
export class EventRegistration {

  name: string = "";
  email: string = "";
  course: string = "";
  message: string = "";

  register() {
    this.message = "Registration Successful!";

    console.log("Name :", this.name);
    console.log("Email :", this.email);
    console.log("Course :", this.course);
  }

  reset() {
    this.name = "";
    this.email = "";
    this.course = "";
    this.message = "";
  }

}