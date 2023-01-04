import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from '../service/auth.service';

import { UserService } from '../service/user.service';
import Validation from './util/validation';

@Component({
  selector: 'app-user-register-form',
  templateUrl: './user-register-form.component.html',
  styleUrls: ['./user-register-form.component.scss'],
})
export class UserRegisterFormComponent implements OnInit {
  form: UntypedFormGroup;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) {
    this.form = this.formBuilder.group(
      {
        mail: [
          '',
          [Validators.required, Validators.maxLength(100), Validators.email],
        ],
        telefone: [
          '',
          [
            Validators.required,
            Validators.pattern('^[0-9]*$'),
            Validators.minLength(10),
            Validators.maxLength(11),
          ],
        ],
        nome: ['', [Validators.required, Validators.maxLength(100)]],
        sobrenome: ['', [Validators.required, Validators.maxLength(100)]],
        senha: ['', [Validators.required, Validators.maxLength(100)]],
        confSenha: ['', [Validators.required, Validators.maxLength(100)]],
      },
      {
        validators: [Validation.match('senha', 'confSenha')],
      }
    );
  }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onSubmit() {
    if (this.form.invalid) {
      this.snackBar.open('Dados inválidos!', 'Ok');
      return;
    }

    this.authService.register(this.form.value).subscribe({
      next: (user) => {
        console.log(user);
        this.onSuccess();
        // TODO redirecionar para perfil de usuário.
      },
      error: (err) => {
        console.log(err);
        this.onError();
      }
    });
  }

  onCancel(): void {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Usuário cadastrado!', 'Ok', { duration: 5000 });
  }

  private onError() {
    this.snackBar.open('Erro ao tentar cadastrar.', 'Ok', { duration: 5000 });
  }
}
