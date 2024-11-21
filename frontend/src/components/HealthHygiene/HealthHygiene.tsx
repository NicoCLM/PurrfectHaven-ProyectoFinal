'use client';

import styles from '@/styles/Product.module.css';
import { useEffect, useState } from "react";

interface Product {
    productId: number;
    name: string;
    price: number;
}

interface healthCareProps {
    addToCart: (product: Product) => void; 
}

export default function HealthHygiene({ addToCart }: healthCareProps) {
    const [products, setProducts] = useState<Product[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/product");
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
            <h1>Sección Higiene y Salud</h1>
            <ul>
                {products.length > 0 ? (
                    products.map((product) => (
                        <li key={product.productId}>
                            {product.name} - ${product.price}
                            <span className={styles.productName}>{product.name}</span>
                            <span className={styles.price}>{product.price}</span>
                            <button onClick={() => addToCart(product)}>Agregar al carrito</button>
                        </li>
                    ))
                ) : (
                    <li>Cargando productos...</li>
                )}
            </ul>
        </div>
    );
}
