import { TestBed } from '@angular/core/testing';

import { ProfessorserviceService } from './professorservice.service';

describe('ProfessorserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProfessorserviceService = TestBed.get(ProfessorserviceService);
    expect(service).toBeTruthy();
  });
});
