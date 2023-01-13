import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { OpportunityFormDialogComponent } from '../opportunity-form-dialog/opportunity-form-dialog.component';
import { TokenService } from '../../user/service/token.service';

@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.scss']
})
export class OpportunityComponent implements OnInit {

  isLogged: boolean = false;

  constructor(
    public dialog: MatDialog,
    public location: Location,
    private tokenService: TokenService
  ) { }

  ngOnInit(): void {
    this.tokenService.isLogged.subscribe(log => {
      this.isLogged = log;
    })
    this.tokenService.checkIsLogged();
  }

  addOpportunity() {
    const dialogRef = this.dialog.open(OpportunityFormDialogComponent, {
      minWidth: '500px',
      maxHeight: '1000px'
    });

    dialogRef.afterClosed().subscribe({
      next: (_) => {
        // window.location.reload();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

}
