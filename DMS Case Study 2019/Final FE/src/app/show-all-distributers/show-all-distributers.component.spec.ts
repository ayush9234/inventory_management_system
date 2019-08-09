import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllDistributersComponent } from './show-all-distributers.component';

describe('ShowAllDistributersComponent', () => {
  let component: ShowAllDistributersComponent;
  let fixture: ComponentFixture<ShowAllDistributersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllDistributersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllDistributersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
