'use client'
import styles from "@/styles/Index.module.css";
export default function Home() {
  return (
    <>
      {/* Hero Section */}
      <section id="home" className={styles.hero}>
        <div className="hero-text">
          <h2>Bienvenido a nuestra tienda</h2>
          <p>Selecciona los productos favoritos para tu mascota</p>
        </div>
      </section>

      {/* Product Grid */}
      <section id="products" className={styles.products}>
        <div className={styles.container}>
          <h2>Productos destacados</h2>
          <div className={styles.productGrid}>
            {/* Product 1 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/000000/FFFFFF/png" alt="Product 1" />
              <h3>Producto 1</h3>
              <p>COP$150000 - USD$36.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
            {/* Product 2 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/000000/FFFFFF/png" alt="Product 2" />
              <h3>Producto 2</h3>
              <p>COP$98000 - USD$23.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
            {/* Product 3 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/png" alt="Product 3" />
              <h3>Producto 3</h3>
              <p>COP$20500 - USD$4.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
            {/* Product 4 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/FF00FF/FFFFFF/png" alt="Product 4" />
              <h3>Producto 4</h3>
              <p>COP$30000 - USD$7.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
            {/* Product 5 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/FF0000/FFFFFF/png" alt="Product 5" />
              <h3>Producto 5</h3>
              <p>COP$98000 - USD$23.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
            {/* Product 6 */}
            <div className={styles.productCard}>
              <img src="https://placehold.co/600x400/000000/FFFFFF/png" alt="Product 6" />
              <h3>Producto 6</h3>
              <p>COP$60000 - USD$14.99</p>
              <a href="#" className={styles.btn}>Añadir al carrito</a>
            </div>
          </div>
        </div>
      </section>
 </>
  );
}
