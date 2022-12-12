import { Injectable } from '@angular/core';
import { Observable, first } from 'rxjs';
import { User } from '../model/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private readonly API: string = '';
  private readonly httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'applications/json' })
  };

  constructor(private http: HttpClient) { }

  login(user: Partial<User>): Observable<User> {
    return this.http.post<User>(this.API + 'auth', user, this.httpOptions)
      .pipe(first());
  }

  register(user: Partial<User>): Observable<User> {
    return this.http.post<User>(this.API + 'usuario/salvar', user, this.httpOptions)
      .pipe(first());
  }
}
