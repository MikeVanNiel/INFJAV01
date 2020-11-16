import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  /* it('should login user', () => {
    const username = 'mike';
    const password = 'mike';
    const loginComp = new LoginComponent(
      new ActivatedRoute(),
      new Router(),
      new AuthenticationService(),
      new FormBuilder(),
      new MatDialog()
    );
    expect(loginComp.user).toBe(null);
    loginComp.loginUser(username, password);
    expect(loginComp.user).toBe(!null);
  }) */
});
