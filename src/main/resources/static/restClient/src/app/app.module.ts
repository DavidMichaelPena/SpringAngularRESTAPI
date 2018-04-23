import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SodaListComponent } from './components/soda-list/soda-list.component';
import { SodaBrandComponent } from './components/soda-brand/soda-brand.component';
import { SodaService } from './shared-service/soda.service';
import { Http, HttpModule } from '@angular/http';
import { BrandService } from './shared-service/brand.service';
import { SodaFormComponent } from './components/soda-form/soda-form.component';

const appRoutes: Routes = [
  {path: 'sodas', component: SodaListComponent},
  {path: 'brands', component: SodaBrandComponent},
  {path: 'soda/edit', component: SodaFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SodaListComponent,
    SodaBrandComponent,
    SodaFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    SodaService,
    BrandService],
  bootstrap: [AppComponent]
})
export class AppModule { }
