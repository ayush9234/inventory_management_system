import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowRequestsComponent } from './show-requests.component';

describe('ShowRequestsComponent', () => {
  let component: ShowRequestsComponent;
  let fixture: ComponentFixture<ShowRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
