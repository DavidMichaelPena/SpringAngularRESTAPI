import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SodaListComponent } from './components/soda-list/soda-list.component';
import { SodaBrandComponent } from './components/soda-brand/soda-brand.component';
import { SodaService } from './shared-service/soda.service';
import { BrandService } from './shared-service/brand.service';
// import { Http, HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { SodaFormComponent } from './components/soda-form/soda-form.component';
import { SodaComponent } from './components/soda/soda.component';

const appRoutes: Routes = [
  { path: '', redirectTo: 'sodas', pathMatch: 'full' },
  { path: 'sodas', component: SodaListComponent},
  { path: 'brands', component: SodaBrandComponent},
  { path: 'soda/edit', component: SodaFormComponent},
  { path: 'sodas/:id', component: SodaComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SodaListComponent,
    SodaBrandComponent,
    SodaFormComponent,
    SodaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    SodaService,
    BrandService],
  bootstrap: [AppComponent]
})
export class AppModule { }
