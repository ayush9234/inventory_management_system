import { TestBed } from '@angular/core/testing';

import { GetRetailerlistService } from './get-retailerlist.service';

describe('GetRetailerlistService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetRetailerlistService = TestBed.get(GetRetailerlistService);
    expect(service).toBeTruthy();
  });
});
