import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpportunityFormDialogComponent } from './opportunity-form-dialog.component';

describe('OpportunityFormDialogComponent', () => {
  let component: OpportunityFormDialogComponent;
  let fixture: ComponentFixture<OpportunityFormDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpportunityFormDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OpportunityFormDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
