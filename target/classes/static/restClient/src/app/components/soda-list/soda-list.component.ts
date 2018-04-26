import { Component, OnInit } from '@angular/core';
import { Soda } from '../../soda';
import { SodaService } from '../../shared-service/soda.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-soda-list',
  templateUrl: './soda-list.component.html',
  styleUrls: ['./soda-list.component.css']
})
export class SodaListComponent implements OnInit {
  soda: Soda;
  sodas: Soda[];

  constructor(private _sodaService: SodaService, private _router: Router) { }

  ngOnInit() {
    this._sodaService.getSodas()
    .subscribe((sodas) => {
        console.log(sodas);
        this.sodas = sodas;
      }, (error) => {
        console.log(error);
      }
    );
  }

  deleteSoda(soda) {
    this._sodaService.deleteSoda(soda.id)
    .subscribe((data) => {
      this.sodas.splice(this.sodas.indexOf(soda), 1);
    }, (error) => {
      console.log(error);
    });
  }

  updateSoda(soda) {
    this._sodaService.setter(soda);
    this._router.navigate(['soda/edit']);
  }

  createSoda() {
    this._router.navigate(['soda/edit']);
  }

}
