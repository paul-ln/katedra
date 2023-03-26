import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {


  constructor(private router: Router) {
  }
  get(){
      if (!sessionStorage.getItem('id')){
        return "Connexion"
      }
      else {
        return "Déconnexion";
      }

  }
  userCon() {
    if (sessionStorage.getItem('id')) {
      const confirmed = window.confirm('Êtes-vous sûr de vouloir vous déconnecter ?');
      if (confirmed) {
        sessionStorage.removeItem('id');
        this.router.navigate(['/']);
      }
    } else {
      this.router.navigate(['/connexion']);
    }
  }

}
