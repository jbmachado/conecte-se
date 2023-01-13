import { Component, OnInit } from '@angular/core';
import {
  NonNullableFormBuilder,
  UntypedFormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-user-login-form',
  templateUrl: './user-login-form.component.html',
  styleUrls: ['./user-login-form.component.scss'],
})
export class UserLoginFormComponent implements OnInit {
  form: UntypedFormGroup;
  isLoggedIn = false;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private token: TokenService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.maxLength(100)]],
    });
  }

  ngOnInit(): void {
    if (this.token.getToken()) {
      //Usuário está logado!!!
      this.isLoggedIn = true;
      //TODO redirecionar para perfil do usuário.
    }
  }

  login(){
    const login = this.form.get("mail")?.value;
    const senha = this.form.get("senha")?.value;

    this.authService.authenticate(login, senha).subscribe(
      () => this.router.navigateByUrl("/"),
        err => {
          console.log(err);
          this.form.reset();
        }
    );
  }

  onRegister() {
    this.router.navigate(['register'], { relativeTo: this.route });
  }
}
