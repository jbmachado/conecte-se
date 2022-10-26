import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-register-form',
  templateUrl: './user-register-form.component.html',
  styleUrls: ['./user-register-form.component.scss']
})
export class UserRegisterFormComponent implements OnInit {

  form = this.formBuilder.group({
    name: [''],
    lastName: [''],
    password: [''],
    confPassword: [''],
    email: [''],
    phone: ['']
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private service: UserService
  ) { }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

  onRegister() {
    // TODO cadastrar usuário
  }

  onCancel(): void {
    this.location.back();
  }

}
