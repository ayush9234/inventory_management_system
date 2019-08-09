import { TestBed } from '@angular/core/testing';

import { GetAllDistributersService } from './get-all-distributers.service';

describe('GetAllDistributersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetAllDistributersService = TestBed.get(GetAllDistributersService);
    expect(service).toBeTruthy();
  });
});
