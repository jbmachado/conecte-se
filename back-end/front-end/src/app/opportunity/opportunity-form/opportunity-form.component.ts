import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';

@Component({
  selector: 'app-opportunity-form',
  templateUrl: './opportunity-form.component.html',
  styleUrls: ['./opportunity-form.component.scss']
})
export class OpportunityFormComponent implements OnInit {

  form = this.formBuilder.group({
    title: [''],
    description: ['']
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private location: Location
  ) { }

  ngOnInit(): void {
    // TODO document why this method 'ngOnInit' is empty

  }

  onRegister() {
    //TODO cadastro opp
  }

  onCancel(): void {
    this.location.back();
  }
}
