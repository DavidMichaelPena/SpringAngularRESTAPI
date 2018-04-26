import { Component, OnInit } from '@angular/core';
import { Soda } from '../../soda';
import { Brand } from '../../brand';
import { SodaService } from '../../shared-service/soda.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-soda-form',
  templateUrl: './soda-form.component.html',
  styleUrls: ['./soda-form.component.css']
})
export class SodaFormComponent implements OnInit {
  public soda: Soda;
  public brand: Brand;

  constructor(private _sodaService: SodaService, private _router: Router) { }

  ngOnInit() {
    this.soda = this._sodaService.getter();
  }

  processForm() {
    // if (this.soda.id === undefined) {
    //   console.log('Stupid Id is undefined');
    //   this._sodaService.addSoda(this.soda)
    //   .subscribe((soda) => {
    //     console.log(soda);
    //     console.log('this is the create function');
    //     this._router.navigate(['sodas']);
    //   }, (error) => {
    //     console.log('This add isnt working');
    //   });
    // } else {
      this._sodaService.updateSoda(this.soda)
      .subscribe((soda) => {
        console.log(soda);
        console.log('this is the update function');
        this._router.navigate(['sodas']);
      }, (error) => {
        console.log('This update isnt working');
      });
    }
  }
