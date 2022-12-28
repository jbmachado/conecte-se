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
    titulo: ['', [Validators.required]],
    descricao: ['', [
      Validators.required,
      Validators.maxLength(256)
    ]],
    dataCriacao: ['', [Validators.required]],
    endereco: ['', [Validators.required]],
    telefone: ['', [
      Validators.pattern('^[0-9]*$'),
      Validators.minLength(10),
      Validators.maxLength(11)
    ]],
    valor: ['', [Validators.pattern('^([0-9]{1,3}(\.[0-9]{3})*|[0-9]+)(\,[0-9]{2})?$')]],
    validade: ['', Validators.required],
    categoria: ['']
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
