import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';

const routes: Routes = [
  { path: '', component: OpportunityFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OpportunityRoutingModule { }
