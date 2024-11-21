'use client';

import { useState } from 'react';
import HealthHygienePage from '@/components/HealthHygiene/HealthHygiene';
import CartTable from '@/components/CartTable/CartTable';
import styles from '@/styles/Subcategory.module.css';
import { useRouter } from 'next/navigation';

interface Product {
    productId: number;
    name: string;
    price: number;
}

interface CartItem {
    productId: number;
    name: string;
    price: number;
    amount: number;
}

export default function HealthHygiene() {
    const [cart, setCart] = useState<CartItem[]>([]);
    const router = useRouter();

    const handleCheckout = () => {
        console.log("Redirigiendo al método de pago...");
        router.push('/checkout'); 
    };
    

    const addToCart = (product: Product) => {
        const existingProductIndex = cart.findIndex(item => item.productId === product.productId);
        
        if (existingProductIndex >= 0) {
            const updatedCart = [...cart];
            updatedCart[existingProductIndex].amount += 1;
            setCart(updatedCart);
        } else {
            const newCartItem: CartItem = { productId: product.productId, name: product.name, price: product.price, amount: 1 };
            setCart(prevCart => [...prevCart, newCartItem]);
        }
    };
    return (
        <div className={styles.pageContainer}>
            <div className={styles.productsContainer}>
                <h1>Salud e Higiene</h1>
                <HealthHygienePage addToCart={addToCart} />
            </div>
            <div className={styles.cartContainer}>
                <h2>Carrito</h2>
                <CartTable cart={cart} setCart={setCart} />
                {cart.length > 0 ? (
                    <button
                        className={styles.checkoutButton}
                        onClick={handleCheckout}
                    >
                        Ir al método de pago
                    </button>
                ) : (
                    <p>El carrito está vacío.</p>
                )}
            </div>
        </div>
    );
}

