import Link from 'next/link';
import styles from '@/styles/Navbar.module.css';
import { FaShoppingCart } from 'react-icons/fa';


const Navbar: React.FC = () => {
  return (
    <div className={styles.container}>
      <h1>Pet Prod Shop</h1>
      <nav>
        <ul>
          <li><Link href="/shoppingcart"><FaShoppingCart className={styles.cartIcon}/></Link></li>
          <li><Link href="/">Inicio</Link></li>
          <li><Link href="/category">Categorías</Link></li>
          <li><Link href="/login">Iniciar Sesión</Link></li>
          <li><Link href="/signup">Crear Cuenta</Link></li>
        </ul>
      </nav>
    </div>
  );
}

export default Navbar;
