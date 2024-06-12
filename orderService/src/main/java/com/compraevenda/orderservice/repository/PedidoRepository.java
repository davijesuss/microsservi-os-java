package com.compraevenda.orderservice.repository;

import com.compraevenda.orderservice.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
