import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPendingOrdersComponent } from './my-pending-orders.component';

describe('MyPendingOrdersComponent', () => {
  let component: MyPendingOrdersComponent;
  let fixture: ComponentFixture<MyPendingOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyPendingOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPendingOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
