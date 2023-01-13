import { Component, OnInit } from '@angular/core';
import { TokenService } from './user/service/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title: string = 'front-end';
  isMenuOpen: boolean = false;
  isLogged: boolean = false;

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) {  }

  ngOnInit(): void {
    this.tokenService.isLogged.subscribe(log => {
      this.isLogged = log;
    })
    this.tokenService.checkIsLogged();
  }

  logout() {
    this.tokenService.logout();
    this.router.navigate(['/']);
  }

  onSidenavClick(): void {
    this.isMenuOpen = false;
  }
}
