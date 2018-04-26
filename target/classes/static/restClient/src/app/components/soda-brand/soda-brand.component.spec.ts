import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SodaBrandComponent } from './soda-brand.component';

describe('SodaBrandComponent', () => {
  let component: SodaBrandComponent;
  let fixture: ComponentFixture<SodaBrandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SodaBrandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SodaBrandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
