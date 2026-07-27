import { Component } from '@angular/core';

@Component({
  selector: 'app-product',
  standalone: false,
  templateUrl: './product.html',
  styleUrl: './product.css'
})
export class Product {

  productName: string = "Dell Inspiron 15";
  price: number = 65999;
  category: string = "Laptop";
  brand: string = "Dell";
  availability: string = "In Stock";

  imagePath: string = "1.jpg";

}