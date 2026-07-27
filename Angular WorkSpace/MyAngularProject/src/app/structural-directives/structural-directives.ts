import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directives',
  standalone: false,
  templateUrl: './structural-directives.html',
  styleUrl: './structural-directives.css',
})
export class StructuralDirectives {
  myDivStyle : string;
  myButtonStyle : {};
  message : String;
  flag : boolean;
  vehicles : string[];
  selectedVehicle : string;

  constructor() {
    this.myDivStyle = 'MyDiv';
    this.myButtonStyle = {backgroundColor: 'blue', color: 'white', fontStyle: 'italic', borderRadius: '10px'};
    this.message = "Angular Structural Directives";
    this.flag = true;
    this.vehicles = ['Car', 'Bike', 'Bus', 'Truck'];
    this.selectedVehicle = '';
  }

  showHideDiv() {
    this.flag = !this.flag;
  }

  setSelectedVehicle(vehicle: string) {
    this.selectedVehicle = vehicle;
  }
  
}
