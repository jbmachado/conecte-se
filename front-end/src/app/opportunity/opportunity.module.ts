import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OpportunityRoutingModule } from './opportunity-routing.module';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { OpportunityComponent } from './opportunity/opportunity.component';

@NgModule({
  declarations: [OpportunityFormComponent, OpportunityComponent],
  imports: [
    CommonModule,
    OpportunityRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule,
  ],
})
export class OpportunityModule {}
