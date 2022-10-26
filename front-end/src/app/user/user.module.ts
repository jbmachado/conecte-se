import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { UserLoginFormComponent } from './user-login-form/user-login-form.component';
import { UserRegisterFormComponent } from './user-register-form/user-register-form.component';
import { UserRoutingModule } from './user-routing.module';


@NgModule({
  declarations: [
    UserLoginFormComponent,
    UserRegisterFormComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class UserModule { }
