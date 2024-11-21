'use client'

import styles from '@/styles/FrequentQuestions.module.css';

export default function FrequentQuestions() {
    return(
        <section className={styles.faqSection}>
        <h2 className={styles.title}>Preguntas Frecuentes</h2>
        
        <div className={styles.faqItem}>
          <h3>¿Cómo puedo realizar un pedido?</h3>
          <p>Para realizar un pedido, selecciona los productos que deseas y añade al carrito. Luego, sigue el proceso de pago.</p>
        </div>
  
        <div className={styles.faqItem}>
          <h3>¿Cuáles son los métodos de pago disponibles?</h3>
          <p>Aceptamos tarjetas de crédito, débito, y pagos por transferencias bancarias.</p>
        </div>
  
        <div className={styles.faqItem}>
          <h3>¿Realizan envíos internacionales?</h3>
          <p>Sí, realizamos envíos a varios países. Verifica si tu país está en nuestra lista de envíos al finalizar la compra.</p>
        </div>
  
        <div className={styles.faqItem}>
          <h3>¿Puedo cambiar un producto después de recibirlo?</h3>
          <p>Sí, puedes cambiar un producto dentro de los 30 días posteriores a la recepción. Verifica nuestra política de devoluciones.</p>
        </div>
  
        <div className={styles.faqItem}>
          <h3>¿Cómo puedo contactar con soporte?</h3>
          <p>Puedes contactarnos a través de nuestro formulario de contacto en el sitio web o enviando un correo a soporte@tienda.com.</p>
        </div>
      </section>
    );

}