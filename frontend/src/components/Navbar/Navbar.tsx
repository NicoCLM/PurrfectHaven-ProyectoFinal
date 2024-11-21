'use client'

import Link from 'next/link';
import styles from '@/styles/Navbar.module.css';
import { FaShoppingCart } from 'react-icons/fa';


const Navbar: React.FC = () => {
    return (
        <div className={styles.container}>
            <h1>PurrfectHaven</h1>
            <nav>
                <ul>
                    <li><Link href="/">Inicio</Link></li>
                    <li><Link href="/category">Categorías</Link></li>
                    <li><Link href="/login">Iniciar Sesión</Link></li>
                    <li><Link href="/signup">Crear Cuenta</Link></li>
                    <li><Link href="/admin">Panel de administrador</Link></li>
                    <li><Link href="/frequentQuestions">FaQ</Link></li>
                </ul>
            </nav>
        </div>
    );
}

export default Navbar;
