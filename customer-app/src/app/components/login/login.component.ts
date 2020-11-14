import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

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
    private formBuilder: FormBuilder
  ) { 
    this.loginForm = this.formBuilder.group({
      username: '',
      password: ''
    });
  }

  ngOnInit(): void {
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit(): void {
    this.submitted = true;
    this.authenticationService.login(this.f.username.value, this.f.password.value)
      .subscribe(
        data => {
            console.log('Logged in!');
            this.router.navigate([this.returnUrl]);
            // this.router.navigate(['/']); 
        },
        error => {
          console.log('Login error: ' + error);
            // this.alertService.error(error);
            // this.loading = false;
        }
      );
    }
  }
