import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventRegistration } from './event-registration';

describe('EventRegistration', () => {
  let component: EventRegistration;
  let fixture: ComponentFixture<EventRegistration>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventRegistration],
    }).compileComponents();

    fixture = TestBed.createComponent(EventRegistration);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
