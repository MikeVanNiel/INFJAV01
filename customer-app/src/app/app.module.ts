import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { registerLocaleData } from '@angular/common';
import localeNl from '@angular/common/locales/nl';

import { AppComponent } from './app.component';
import { ToolbarComponent } from './components/general/toolbar/toolbar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { DetailsComponent } from './components/customer/details/details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from './services/authentication.service';
import { ListComponent } from './components/customer/list/list.component';

registerLocaleData(localeNl);

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    HomeComponent,
    LoginComponent,
    DetailsComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthenticationService,
    { provide: LOCALE_ID, useValue: "nl-NL" }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
