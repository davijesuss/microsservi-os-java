package com.shipment.ShippingService.controller;

import com.shipment.ShippingService.dto.ShippingRequestDto;
import com.shipment.ShippingService.entity.Shipping;
import com.shipment.ShippingService.service.ShippingService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody @Valid ShippingRequestDto shippingRequestDto) {
        Shipping shipping = shippingService.createShipping(shippingRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(shipping);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipping> updateShippingStatus(@PathVariable Long id,
                                                         @RequestParam String status,
                                                         @RequestParam String detalhesRastreamento) {
        Shipping updatedShipping = shippingService.updateShippingStatus(id, status, detalhesRastreamento);
        return ResponseEntity.ok(updatedShipping);
    }
}
