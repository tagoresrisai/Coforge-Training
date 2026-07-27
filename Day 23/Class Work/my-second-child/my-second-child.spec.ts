import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySecondChild } from './my-second-child';

describe('MySecondChild', () => {
  let component: MySecondChild;
  let fixture: ComponentFixture<MySecondChild>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MySecondChild],
    }).compileComponents();

    fixture = TestBed.createComponent(MySecondChild);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
