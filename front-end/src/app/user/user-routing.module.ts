import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginFormComponent } from './user-login-form/user-login-form.component';
import { UserRegisterFormComponent } from './user-register-form/user-register-form.component';

const routes: Routes = [
  { path: '', component: UserLoginFormComponent },
  { path: 'register', component: UserRegisterFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
