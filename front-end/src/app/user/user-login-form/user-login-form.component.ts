import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-login-form',
  templateUrl: './user-login-form.component.html',
  styleUrls: ['./user-login-form.component.scss'],
})
export class UserLoginFormComponent implements OnInit {
  form = this.formBuilder.group({
    userEmail: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.maxLength(100)]],
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty
  }

  onLogin() {
    //TODO verificar login
  }

  onRegister() {
    this.router.navigate(['register'], { relativeTo: this.route });
  }
}
