import React, { useState } from "react";
import styles from '@/styles/Sidebar.module.css';

interface Filters {
  price: number;
  rating: string | null;
}

const ProductFilter: React.FC<{ onApplyFilters: (filters: Filters) => void }> = ({ onApplyFilters }) => {
  const [price, setPrice] = useState<number>(100);
  const [rating, setRating] = useState<string | null>(null);

  const handlePriceChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPrice(Number(e.target.value));
  };

  const handleRatingChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setRating(e.target.value);
  };

  const handleApplyFilters = () => {
    onApplyFilters({ price, rating });
  };

  return (
    <aside className={styles.sidebar}>
      <h2>Filtrar por</h2>

      <div className={styles.filterGroup}>
        <h3>Rango de Precios</h3>
        <input
          type="range"
          id="priceRange"
          min="0"
          max="200"
          step="10"
          value={price}
          onChange={handlePriceChange}
        />
        <span id="priceValue">${price}</span>
      </div>

      <div className={styles.filterGroup}>
        <h3>Valoración</h3>
        <ul>
          <li>
            <input
              type="radio"
              name="rating"
              value="5"
              onChange={handleRatingChange}
            />{" "}
            5 Estrellas
          </li>
          <li>
            <input
              type="radio"
              name="rating"
              value="4"
              onChange={handleRatingChange}
            />{" "}
            4 Estrellas o más
          </li>
          <li>
            <input
              type="radio"
              name="rating"
              value="3"
              onChange={handleRatingChange}
            />{" "}
            3 Estrellas o más
          </li>
        </ul>
      </div>

      <button className={styles.applyFilters} onClick={handleApplyFilters}>
        Aplicar Filtros
      </button>
    </aside>
  );
};

export default ProductFilter;

