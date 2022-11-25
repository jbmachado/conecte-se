import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly API: string = 'usuario';

  constructor(private httpClient: HttpClient) {}

  // find(login: string): Observable<User> {
  //TODO: Busca usuário na API
  // }

  save(user: Partial<User>): Observable<User> {
    return this.httpClient.post<User>(this.API + '/salvar', user)
      .pipe(first());
  }
}
