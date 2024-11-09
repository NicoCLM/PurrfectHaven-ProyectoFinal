// src/domain/repositories/UserRepository.ts
import { User } from '../models/User';

export interface UserRepository {
  create(user: User): Promise<void>;
  findByEmail(email: string): Promise<User | null>;
}

