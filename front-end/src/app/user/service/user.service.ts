import { Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';
import { BehaviorSubject } from 'rxjs';
import { Token } from '../model/token';
import { User } from '../model/user';
import { TokenService } from './token.service';

//TODO TOKEN - import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root',
})
export class UserService {
  user: User = {id: 0,
    senha: "",
    mail: "",
    telefone: "",
    nome: "",
    sobrenome: ""};

  private userSubject = new BehaviorSubject<User>(this.user);

  constructor(private tokenService: TokenService){
    this.tokenService.hasToken() && this.decodeAndNotify();

  }

  setToken(token: string){
    this.tokenService.saveToken(token);
    this.decodeAndNotify();
  }

  getUser(){
    return this.userSubject.asObservable();
  }

  private decodeAndNotify(){
    const token = this.tokenService.getToken();

    if(token){
      const tokenJson = jwtDecode(token) as Token;
      this.userSubject.next(tokenJson.user);
    }
  }

}
