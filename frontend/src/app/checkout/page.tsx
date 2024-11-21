'use client'
import { useState } from 'react';

export default function Checkout () {
    const [paymentData, setPaymentData] = useState({
        amount: 0,
        paymentMethods: '',
      });
    
      const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
    
        try {
          const response = await fetch('http://localhost:8080/api/payments', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              amount: paymentData.amount,
              paymentMethods: paymentData.paymentMethods,
            }),
          });
    
          if (response.ok) {
            alert('Pago realizado exitosamente.');
            setPaymentData({ amount: 0, paymentMethods: '' }); // Reinicia el formulario
          } else {
            alert('Error al procesar el pago.');
          }
        } catch (error) {
          console.error('Error al enviar los datos del pago:', error);
          alert('Ocurrió un error. Intenta nuevamente.');
        }
      };
    
      return (
        <div style={{ maxWidth: '600px', margin: '0 auto', padding: '20px' }}>
          <h1>Checkout</h1>
          <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
            {/* Campo de Monto */}
            <label>
              Monto del Pago:
              <input
                type="number"
                value={paymentData.amount}
                onChange={(e) => setPaymentData({ ...paymentData, amount: parseFloat(e.target.value) })}
                required
                style={{
                  padding: '10px',
                  border: '1px solid #ddd',
                  borderRadius: '5px',
                  width: '100%',
                }}
              />
            </label>
    
            {/* Campo de Método de Pago */}
            <label>
              Método de Pago:
              <input
                type="text"
                placeholder="Ej: Tarjeta de crédito, PayPal, etc."
                value={paymentData.paymentMethods}
                onChange={(e) => setPaymentData({ ...paymentData, paymentMethods: e.target.value })}
                required
                style={{
                  padding: '10px',
                  border: '1px solid #ddd',
                  borderRadius: '5px',
                  width: '100%',
                }}
              />
            </label>
    
            {/* Botón de Enviar */}
            <button
              type="submit"
              style={{
                backgroundColor: '#AB263A',
                color: '#fff',
                padding: '10px',
                border: 'none',
                borderRadius: '5px',
                cursor: 'pointer',
                transition: 'background-color 0.3s ease',
              }}
            >
              Realizar Pago
            </button>
          </form>
        </div>
      );
}

