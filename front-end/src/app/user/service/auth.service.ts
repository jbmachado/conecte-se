import { UserService } from './user.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { Token } from '../model/token';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private readonly API: string = '/api';

  constructor(private http: HttpClient, private userService: UserService
    ) { }



  authenticate(login: String, senha: String){
    return this.http
    .post(this.API + '/auth', {senha, login}, {observe: "response"})
    .pipe(tap(res => {
      const authToken = JSON.parse(JSON.stringify(res.body)).token;
      this.userService.setToken(authToken);
  }))
  }



  login(user: Partial<User>): Observable<Token> {
    return this.http.post<Token>(this.API + '/auth', user)
      .pipe(first());
  }

  register(user: Partial<User>): Observable<User> {
    return this.http.post<User>(this.API + '/usuario/salvar', user)
      .pipe(first());
  }
}
