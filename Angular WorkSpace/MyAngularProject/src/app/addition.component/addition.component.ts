import { Component } from '@angular/core';
import { CalculatorService } from '../calculator.service';

@Component({
  selector: 'app-addition-component',
  standalone: false,
  templateUrl: './addition.component.html',
  styleUrl: './addition.component.css',
})
export class AdditionComponent {
  num1: number = 0;
  num2: number = 0;
  result: number = 0;

  constructor(private calculatorService: CalculatorService) {}

  getAddition() {
    this.result = this.calculatorService.add(this.num1, this.num2);
  }

}
