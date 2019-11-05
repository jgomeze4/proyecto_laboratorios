import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarInsComponent } from './listar-ins.component';

describe('ListarInsComponent', () => {
  let component: ListarInsComponent;
  let fixture: ComponentFixture<ListarInsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarInsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
