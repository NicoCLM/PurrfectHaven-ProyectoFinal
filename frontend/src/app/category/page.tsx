'use client'
import styles from '@/styles/Category.module.css';
import Link from 'next/link';


export default function Category (){
    return(
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
                  <Link href="/category/food">
                    <h3>Comida</h3>
                  </Link>
              </div>
              <div className={styles.categoryCard}>
                  <Link href="/category/accessories">
                    <h3>Accesorios</h3>
                  </Link>
              </div>
              <div className={styles.categoryCard}>
                  <Link href="/category/toys">
                    <h3>Juguetes</h3>
                  </Link>
              </div>
              <div className={styles.categoryCard}>
                  <Link href="/category/health_hygiene">
                    <h3>Salud e Higiene</h3>
                  </Link>
              </div>
            </div>
          </div>
        </section>

     </>
    );
}
