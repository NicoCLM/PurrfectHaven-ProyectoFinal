'use client';

import { useState, FormEvent } from 'react';
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
    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setError(null);
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
                <a className={styles.btn} href="/">Volver</a>
            </div>
        </div>
    );
};

export default AuthForm;

