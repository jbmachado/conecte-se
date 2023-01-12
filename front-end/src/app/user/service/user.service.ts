import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable } from 'rxjs';
import { User } from '../model/user';

//TODO TOKEN - import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly API: string = '/api';

  constructor(private httpClient: HttpClient) {}

  //TODO admin

  //TODO moderador

  //TODO usuário comum
}
