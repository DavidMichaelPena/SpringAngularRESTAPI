import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SodaListComponent } from './soda-list.component';

describe('SodaListComponent', () => {
  let component: SodaListComponent;
  let fixture: ComponentFixture<SodaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SodaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SodaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
