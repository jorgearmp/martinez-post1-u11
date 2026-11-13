package com.universidad.refactoringu11.facturacion;

import com.universidad.refactoringu11.inventario.Producto;
import com.universidad.refactoringu11.inventario.ServicioInventario;

public class ServicioFacturacion {
    private final ServicioInventario servicioInventario;

    public ServicioFacturacion(ServicioInventario servicioInventario) {
        this.servicioInventario = servicioInventario;
    }

    public Factura facturarVenta(String numero, String cliente, String codigoProducto, int cantidad) {
        // Cláusulas de guarda para aplanar código y evitar Arrow Anti-pattern
        if (!servicioInventario.validarStock(codigoProducto, cantidad)) {
            throw new IllegalStateException("Venta rechazada: Existencias insuficientes del producto " + codigoProducto);
        }

        Producto producto = servicioInventario.consultarProducto(codigoProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no registrado."));

        double subtotal = producto.precioBase() * cantidad;
        double iva = subtotal * 0.19;
        double total = subtotal + iva;

        return new Factura(numero, cliente, total, java.time.LocalDateTime.now());
    }
}
