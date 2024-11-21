'use client'
import styles from "@/styles/Index.module.css";
export default function Home() {
    return (
        <>
            <section id="home" className={styles.hero}>
                <div className={styles.heroText}>
                    <h1>PURRFECTHAVEN</h1>
                    <h2>Bienvenido a nuestra tienda</h2>
                    <p>Ingresa a las categorias para descubrir distintos productos</p>
                </div>
            </section>
        </>
    );
}
