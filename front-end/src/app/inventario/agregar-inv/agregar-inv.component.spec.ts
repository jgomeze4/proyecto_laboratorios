import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarInvComponent } from './agregar-inv.component';

describe('AgregarInvComponent', () => {
  let component: AgregarInvComponent;
  let fixture: ComponentFixture<AgregarInvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgregarInvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarInvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
