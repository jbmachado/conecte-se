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
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.scss'],
})
export class OpportunityComponent implements OnInit {
  isLogged: boolean = false;
  opps$: Observable<Opportunity[]> | null = null;
  oppUser: Opportunity[] = [];
  user: User = {
    id: 0,
    senha: '',
    mail: '',
    telefone: '',
    nome: '',
    sobrenome: '',
  };

  constructor(
    public dialog: MatDialog,
    public location: Location,
    private tokenService: TokenService,
    private oppService: OpportunityService,
    private snackBar: MatSnackBar,
    private UserService: UserService
  ) {
    this.UserService.getUser().subscribe((data) => (this.user = data));
    console.log(this.user);
  }

  ngOnInit(): void {
    this.tokenService.isLogged.subscribe((log) => {
      this.isLogged = log;
    });
    this.tokenService.checkIsLogged();

    this.oppLoad();
  }

  addOpportunity() {
    const dialogRef = this.dialog.open(OpportunityFormDialogComponent, {
      minWidth: '500px',
      maxHeight: '1000px',
    });

    dialogRef.afterClosed().subscribe({
      next: (_) => {
        this.oppLoad();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  linkOportunityUser(idOpp: number) {
    this.oppService.linkOpp(idOpp).subscribe({
      next: (res) => {
        console.log(res);
        this.onSuccess();
      },
      error: (err) => {
        console.log(err);
        this.onError();
      },
    });
  }

  isOppCreatorIsLoggedUser(opp: Opportunity): boolean {
    return opp.criador?.id != this.user.id;
  }

  isAccepted(opp: Opportunity): boolean {
    // this.user.oportunidadeAceitas?.indexOf()
    return false;
  }

  private oppLoad(): void {
    this.oppUser = [];

    this.opps$ = this.oppService.findAll().pipe(
      catchError((err) => {
        console.log('Erro ao carregar oportunidades. \n' + err);
        return of([]);
      })
    );

    this.opps$.subscribe({
      next: (data) => {
        data.forEach((opp) => {
          if (opp.criador!.id == this.user.id) this.oppUser?.push(opp);
        });
      },
    });
  }

  private onSuccess() {
    this.snackBar.open('Vínculo criado!', 'Ok', { duration: 5000 });
  }

  private onError() {
    this.snackBar.open('Erro ao tentar vincular.', 'Ok', { duration: 5000 });
  }
}
