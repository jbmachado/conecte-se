import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-register-form',
  templateUrl: './user-register-form.component.html',
  styleUrls: ['./user-register-form.component.scss'],
})
export class UserRegisterFormComponent implements OnInit {
  form: FormGroup;
  submitted: boolean = false;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private service: UserService,
    private snackBar: MatSnackBar
  ) {
    this.form = this.formBuilder.group({
      name: ['', [Validators.required, Validators.maxLength(100)]],
      lastName: ['', [Validators.required, Validators.maxLength(100)]],
      password: ['', [Validators.required, Validators.maxLength(100)]],
      confPassword: ['', [Validators.required, Validators.maxLength(100)]], //TODO: Criar validator para ver se as senhas são as mesmas
      email: [
        '',
        [Validators.required, Validators.maxLength(100), Validators.email],
      ],
      phone: ['', [Validators.required, Validators.pattern("^[0-9]*$"),
      Validators.minLength(10), Validators.maxLength(11)]], //TODO: Criar pattern
    });
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onSubmit() {
    this.submitted = true;

    if (this.form.invalid) {
      this.snackBar.open('Dados inválidos!', 'Ok');
      console.log('OI');
      return;
    }

    this.service.save(this.form.value).subscribe({
      next: (_) => this.onSuccess(),
      error: (_) => this.onError(),
    });
  }

  onCancel(): void {
    this.submitted = false;
    this.location.back();
  }

  onReset() {
    this.submitted = false;
    this.form.reset();
  }

  private onSuccess() {
    this.snackBar.open('Usuário cadastrado!', 'Ok', { duration: 5000 });
    //TODO: redirecionar para perfil de usuário.
  }

  private onError() {
    this.snackBar.open('Erro ao tentar cadastrar.', 'Ok', { duration: 5000 });
  }
}
