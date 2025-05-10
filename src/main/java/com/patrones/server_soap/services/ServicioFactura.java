package com.patrones.server_soap.services;

import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Service
public class ServicioFactura {
    public com.example.factura.FacturaResponse firmarFactura(@RequestPayload com.example.factura.FacturaRequest request) {
        com.example.factura.FacturaResponse response = new com.example.factura.FacturaResponse();

        response.setEmisor(request.getEmisor());
        response.setReceptor(request.getReceptor());
        response.setFechaEmision(request.getFechaEmision());
        response.setNumeroFactura(request.getNumeroFactura());
        response.setProductos(request.getProductos());
        response.setTotal(request.getTotal());
        // Simular firma (hash simple + base64)
        String data = request.getNumeroFactura() + request.getTotal() + request.getFechaEmision().toString();
        String firma = Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
        response.setFirmaDigital(firma);
        return response;
    }
}
