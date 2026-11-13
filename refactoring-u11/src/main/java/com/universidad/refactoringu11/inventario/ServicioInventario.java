package com.universidad.refactoringu11.inventario;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ServicioInventario {
    private final Map<String, Producto> catalogo = new ConcurrentHashMap<>();

    public void registrarProducto(Producto producto) {
        catalogo.put(producto.codigo(), producto);
    }

    public Optional<Producto> consultarProducto(String codigo) {
        return Optional.ofNullable(catalogo.get(codigo));
    }

    public boolean validarStock(String codigo, int cantidadRequerida) {
        return consultarProducto(codigo)
                .map(p -> p.stockDisponible() >= cantidadRequerida)
                .orElse(false);
    }
}
