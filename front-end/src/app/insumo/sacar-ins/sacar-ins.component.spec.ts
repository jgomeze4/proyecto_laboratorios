import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SacarInsComponent } from './sacar-ins.component';

describe('SacarInsComponent', () => {
  let component: SacarInsComponent;
  let fixture: ComponentFixture<SacarInsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SacarInsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SacarInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
