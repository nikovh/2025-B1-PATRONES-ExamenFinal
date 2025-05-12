package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class DescuentoEmpleado implements DescuentoStrategy {
    
    private static final double DESCUENTO_EMPLEADO = 0.05; // 5% de descuento para empleados

    @Override
    public double calcularDescuento(Producto producto, LocalDate dia) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() &&
            auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_EMPLEADO"))) {
                    return DESCUENTO_EMPLEADO;
        }
        return 0.0; // Sin descuento si no es empleado
    }    
}