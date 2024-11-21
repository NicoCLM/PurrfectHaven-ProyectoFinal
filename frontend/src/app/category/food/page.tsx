'use client';

import { useState } from 'react';
import Accessories from '@/components/Accessories/Accessories';
import CartTable from '@/components/CartTable/CartTable';
import styles from '@/styles/Subcategory.module.css';

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

export default function FoodPage() {
    const [cart, setCart] = useState<CartItem[]>([]);

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
                <h1>Carrito y Productos</h1>
                <Accessories addToCart={addToCart} />
            </div>
            <div className={styles.cartContainer}>
                <h2>Carrito</h2>
                <CartTable cart={cart} />
            </div>
        </div>
    );
}

