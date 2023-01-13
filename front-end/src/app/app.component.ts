import { User } from './user/model/user';
import { Observable } from 'rxjs';
import { UserService } from './user/service/user.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title: string = 'front-end';
  isMenuOpen: boolean = false;
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

  constructor(userService: UserService){
    this.user$ = userService.getUser();


    this.user$.subscribe(user => {

    console.log("Teste")
    console.log(this.user)
      this.user = user})
  }
}
