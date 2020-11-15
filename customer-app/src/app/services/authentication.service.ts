import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, throwError } from 'rxjs';
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  private users = [
    { customerId: 1, username: 'mike', password: 'mike', firstName: 'Mike', lastName: 'van Niel', lastLogin: new Date('2020-11-11 11:11') },
    { customerId: 2, username: 'dion', password: 'dion', firstName: 'Dion', lastName: 'Rats', lastLogin: new Date('2020-11-01 00:00') },
    { customerId: 3, username: 'geoffrey', password: 'geoffrey', firstName: 'Geoffrey', lastName: 'Arkenbout', lastLogin: new Date('2020-11-01 00:00') }
  ];

  constructor() { 
    this.init(); 
  }

  init(): void {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string): Observable<User> {
    const errorMsg = 'User not found or incorrect password.';
    let targetUser: User = 
      this.users.filter(user => user.username === username)[0];

    if (targetUser) {
      if (targetUser.password === password) {
        localStorage.setItem('currentUser', JSON.stringify(targetUser));
        this.currentUserSubject.next(targetUser);
        return of(targetUser);
      } else {
        console.log('incorrect password');
        throwError(errorMsg);
      }
    } else {
      console.log('no user found with given username: ' + username);
      throwError(errorMsg);
    }
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
