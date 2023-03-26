import {Component, OnInit,   Input} from '@angular/core';
import { DataService} from "../data-service.service";

@Component({
  selector: 'app-cathedrale',
  templateUrl: './cathedrale.component.html',
  styleUrls: ['./cathedrale.component.scss']
})
export class CathedraleComponent {


  constructor(private dataService: DataService) { }

  cathedrales: any[] = [];
  title: string = "Katedra";
  searchTerm: string = '';

  ngOnInit() {
    this.cathedrales = this.dataService.getCathedrales();

  }

  filteredCathedrales() {
    return this.cathedrales.filter(cathedrale =>
      cathedrale.nom.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      cathedrale.ville.toLowerCase().includes(this.searchTerm.toLowerCase()) || cathedrale.departement.toString().includes(this.searchTerm.toLowerCase())
    );
  }
  toggleValidee(cathedrale: any) {
    cathedrale.valide = !cathedrale.valide;
  }

  listView() {
    const cathedrales = document.querySelectorAll<HTMLElement>('.cathedrale');
    cathedrales.forEach(cathedrale => {
      if (cathedrale.style.width == '35vh'){
        cathedrale.style.width = '180vh';
        const test = document.getElementById('but');
        if (test) {
          test.setAttribute('src', './assets/four-squares.png');
        }
      }
      else{
        const test = document.getElementById('but');
        if (test) {
          test.setAttribute('src', './assets/list.png');
        }
        cathedrale.style.width = '35vh';
      }

    });
  }
}
