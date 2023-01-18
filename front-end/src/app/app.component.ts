import { User } from './user/model/user';
import { Observable } from 'rxjs';
import { UserService } from './user/service/user.service';
import { Component, OnInit } from '@angular/core';
import { TokenService } from './user/service/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title: string = 'front-end';
  isMenuOpen: boolean = false;
  isLogged: boolean = false;
  user: User = {id: 0,
    senha: "",
    mail: "",
    telefone: "",
    nome: "",
    sobrenome: ""};
  user$: Observable<User>;
  nomeLogado: String | undefined = ""

  onSidenavClick(): void {
    this.isMenuOpen = false;
  }

  constructor(
    userService: UserService,
    private tokenService: TokenService,
    private router: Router
    ){
    this.user$ = userService.getUser();

    console.log(this.user$)

    this.user$.subscribe(user => {
      this.user = user})
  }

  ngOnInit(): void {
    this.tokenService.isLogged.subscribe(log => {
      this.isLogged = log;
    })
    this.tokenService.checkIsLogged();
  }

  logout() {
    this.tokenService.logout();
<<<<<<< HEAD
    window.location.reload();
=======
>>>>>>> 1447f3b8c59ece65a9159851c8070bcd2d275b05
    this.router.navigate(['/']);
  }
}
