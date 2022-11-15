import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, UntypedFormGroup } from '@angular/forms';
import { UserService } from '../service/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-user-register-form',
  templateUrl: './user-register-form.component.html',
  styleUrls: ['./user-register-form.component.scss']
})
export class UserRegisterFormComponent implements OnInit {

  form: UntypedFormGroup;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private service: UserService,
    private snackBar: MatSnackBar
  ) {
  this.form = this.formBuilder.group({
    name: [''],
    lastName: [''],
    password: [''],
    confPassword: [''],
    email: [''],
    phone: ['']
  });
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

  onRegister() {
    this.service.save(this.form.value)
      .subscribe({
          next: _ => this.onSuccess(),
          error: _ => this.onError()
    });
  }

  onCancel(): void {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Usuário cadastrado!', '', { duration: 5000 });
    //TODO: redirecionar para perfil de usuário.
  }

  private onError() {
    this.snackBar.open('Erro ao tentar cadastrar.', '', { duration: 5000 });
  }
}
