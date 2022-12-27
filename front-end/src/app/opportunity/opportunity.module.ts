import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OpportunityRoutingModule } from './opportunity-routing.module';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { OpportunityComponent } from './opportunity/opportunity.component';
import { OpportunityFormDialogComponent } from './opportunity-form-dialog/opportunity-form-dialog.component';

@NgModule({
  declarations: [OpportunityComponent, OpportunityFormDialogComponent],
  imports: [
    CommonModule,
    OpportunityRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule,
  ],
})
export class OpportunityModule {}
