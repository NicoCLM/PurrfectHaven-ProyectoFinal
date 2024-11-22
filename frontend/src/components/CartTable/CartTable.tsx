'use client';
import styles from '@/styles/CartTable.module.css'
import { FC } from 'react';

interface CartItem {
    productId: number;
    name: string;
    price: number;
    amount: number;
}

interface CartTableProps {
    cart: CartItem[];
    setCart: React.Dispatch<React.SetStateAction<CartItem[]>>;
}

const CartTable: FC<CartTableProps> = ({ cart, setCart }) => {

    const decreaseAmount = (productId: number) => {
        const updatedCart = cart.map(item => {
            if (item.productId === productId && item.amount > 1) {
                return { ...item, amount: item.amount - 1 };
            }
            return item;
        }).filter(item => item.amount > 0);
        setCart(updatedCart);
    };


    const removeItem = (productId: number) => {
        const updatedCart = cart.filter(item => item.productId !== productId);
        setCart(updatedCart);
    };

    return (
        <table className={styles.cartTable}>
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                {cart.length > 0 ? (
                    cart.map((item) => (
                        <tr key={item.productId}>
                            <td>{item.name}</td>
                            <td>${item.price}</td>
                            <td>
                                <button
                                    onClick={() => decreaseAmount(item.productId)}
                                    className={styles.quantityButton}
                                >
                                    -
                                </button>
                                {item.amount}
                                <button
                                    onClick={() => {
                                        if (item.amount === 1) {
                                            removeItem(item.productId);
                                        } else {
                                            setCart(prevCart =>
                                                prevCart.map(cartItem =>
                                                    cartItem.productId === item.productId
                                                        ? { ...cartItem, amount: cartItem.amount + 1 }
                                                        : cartItem
                                                )
                                            );
                                        }
                                    }}
                                    className={styles.quantityButton}
                                >
                                    +
                                </button>
                            </td>
                            <td>
                                <button
                                    onClick={() => removeItem(item.productId)}
                                    className={styles.removeButton}
                                >
                                    Eliminar
                                </button>
                            </td>
                        </tr>
                    ))
                ) : (
                    <tr>
                        <td colSpan={4}>El carrito está vacío.</td>
                    </tr>
                )}
            </tbody>
        </table>
    );
};

export default CartTable;


