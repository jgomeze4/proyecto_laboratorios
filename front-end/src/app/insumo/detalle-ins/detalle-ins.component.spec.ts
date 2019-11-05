import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleInsComponent } from './detalle-ins.component';

describe('DetalleInsComponent', () => {
  let component: DetalleInsComponent;
  let fixture: ComponentFixture<DetalleInsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleInsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
