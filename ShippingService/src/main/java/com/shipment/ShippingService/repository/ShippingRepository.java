package com.shipment.ShippingService.repository;

import com.shipment.ShippingService.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
