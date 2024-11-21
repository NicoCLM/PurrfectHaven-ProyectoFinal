'use client';

import styles from '@/styles/CartTable.module.css';

interface CartItem {
    productId: number;
    name: string;
    price: number;
    amount: number;
}

interface CartTableProps {
    cart: CartItem[];
}

export default function CartTable({ cart }: CartTableProps) {
    return (
        <div>
            <h2>Carrito de compras</h2>
            <table className={styles.table}>
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    {cart.length > 0 ? (
                        cart.map((item) => (
                            <tr key={item.productId}>
                                <td>{item.name}</td>
                                <td>{item.amount}</td>
                                <td>${item.price}</td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan={3}>No hay productos en el carrito</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

