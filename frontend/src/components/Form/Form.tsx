'use client';

import { useState, FormEvent } from 'react';
import { SupabaseUserRepository } from '@/data/repositories/SupabaseUserRepository';
import { AuthService } from '@/domain/services/AuthService';
import { RegisterUser } from '@/usecases/RegisterUser';
import { validatePasswordMatch } from '@/utils/validators';
import styles from '@/styles/Form.module.css';

interface AuthFormProps {
  isRegister: boolean;
}

const AuthForm: React.FC<AuthFormProps> = ({ isRegister }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [username, setUsername] = useState('');
  const [error, setError] = useState<string | null>(null);

  // Instancia de los servicios y repositorios que necesitas
  const userRepository = new SupabaseUserRepository();
  const authService = new AuthService(userRepository);
  const registerUserUseCase = new RegisterUser(authService);

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setError(null);

    if (isRegister && !validatePasswordMatch(password, confirmPassword)) {
      setError('Las contraseñas no coinciden');
      return;
    }

    try {
      if (isRegister) {
        // Llamar al caso de uso para registrar al usuario
        await registerUserUseCase.execute(email, password, username);
      } else {
        // Llamar a AuthService para login
        await authService.login(email, password);
      }
      alert('Operación exitosa');
    } catch (error: any) {
      setError(error.message);
    }
  };

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <form onSubmit={handleSubmit}>
          {isRegister && (
            <div>
              <label htmlFor="username" className={styles.labels}>Nombre de usuario:</label>
              <input
                className={styles.inpt}
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
              />
            </div>
          )}
          <div>
            <label htmlFor="email" className={styles.labels}>Correo electrónico:</label>
            <input
              className={styles.inpt}
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div>
            <label htmlFor="password" className={styles.labels}>Contraseña:</label>
            <input
              className={styles.inpt}
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          {isRegister && (
            <div>
              <label htmlFor="confirmPassword" className={styles.labels}>Confirmar contraseña:</label>
              <input
                className={styles.inpt}
                type="password"
                id="confirmPassword"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                required
              />
            </div>
          )}
          {error && <p className={styles.errorMsg}>{error}</p>}
          <button type="submit" className={styles.btn}>
            {isRegister ? 'Registrarse' : 'Iniciar sesión'}
          </button>
        </form>
        <button className={styles.btn}>
          <a href="/">Volver</a>
        </button>
      </div>
    </div>
  );
};

export default AuthForm;

