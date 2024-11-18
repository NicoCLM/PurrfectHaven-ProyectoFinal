import styles from '@/styles/CartTable.module.css';

const CartTable: React.FC = () => {
    return (
        <>
            <div className={styles.tableDiv}>
                <table>
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>xxx</td>
                            <td>1</td>
                            <td>$10.00</td>
                        </tr>
                        <tr>
                            <td>yyy</td>
                            <td>2</td>
                            <td>$20.00</td>
                        </tr>
                        <tr>
                            <td>zzz</td>
                            <td>3</td>
                            <td>$30.00</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div>
                <button>Proceder al pago</button>
            </div>
        </>
    );

};


export default CartTable; 
