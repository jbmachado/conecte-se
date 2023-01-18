import { Injectable } from '@angular/core';
import { Opportunity } from '../model/opportunity';
import { Observable, first, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TokenService } from '../../user/service/token.service';

@Injectable({
  providedIn: 'root',
})
export class OpportunityService {
  private readonly API = '/api';

  constructor(private http: HttpClient, private tokenService: TokenService) {
    /* TODO document why this constructor is empty */
  }

  findAll(): Observable<Opportunity[]> {
    return this.http.get<Opportunity[]>(this.API + '/oportunidade/buscar')
      .pipe(
        first(),
        tap(opps => console.log(opps))
        );
  }

  register(opp: Partial<Opportunity>): Observable<Opportunity> {
    opp.criador = this.tokenService.getUser();

    return this.http
      .post<Opportunity>(this.API + '/oportunidade/salvar', opp)
      .pipe(first());
  }
}
