import { Injectable } from '@angular/core';
import { Opportunity } from '../model/opportunity';
import { Observable, first } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OpportunityService {
  private readonly API: string = '';
  private readonly httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'applications/json' })
  };

  constructor(private http: HttpClient) { /* TODO document why this constructor is empty */  }

  register(opp: Partial<Opportunity>): Observable<Opportunity> {
    return this.http.post<Opportunity>(this.API + 'oportunidade/salvar', opp)
      .pipe(first());
  }
}
