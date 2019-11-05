import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarInsComponent } from './agregar-ins.component';

describe('AgregarInsComponent', () => {
  let component: AgregarInsComponent;
  let fixture: ComponentFixture<AgregarInsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgregarInsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
