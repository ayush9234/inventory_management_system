import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewRetailerComponent } from './add-new-retailer.component';

describe('AddNewRetailerComponent', () => {
  let component: AddNewRetailerComponent;
  let fixture: ComponentFixture<AddNewRetailerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewRetailerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewRetailerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
