import { TestBed } from '@angular/core/testing';

import { AuthenticationService } from './authentication.service';

describe('AuthenticationService', () => {
  let service: AuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should login user succesfully', () => {
    let username = 'mike';
    let password = 'mike';
    service.login(username, password).subscribe(
      response => {
        expect(response.status).toBe(200);
      }
    );
    
  })
});
