import { Injectable } from '@angular/core';
import { Observable, first } from 'rxjs';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http';
import { Token } from '../model/token';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private readonly API: string = '/api';

  constructor(private http: HttpClient) { }

  login(user: Partial<User>): Observable<Token> {
    return this.http.post<Token>(this.API + '/auth', user)
      .pipe(first());
  }

  register(user: Partial<User>): Observable<User> {
    return this.http.post<User>(this.API + '/usuario/salvar', user)
      .pipe(first());
  }
}
