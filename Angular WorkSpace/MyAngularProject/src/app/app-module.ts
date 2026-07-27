import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { MyChild } from './my-child/my-child';
import { MySecondChild } from './my-second-child/my-second-child';
import { FormsModule } from '@angular/forms';
import { Employee } from './employee/employee';
import { Student } from './student/student';
import { Product } from './product/product';
import { Company } from './company/company';
import { EventRegistration } from './event-registration/event-registration';
import { Counter } from './counter/counter';
import { StructuralDirectives } from './structural-directives/structural-directives';
import { CalculatorService } from './calculator.service';
import { AdditionComponent } from './addition.component/addition.component';
import { EmployeeComponent } from './employee-component/employee-component';
import { Home } from './home/home';
import { About } from './about/about';
import { Contact } from './contact/contact';

@NgModule({
  declarations: [
    App,
    MyChild,
    MySecondChild,
    Employee,
    Student,
    Product,
    Company,
    EventRegistration,
    Counter,
    StructuralDirectives,
    AdditionComponent,
    EmployeeComponent,
    Home,
    About,
    Contact,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners(), CalculatorService],
  bootstrap: [App],
})
export class AppModule {}
