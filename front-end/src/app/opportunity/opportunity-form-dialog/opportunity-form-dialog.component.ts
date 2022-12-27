import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-opportunity-form-dialog',
  templateUrl: './opportunity-form-dialog.component.html',
  styleUrls: ['./opportunity-form-dialog.component.scss']
})
export class OpportunityFormDialogComponent implements OnInit {

  form = this.formBuilder.group({
    title: ['', [Validators.required]],
    description: ['', [
      Validators.required,
      Validators.maxLength(256)
    ]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<OpportunityFormDialogComponent>,
  ) { }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

  onRegister() {
    if (this.form.invalid) {
      this.snackBar.open('Dados inválidos!', 'Ok');
      return;
    }
    //TODO cadastro opp
  }

  onCancel(): void {
    this.dialogRef.close();
  }
}
