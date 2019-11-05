import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleUsComponent } from './detalle-us.component';

describe('DetalleUsComponent', () => {
  let component: DetalleUsComponent;
  let fixture: ComponentFixture<DetalleUsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleUsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleUsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
