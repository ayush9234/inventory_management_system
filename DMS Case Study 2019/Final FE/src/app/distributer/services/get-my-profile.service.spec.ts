import { TestBed } from '@angular/core/testing';

import { GetMyProfileService } from './get-my-profile.service';

describe('GetMyProfileService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetMyProfileService = TestBed.get(GetMyProfileService);
    expect(service).toBeTruthy();
  });
});
