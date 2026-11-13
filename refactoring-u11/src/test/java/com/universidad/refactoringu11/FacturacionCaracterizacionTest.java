package com.universidad.refactoringu11;

import com.universidad.refactoringu11.facturacion.Factura;
import com.universidad.refactoringu11.facturacion.ServicioFacturacion;
import com.universidad.refactoringu11.inventario.Producto;
import com.universidad.refactoringu11.inventario.ServicioInventario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturacionCaracterizacionTest {

    @Test
    @DisplayName("Prueba de caracterización: Debe liquidar venta correctamente cuando hay stock")
    void debeLiquidarVentaConStock() {
        var inventario = new ServicioInventario();
        inventario.registrarProducto(new Producto("P1", "Teclado", 100.0, 5));

        var facturacion = new ServicioFacturacion(inventario);
        Factura f = facturacion.facturarVenta("F1", "Cliente Prueba", "P1", 2);

        assertNotNull(f);
        assertEquals(238.0, f.totalLiquidado(), 0.01); // 200 + 19% IVA
    }

    @Test
    @DisplayName("Prueba de caracterización: Debe rechazar venta cuando no hay stock suficiente")
    void debeRechazarVentaSinStock() {
        var inventario = new ServicioInventario();
        inventario.registrarProducto(new Producto("P1", "Teclado", 100.0, 1));

        var facturacion = new ServicioFacturacion(inventario);
        assertThrows(IllegalStateException.class, () -> facturacion.facturarVenta("F2", "Cliente Prueba", "P1", 5));
    }
}
