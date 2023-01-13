import { Injectable } from '@angular/core';
import { ReplaySubject } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private readonly TOKEN_KEY = 'auth-token';
  private readonly USER_KEY = 'auth-user';

  private logged = new ReplaySubject<boolean>(1);
  public isLogged = this.logged.asObservable();

  constructor() { }

  logout(): void {
    window.sessionStorage.clear();
  }

  saveToken(token: string): void {
    window.sessionStorage.removeItem(this.TOKEN_KEY);
    window.sessionStorage.setItem(this.TOKEN_KEY, token);
  }

  getToken(): string | null {
    return window.sessionStorage.getItem(this.TOKEN_KEY);
  }

  saveUser(user: User): void {
    window.sessionStorage.removeItem(this.USER_KEY);
    window.sessionStorage.setItem(this.USER_KEY, JSON.stringify(user));
  }

  getUser(): User | null {
    const user = window.sessionStorage.getItem(this.USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return null;
  }

  checkIsLogged() {
    if (this.getToken()) {
      this.logged.next(true);
      return;
    }

    this.logged.next(false);
  }
}
