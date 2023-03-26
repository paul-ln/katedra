import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CathedraleComponent} from "./cathedrale/cathedrale.component";
import {HeaderComponent} from "./header/header.component";
import {FormsComponent} from "./forms/forms.component";


const routes: Routes = [
  {path: "", component:CathedraleComponent},
  {path: "connexion", component:FormsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
