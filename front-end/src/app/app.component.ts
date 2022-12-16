import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title: string = 'front-end';
  isMenuOpen: boolean = false;

  onSidenavClick(): void {
    this.isMenuOpen = false;
  }
}
