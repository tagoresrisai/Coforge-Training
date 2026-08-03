import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  standalone: false,
  templateUrl: './student.html',
  styleUrl: './student.css'
})
export class Student {

  studentName: string = "Rahul Sharma";
  course: string = "B.Tech - Computer Science";
  college: string = "ABC Engineering College";

  imagePath: string = "1.jpg";

}