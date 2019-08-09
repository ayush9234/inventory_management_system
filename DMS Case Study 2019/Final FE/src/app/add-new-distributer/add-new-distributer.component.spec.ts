import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewDistributerComponent } from './add-new-distributer.component';

describe('AddNewDistributerComponent', () => {
  let component: AddNewDistributerComponent;
  let fixture: ComponentFixture<AddNewDistributerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewDistributerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewDistributerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
