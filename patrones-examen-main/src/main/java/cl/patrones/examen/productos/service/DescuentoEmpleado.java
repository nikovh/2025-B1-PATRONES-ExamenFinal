package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class DescuentoEmpleado implements DescuentoStrategy {
    
    private static final double DESCUENTO_EMPLEADO = 0.05; // 5% de descuento para empleados

    @Override
    public double calcularDescuento(Producto producto, Object usuario, LocalDate dia) {
        // Verifica si el usuario es un empleado
        // if (usuario.getRol().equalsIgnoreCase(UserDetailsServiceImpl.ROL_EMPLEADO)) {
        if (esEmpleado()) {
            // Aplica un descuento del 5% para empleados
            return DESCUENTO_EMPLEADO;
        }
        // Si no es empleado, no hay descuento
        return 0.0;
    }

    private boolean esEmpleado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            System.out.println("Usuario autenticado: " + auth.getName());
            auth.getAuthorities().forEach(role -> System.out.println("Rol detectado: " + role.getAuthority()));
            return auth.getAuthorities().stream()
                       .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_EMPLEADO"));
        }
        return false;
    }
    
}