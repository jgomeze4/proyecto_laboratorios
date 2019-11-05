import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarInsComponent } from './editar-ins.component';

describe('EditarInsComponent', () => {
  let component: EditarInsComponent;
  let fixture: ComponentFixture<EditarInsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarInsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
