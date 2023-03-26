import {Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import {MyDataService} from "../my-data.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.scss']
})
export class FormsComponent implements OnInit{

  @ViewChild('emailInput') emailInput: ElementRef | undefined;
  @ViewChild('passwordInput') passwordInput: ElementRef | undefined;
  myData: any;
  usernames: string[] = [];
  errorMessage: string | undefined;

  constructor(private myDataService: MyDataService, private router: Router) {}

  ngOnInit(): void {
    this.myDataService.getData().subscribe((data: any) => {
      this.myData = data;

    })
  }

  onFormSubmit(pseudo: string, password: string) {
    const user = this.myData.users.find((u: { pseudo: string, password: string }) => u.pseudo === pseudo && u.password === password);

    // Si l'utilisateur existe
    if (user) {
      console.log('Connecté !');
      // Stockage de l'ID de l'utilisateur dans la sessionStorage
      sessionStorage.setItem('id', user.id.toString());

      this.router.navigate(["/"]);

    } else {
      console.log('Email ou mot de passe invalide');
      this.errorMessage = "Pseudonyme ou mot de passe invalide";
    }
  }
}
