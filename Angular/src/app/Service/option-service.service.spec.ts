import { TestBed } from '@angular/core/testing';

import { OptionServiceService } from './option-service.service';

describe('OptionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OptionServiceService = TestBed.get(OptionServiceService);
    expect(service).toBeTruthy();
  });
});
