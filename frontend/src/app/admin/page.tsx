'use client';

import React, { useState } from 'react';
import styles from '@/styles/Admin.module.css';

interface ProductData {
    product_id: number;
    name: string;
    price: number;
    description: string;
    stock: number;
    imageUrl: string;
    categoryId: number;
}

interface UserData {
    user_id: number;
    name: string;
    email: string;
}

interface RoleData {
    role: string;
}

export default function Admin() {
    const [productData, setProductData] = useState<ProductData>({
        product_id: 0,
        name: '',
        price: 0,
        description: '',
        stock: 0,
        imageUrl: '',
        categoryId: 1,
    });

    const [userData, setUserData] = useState<UserData>({
        user_id: 0,
        name: '',
        email: '',
    });

    const [roleData, setRoleData] = useState<RoleData>({
        role: '',
    });

    const handleCreateProduct = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/product', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(productData),
            });

            if (!response.ok) {
                throw new Error('Error al crear producto');
            }

            const data = await response.json();
            console.log('Producto creado:', data);
        } catch (error) {
            console.error('Error al crear producto:', error);
        }
    };

    const handleDeleteProduct = async (id: number) => {
        try {
            const response = await fetch(`http://localhost:8080/api/product/delete/${productData.product_id}`, {
                method: 'PUT',
            });

            if (!response.ok) {
                throw new Error('Error al eliminar producto');
            }

            const data = await response.json();
            console.log('Producto eliminado:', data);
        } catch (error) {
            console.error('Error al eliminar producto:', error);
        }
    };

    const handleUpdateUser = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/user/update/${userData.user_id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData),
            });

            if (!response.ok) {
                throw new Error('Error al actualizar usuario');
            }

            const data = await response.json();
            console.log('Usuario actualizado:', data);
        } catch (error) {
            console.error('Error al actualizar usuario:', error);
        }
    };

    const handleDeleteUser = async (id: number) => {
        try {
            const response = await fetch(`http://localhost:8080/api/user/delete/${id}`, {
                method: 'PUT',
            });

            if (!response.ok) {
                throw new Error('Error al eliminar usuario');
            }

            const data = await response.json();
            console.log('Usuario eliminado:', data);
        } catch (error) {
            console.error('Error al eliminar usuario:', error);
        }
    };

    const handleCreateRole = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/roles', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(roleData),
            });

            if (!response.ok) {
                throw new Error('Error al crear rol');
            }

            const data = await response.json();
            console.log('Rol creado:', data);
        } catch (error) {
            console.error('Error al crear rol:', error);
        }
    };

    return (
        <section className={styles.adminSection}>
            <h2>Panel de Administración</h2>

            <div className={styles.productSection}>
                <h3>Crear Producto</h3>

                <div className={styles.formField}>
                    <label htmlFor="productName">Nombre del producto</label>
                    <input
                        type="text"
                        id="productName"
                        placeholder="Nombre del producto"
                        value={productData.name}
                        onChange={(e) => setProductData({ ...productData, name: e.target.value })}
                    />
                </div>

                <div className={styles.formField}>
                    <label htmlFor="productPrice">Precio del producto</label>
                    <input
                        type="number"
                        id="productPrice"
                        placeholder="Precio del producto"
                        value={productData.price}
                        onChange={(e) => setProductData({ ...productData, price: Number(e.target.value) })}
                    />
                </div>

                <div className={styles.formField}>
                    <label htmlFor="productDescription">Descripción del producto</label>
                    <input
                        type="text"
                        id="productDescription"
                        placeholder="Descripción del producto"
                        value={productData.description}
                        onChange={(e) => setProductData({ ...productData, description: e.target.value })}
                    />
                </div>

                <div className={styles.formField}>
                    <label htmlFor="productStock">Stock del producto</label>
                    <input
                        type="number"
                        id="productStock"
                        placeholder="Stock del producto"
                        value={productData.stock}
                        onChange={(e) => setProductData({ ...productData, stock: Number(e.target.value) })}
                    />
                </div>

                <div className={styles.formField}>
                    <label htmlFor="productImageUrl">URL de la imagen</label>
                    <input
                        type="text"
                        id="productImageUrl"
                        placeholder="URL de la imagen"
                        value={productData.imageUrl}
                        onChange={(e) => setProductData({ ...productData, imageUrl: e.target.value })}
                    />
                </div>

                <div className={styles.formField}>
                    <label htmlFor="categoryId">ID de Categoría</label>
                    <input
                        type="number"
                        id="categoryId"
                        placeholder="ID de Categoría"
                        value={productData.categoryId}
                        onChange={(e) => setProductData({ ...productData, categoryId: Number(e.target.value) })}
                    />
                </div>

                <button onClick={handleCreateProduct} className={styles.btn}>Crear Producto</button>
            </div>



            <div className={styles.productSection}>
                <h3>Eliminar Producto</h3>
                <input
                    type="number"
                    placeholder="ID del producto"
                    onChange={(e) => setProductData({ ...productData, product_id: Number(e.target.value) })}
                />
                <button onClick={() => handleDeleteProduct(productData.product_id)} className={styles.btn}>Eliminar Producto</button>
            </div>


            <div className={styles.userSection}>
                <h3>Actualizar Usuario</h3>
                <input
                    type="number"
                    placeholder="ID del usuario"
                    value={userData.user_id}
                    onChange={(e) => setUserData({ ...userData, user_id: Number(e.target.value) })}
                />
                <input
                    type="text"
                    placeholder="Nombre del usuario"
                    value={userData.name}
                    onChange={(e) => setUserData({ ...userData, name: e.target.value })}
                />
                <input
                    type="email"
                    placeholder="Correo electrónico del usuario"
                    value={userData.email}
                    onChange={(e) => setUserData({ ...userData, email: e.target.value })}
                />
                <button onClick={handleUpdateUser} className={styles.btn}>Actualizar Usuario</button>
            </div>


            <div className={styles.userSection}>
                <h3>Eliminar Usuario</h3>
                <input
                    type="number"
                    placeholder="ID del usuario"
                    onChange={(e) => setUserData({ ...userData, user_id: Number(e.target.value) })}
                />
                <button onClick={() => handleDeleteUser(userData.user_id)} className={styles.btn}>Eliminar Usuario</button>
            </div>

            <div className={styles.roleSection}>
                <h3>Crear Rol</h3>
                <input
                    type="text"
                    placeholder="Nombre del rol"
                    value={roleData.role}
                    onChange={(e) => setRoleData({ role: e.target.value })}
                />
                <button onClick={handleCreateRole} className={styles.btn}>Crear Rol</button>
            </div>
        </section>
    );
}
