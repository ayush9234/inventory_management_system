import { TestBed } from '@angular/core/testing';

import { AddNewDistributerService } from './add-new-distributer.service';

describe('AddNewDistributerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddNewDistributerService = TestBed.get(AddNewDistributerService);
    expect(service).toBeTruthy();
  });
});
