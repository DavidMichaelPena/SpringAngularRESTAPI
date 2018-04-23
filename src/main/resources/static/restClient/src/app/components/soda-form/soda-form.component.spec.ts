import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SodaFormComponent } from './soda-form.component';

describe('SodaFormComponent', () => {
  let component: SodaFormComponent;
  let fixture: ComponentFixture<SodaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SodaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SodaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
