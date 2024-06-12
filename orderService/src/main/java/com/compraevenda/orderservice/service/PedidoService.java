package com.compraevenda.orderservice.service;

import com.compraevenda.orderservice.entity.Pedido;

public interface PedidoService {
    Pedido criarPedido(Pedido pedido);
    Pedido atualizarPedido(Long id, Pedido pedido);
    double calcularTotalPedido(Long id);
}