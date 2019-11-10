import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalidaInvComponent } from './salida-inv.component';

describe('SalidaInvComponent', () => {
  let component: SalidaInvComponent;
  let fixture: ComponentFixture<SalidaInvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalidaInvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalidaInvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
