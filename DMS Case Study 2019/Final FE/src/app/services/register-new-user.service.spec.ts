import { TestBed } from '@angular/core/testing';

import { RegisterNewUserService } from './register-new-user.service';

describe('RegisterNewUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegisterNewUserService = TestBed.get(RegisterNewUserService);
    expect(service).toBeTruthy();
  });
});
