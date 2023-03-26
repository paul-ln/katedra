import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CathedraleComponent } from './cathedrale.component';

describe('CathedraleComponent', () => {
  let component: CathedraleComponent;
  let fixture: ComponentFixture<CathedraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CathedraleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CathedraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
