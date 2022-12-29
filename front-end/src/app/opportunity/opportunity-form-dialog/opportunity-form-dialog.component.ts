import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { OpportunityService } from '../service/opportunity.service';


@Component({
  selector: 'app-opportunity-form-dialog',
  templateUrl: './opportunity-form-dialog.component.html',
  styleUrls: ['./opportunity-form-dialog.component.scss']
})
export class OpportunityFormDialogComponent implements OnInit {
  minDate?: Date | null = null;
  maxDate?: Date | null = null;

  form = this.formBuilder.group({
    titulo: ['', [Validators.required]],
    descricao: ['', [
      Validators.required,
      Validators.maxLength(500)
    ]],
    // dataCriacao: ['', [Validators.required]], //TODO ver melhor forma de usar campo
    endereco: ['', [Validators.required]],
    telefone: ['', [
      Validators.pattern('^[0-9]*$'),
      Validators.minLength(10),
      Validators.maxLength(11)
    ]],
    valor: ['', [
      Validators.pattern('^([0-9]{1,3}(\.[0-9]{3})*|[0-9]+)(\,[0-9]{2})?$'),
      Validators.maxLength(9)
    ]],
    validade: ['', Validators.required],
    categoria: ['']
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location,
    private snackBar: MatSnackBar,
    private dialogRef: MatDialogRef<OpportunityFormDialogComponent>,
    private service: OpportunityService,
  ) { }

  ngOnInit(): void {
    const currentYear = new Date().getFullYear();

    this.minDate = new Date(currentYear - 10, 0, 1); // 10 anos antes o atual, 01 de Janeiro.
    this.maxDate = new Date(currentYear + 10, 11, 31); // 10 anos após o atual, 31 de Dezembro.
  }

  onRegister() {
    if (this.form.invalid) {
      this.snackBar.open('Dados inválidos!', 'Ok');
      return;
    }

    this.service.register(this.form.value).subscribe({
      next: (opp) => {
        console.log(opp)
        this.onSuccess();
        this.dialogRef.close();
      },
      error: (err) => {
        console.log(err);
        this.onError();
      }
    })
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  private onSuccess() {
    this.snackBar.open('Oportunidade cadastrada!', 'Ok', { duration: 5000 });
  }

  private onError() {
    this.snackBar.open('Erro ao tentar cadastrar.', 'Ok', { duration: 5000 });
  }
}
