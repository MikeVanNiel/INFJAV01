import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { MatDialog } from '@angular/material';
import { User } from 'src/app/models/user';

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
    private dialog: MatDialog
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
        data => {
            console.log('Logged in!');
            this.user = data;
            this.router.navigate([this.returnUrl]);
        },
        error => {
          console.log('Login error: ' + error);
          this.openDialog(error, 'Fout bij inloggen')
        }
      );
  }

  openDialog(msg: string, title?: string): void {
    this.dialog.open(LoginComponent, {
      data: {
        title: title || 'Let op',
        message: msg,
        information: '',
        button: 0,
        style: 0,
        allow_outside_click: true
      }
    });
  }


}
