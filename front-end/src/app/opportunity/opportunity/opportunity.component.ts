import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { OpportunityFormDialogComponent } from '../opportunity-form-dialog/opportunity-form-dialog.component';

@Component({
  selector: 'app-opportunity',
  templateUrl: './opportunity.component.html',
  styleUrls: ['./opportunity.component.scss']
})
export class OpportunityComponent implements OnInit {

  constructor(
    public dialog: MatDialog,
    public location: Location
  ) { }

  ngOnInit(): void {
  }

  addOpportunity() {
    const dialogRef = this.dialog.open(OpportunityFormDialogComponent, {
      minWidth: '450px',
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
