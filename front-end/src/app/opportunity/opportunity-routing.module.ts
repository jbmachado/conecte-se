import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OpportunityFormComponent } from './opportunity-form/opportunity-form.component';
import { OpportunityComponent } from './opportunity/opportunity.component';

const routes: Routes = [
  { path: '', component: OpportunityComponent },
  { path: 'register', component: OpportunityFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class OpportunityRoutingModule {}
