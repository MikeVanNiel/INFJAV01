import { User } from 'src/app/models/user';

export class LoginResponse {
    status: number;
    user: User;
}