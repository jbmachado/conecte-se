import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OpportunityRoutingModule } from './opportunity-routing.module';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    OpportunityFormComponent
  ],
  imports: [
    CommonModule,
    OpportunityRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class OpportunityModule { }
