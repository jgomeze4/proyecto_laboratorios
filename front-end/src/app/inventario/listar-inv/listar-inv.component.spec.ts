import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarInvComponent } from './listar-inv.component';

describe('ListarInvComponent', () => {
  let component: ListarInvComponent;
  let fixture: ComponentFixture<ListarInvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarInvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarInvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
