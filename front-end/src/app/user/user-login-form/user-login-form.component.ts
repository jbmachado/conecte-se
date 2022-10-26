import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-login-form',
  templateUrl: './user-login-form.component.html',
  styleUrls: ['./user-login-form.component.scss']
})
export class UserLoginFormComponent implements OnInit {

  form = this.formBuilder.group({
    userName: [''],
    password: ['']
  })

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

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
