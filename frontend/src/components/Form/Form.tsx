'use client';

import { useEffect, useState } from 'react';
import { FormEvent } from 'react';
import styles from '@/styles/Form.module.css';

interface AuthFormProps {
    isRegister: boolean;
}

const AuthForm: React.FC<AuthFormProps> = ({ isRegister }) => {
    const [username, setUsername] = useState('');
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [hashedPassword, setHashedPassword] = useState('');
    const [address, setAddress] = useState('');
    const [phone, setPhone] = useState('');
    const [error, setError] = useState<string | null>(null);

    const handleLogin = (data: any) => {
        if (data?.userId) {
            localStorage.setItem('userId', data.userId);
        } else {
            setError('No se encontró un userId en la respuesta.');
        }
    };

    const createShoppingCart = async (userId: number) => {
        const response = await fetch('http://localhost:8080/api/shoppingCart', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ userId: userId }), // Enviar userId y detalles del carrito
        });
      
        if (response.ok) {
          const newCart = await response.json();
          console.log('Carrito creado:', newCart);
        } else {
          console.error('Error creando carrito');
        }
      };
      

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setError(null);

        const body = {
            username,
            name,
            email,
            hashedPassword,
            address,
            phone,
        };

        try {
            const response = await fetch(`http://localhost:8080/api/user${isRegister ? '/register' : '/login'}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(body),
            });

            const textResponse = await response.text();
            console.log('Respuesta del servidor:', textResponse);

            if (!response.ok) {
                const errorMessage = textResponse || 'Error desconocido';
                setError(errorMessage);
                return;
            }

            const data = JSON.parse(textResponse);
            console.log('Datos del servidor:', data);

            handleLogin(data);

            window.location.href = isRegister ? '/login' : '/';
        } catch (err) {
            setError('Hubo un error en la solicitud. Intenta nuevamente.');
            console.log(err);
        }
    };

    useEffect(() => {
        const storedUserId = localStorage.getItem('userId');
        if (storedUserId) {
            console.log('Usuario autenticado con userId:', storedUserId);
        }
    }, []);

    return (
        <div className={styles.container}>
            <div className={styles.form}>
                <form onSubmit={handleSubmit}>
                    {isRegister && (
                        <>
                            <div>
                                <label htmlFor="email" className={styles.labels}>Correo Electronico:</label>
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
                                <label htmlFor="name" className={styles.labels}>Nombre completo:</label>
                                <input
                                    className={styles.inpt}
                                    type="text"
                                    id="name"
                                    value={name}
                                    onChange={(e) => setName(e.target.value)}
                                    required
                                />
                            </div>
                        </>
                    )}
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
                    <div>
                        <label htmlFor="password" className={styles.labels}>Contraseña:</label>
                        <input
                            className={styles.inpt}
                            type="password"
                            id="password"
                            value={hashedPassword}
                            onChange={(e) => setHashedPassword(e.target.value)}
                            required
                        />
                    </div>
                    {isRegister && (
                        <div>
                            <label htmlFor="address" className={styles.labels}>Dirección:</label>
                            <input
                                className={styles.inpt}
                                type="text"
                                id="address"
                                value={address}
                                onChange={(e) => setAddress(e.target.value)}
                                required
                            />
                        </div>
                    )}
                    {isRegister && (
                        <div>
                            <label htmlFor="phone" className={styles.labels}>Teléfono:</label>
                            <input
                                className={styles.inpt}
                                type="text"
                                id="phone"
                                value={phone}
                                onChange={(e) => setPhone(e.target.value)}
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

