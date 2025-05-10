package com.patrones.server_soap.controller;

import com.patrones.server_soap.services.ServicioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FacturaEndpoint {
    @Autowired
    ServicioFactura servicioFactura;
    private static final String NAMESPACE_URI = "http://example.com/factura";
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "facturaRequest")

    @ResponsePayload
    public com.example.factura.FacturaResponse firmarFactura(@RequestPayload com.example.factura.FacturaRequest request) {
        return servicioFactura.firmarFactura(request);
    }
}
