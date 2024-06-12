package com.shipment.ShippingService.service;

import com.shipment.ShippingService.dto.ShippingRequestDto;
import com.shipment.ShippingService.entity.Shipping;
import com.shipment.ShippingService.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public Shipping createShipping(ShippingRequestDto shippingRequestDto) {
        Shipping shipping = new Shipping();
        shipping.setPedidoId(shippingRequestDto.getPedidoId());
        shipping.setTransportadora(shippingRequestDto.getTransportadora());
        shipping.setStatus("PENDING");
        shipping.setDetalhesRastreamento("N/A");  // Este valor será atualizado posteriormente
        return shippingRepository.save(shipping);
    }

    public Shipping updateShippingStatus(Long id, String status, String detalhesRastreamento) {
        Shipping shipping = shippingRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipping not found"));
        shipping.setStatus(status);
        shipping.setDetalhesRastreamento(detalhesRastreamento);
        return shippingRepository.save(shipping);
    }
}