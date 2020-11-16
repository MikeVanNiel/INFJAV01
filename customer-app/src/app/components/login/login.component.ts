import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/models/user';
import { NotificationService } from 'src/app/services/notification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  submitted = false;
  returnUrl: string;
  alertService: any;
  loading: boolean;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder,
    private notifyService: NotificationService
  ) { 
    this.loginForm = this.formBuilder.group({
      username: '',
      password: ''
    });
  }

  public user: User;

  ngOnInit(): void {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit(): void {
    this.submitted = true;
    this.loginUser(this.f.username.value, this.f.password.value);
  }

  loginUser(username: string, password: string) {
    this.authenticationService.login(username, password)
      .subscribe(
        response => {
          if (response.status === 200) {
            console.log('Succesvol aangemeld.');
            this.user = response.user;
            this.notifyService.showSuccess('Succesvol aangemeld.', 'Aanmelden');
            this.router.navigate([this.returnUrl]);
          } else {
            console.log('Fout bij aanmelden.');
            this.notifyService.showError('Gebruikersnaam of wachtwoord onjuist', 'Fout bij aanmelden');
          }
        },
        error => {
          console.log('Login error: ' + error);
          this.notifyService.showError(error, 'Fout bij aanmelden');
        }
      );
  }
}
