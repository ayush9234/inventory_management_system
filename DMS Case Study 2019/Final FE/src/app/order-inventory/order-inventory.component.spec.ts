import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderInventoryComponent } from './order-inventory.component';

describe('OrderInventoryComponent', () => {
  let component: OrderInventoryComponent;
  let fixture: ComponentFixture<OrderInventoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderInventoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
