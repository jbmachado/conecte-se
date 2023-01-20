import { User } from './../../user/model/user';
import { UserService } from './../../user/service/user.service';
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

  constructor(
    private http: HttpClient,
    private tokenService: TokenService,
    private userService: UserService) {
    /* TODO document why this constructor is empty */
  }

  findAll(): Observable<Opportunity[]> {
    return this.http.get<Opportunity[]>(this.API + '/oportunidade/buscar')
      .pipe(
        first(),
        tap(opps => console.log(opps))
        );
  }

  podeAceitarOportunidade(opp: Opportunity, user: User | null): boolean {
    // TODO checar se usuario ja aceitou a oportunidade!!!!!

    if (user === null) return false;

    return opp.criador!.id != user!.id;
  }

  register(opp: Partial<Opportunity>): Observable<Opportunity> {
    this.userService.getUser().subscribe(
      (data) => opp.criador = data
    );

    console.log(opp.criador);

    return this.http
      .post<Opportunity>(this.API + '/oportunidade/salvar', opp)
      .pipe(first());
  }
}
