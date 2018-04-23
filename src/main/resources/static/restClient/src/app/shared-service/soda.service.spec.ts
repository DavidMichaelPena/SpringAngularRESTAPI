import { TestBed, inject } from '@angular/core/testing';

import { SodaService } from './soda.service';

describe('SodaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SodaService]
    });
  });

  it('should be created', inject([SodaService], (service: SodaService) => {
    expect(service).toBeTruthy();
  }));
});
