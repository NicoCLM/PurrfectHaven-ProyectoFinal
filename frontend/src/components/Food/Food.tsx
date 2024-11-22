'use client';

import styles from '@/styles/Product.module.css';
import { useEffect, useState } from "react";

interface Product {
    productId: number;
    name: string;
    price: number;
}

interface FoodProps {
    addToCart: (product: Product) => void;
}

export default function FoodPage({ addToCart }: FoodProps) {
    const [products, setProducts] = useState<Product[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const categoryId = 1;
                const response = await fetch(`http://localhost:8080/api/product?categoryId=${categoryId}`);
                if (!response.ok) {
                    throw new Error(`Error: ${response.status}`);
                }
                const data: Product[] = await response.json();
                setProducts(data);
            } catch (err: unknown) {
                if (err instanceof Error) {
                    setError(err.message);
                } else {
                    setError("An unexpected error occurred");
                }
            }
        };

        fetchProducts();
    }, []);

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div className={styles.container}>
            <h1 className={styles.containerTitle}>Sección accesorios</h1>
            <ul className={styles.productList}>
                {products.length > 0 ? (
                    products.map((product) => (
                        <li key={product.productId} className={styles.productItem}>
                            <div className={styles.productContent}>
                                <span className={styles.productName}>{product.productId}</span>
                                <span className={styles.productName}>{product.name}</span>
                                <span className={styles.productPrice}>${product.price}</span>
                            </div>
                            <button onClick={() => addToCart(product)} className={styles.addButton}>
                                Agregar al carrito
                            </button>
                        </li>
                    ))
                ) : (
                    <li className={styles.loading}>Cargando productos...</li>
                )}
            </ul>
        </div>
    );
}
