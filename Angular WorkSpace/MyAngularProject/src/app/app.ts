import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  name: string;
  age: number;
  email: string;
  height: number;
  myStyle: {};
  myClass: string;
  fname: string;
  constructor() {
    this.name = "Tagore";
    this.age = 20;
    this.email = "tagore@gmail.com";
    this.height = 200;
    this.myStyle = { 'color': 'purple', 'font-size': '40px' };
    this.myClass = "ZoomIn";
    this.fname = "";
  }
  getAddition(a: number, b: number): number {
    return a + b;
  }
  imagePath: string = "1.jpg";
  changename(){
    if(this.name == "Tagore"){
    this.name = "Tagore Sri Sai";
  }else{
    this.name = "Tagore";
  }
  
}
zoomInOut() {
  if (this.myClass == "ZoomIn") {
    this.myClass = "ZoomOut";
  } else {
    this.myClass = "ZoomIn";
  }
}
}