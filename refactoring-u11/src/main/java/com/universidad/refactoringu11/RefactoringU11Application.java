package com.universidad.refactoringu11;

import com.universidad.refactoringu11.facturacion.Factura;
import com.universidad.refactoringu11.facturacion.ServicioFacturacion;
import com.universidad.refactoringu11.inventario.Producto;
import com.universidad.refactoringu11.inventario.ServicioInventario;

public class RefactoringU11Application {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" REFACTORIZACIÓN GUIADA POR PRUEBAS Y ACOPLAMIENTO - UNIDAD 11 (UFPS)");
        System.out.println(" Estudiante: Jorge Martínez");
        System.out.println("==================================================================");

        var inventario = new ServicioInventario();
        inventario.registrarProducto(new Producto("P-100", "Laptop Dell Latitude", 2800.0, 10));

        var facturacion = new ServicioFacturacion(inventario);
        Factura factura = facturacion.facturarVenta("FAC-001", "Jorge Martínez", "P-100", 2);

        System.out.printf("Factura generada: %s para %s por un total de $%.2f (IVA incluido)%n",
                factura.numero(), factura.cliente(), factura.totalLiquidado());
        System.out.println("Desacoplamiento entre paquetes exitoso y sin dependencias circulares.");
    }
}
