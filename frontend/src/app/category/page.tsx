'use client'
import styles from '@/styles/Category.module.css';
import Link from 'next/link';


export default function Category() {
    return (
        <>
            <section id="home" className={styles.hero}>
                <div className={styles.heroText}>
                    <h2>Categorías</h2>
                </div>
            </section>

            <section id="categories" className={styles.categories}>
                <div className={styles.container}>
                    <div className={styles.categoryGrid}>
                        <div className={styles.categoryCard}>
                            <a href="/category/food" className={styles.btn}>
                                <h3>Alimentos</h3>
                            </a>
                        </div>
                        <div className={styles.categoryCard}>
                            <a href="/category/accessories" className={styles.btn}>
                                <h3>Accesorios</h3>
                            </a>
                        </div>
                        <div className={styles.categoryCard}>
                            <a href="/category/toys" className={styles.btn}>
                                <h3>Juguetes</h3>
                            </a>
                        </div>
                        <div className={styles.categoryCard}>
                            <a href="/category/health_hygiene" className={styles.btn}>
                                <h3>Salud e Higiene</h3>
                            </a>
                        </div>
                    </div>
                </div>
            </section>

        </>
    );
}
