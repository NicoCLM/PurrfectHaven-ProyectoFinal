package co.purrfecthaven.nico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.purrfecthaven.nico.model.DiscountCoupons;

/**
 * DiscountCouponsRepository
 */
public interface DiscountCouponsRepository extends JpaRepository<DiscountCoupons, Integer> {

    
}
