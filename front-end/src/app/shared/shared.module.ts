import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AppMaterialModule } from './app-material/app-material.module';
import { DateDdmmyyyyPipe } from './pipes/date-ddmmyyyy.pipe';

@NgModule({
  declarations: [
    DateDdmmyyyyPipe
  ],
  imports: [CommonModule, AppMaterialModule],
  exports: [
    DateDdmmyyyyPipe
  ],
})
export class SharedModule {}
