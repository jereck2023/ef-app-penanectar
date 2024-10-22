package pe.edu.cibertec.ef_app_penanectar.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ef_app_penanectar.service.DeliveryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping
    @CircuitBreaker(name = "myService", fallbackMethod = "fallBackMethod")
    public String rastrearRepartidor(){
        return deliveryService.rastrearRepartidor();
    }

    public String fallBackMethod(Throwable throwable){
        return "No se pudo rastrear al repartidor. Intentalo más tarde.";
    }
}