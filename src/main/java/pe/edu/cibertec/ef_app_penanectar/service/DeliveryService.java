package pe.edu.cibertec.ef_app_penanectar.service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    public String rastrearRepartidor(){
        if (Math.random() > 0.5){
            throw new RuntimeException("Fallo en el servicio de rastreo de repartidor");
        }
        return "Rastreo del repartidor restablecido";
    }
}
