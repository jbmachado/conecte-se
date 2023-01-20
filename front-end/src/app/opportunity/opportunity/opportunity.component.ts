import { User } from './../../user/model/user';
import { UserService } from './../../user/service/user.service';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { OpportunityFormDialogComponent } from '../opportunity-form-dialog/opportunity-form-dialog.component';
import { TokenService } from '../../user/service/token.service';
import { catchError, Observable, of } from 'rxjs';
import { Opportunity } from '../model/opportunity';
import { OpportunityService } from '../service/opportunity.service';
@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.scss']
})
export class OpportunityComponent implements OnInit {
  isLogged: boolean = false;
  opps$: Observable<Opportunity[]> | null = null;
  user: User = {id: 0,
    senha: "",
    mail: "",
    telefone: "",
    nome: "",
    sobrenome: ""};

  constructor(
    public dialog: MatDialog,
    public location: Location,
    private tokenService: TokenService,
    private oppService: OpportunityService,
    private UserService: UserService
  ) {
    this.UserService.getUser().subscribe(
      (data) => this.user = data
    );
  }

  ngOnInit(): void {
    this.tokenService.isLogged.subscribe(log => {
      this.isLogged = log;
    })
    this.tokenService.checkIsLogged();

    this.oppLoad();
  }

  addOpportunity() {
    const dialogRef = this.dialog.open(OpportunityFormDialogComponent, {
      minWidth: '500px',
      maxHeight: '1000px'
    });

    dialogRef.afterClosed().subscribe({
      next: (_) => {
        this.oppLoad();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  private oppLoad(): void {
    this.opps$ = this.oppService.findAll()
      .pipe(
        catchError(err => {
          console.log('Erro ao carregar oportunidades. \n' + err);
          return of([]);
        })
      )
  }

  public oppIsOpen(opp: Opportunity, user: User): boolean {
    // PROBLEMA
    return this.oppService.podeAceitarOportunidade(opp, user);
  }
}
