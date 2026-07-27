import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyChild } from './my-child';

describe('MyChild', () => {
  let component: MyChild;
  let fixture: ComponentFixture<MyChild>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyChild],
    }).compileComponents();

    fixture = TestBed.createComponent(MyChild);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
