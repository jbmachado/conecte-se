import { User } from './user';
export interface Token {
  iss: String;
  user: User;
}
