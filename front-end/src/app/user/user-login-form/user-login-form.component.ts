import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-login-form',
  templateUrl: './user-login-form.component.html',
  styleUrls: ['./user-login-form.component.scss'],
})
export class UserLoginFormComponent implements OnInit {
  form: UntypedFormGroup;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.maxLength(100)]],
  });
}

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onLogin() {
    //TODO login
  }

  onRegister() {
    this.router.navigate(['register'], { relativeTo: this.route });
  }
}
