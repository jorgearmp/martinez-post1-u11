package com.universidad.refactoringu11.facturacion;

import java.time.LocalDateTime;

public record Factura(String numero, String cliente, double totalLiquidado, LocalDateTime fecha) {}
