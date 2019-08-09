import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowMyUsersComponent } from './show-my-users.component';

describe('ShowMyUsersComponent', () => {
  let component: ShowMyUsersComponent;
  let fixture: ComponentFixture<ShowMyUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowMyUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowMyUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
