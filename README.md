# ACTIVIDAD POST-CONTENIDO — UNIDAD 11
## REFACTORIZACIÓN GUIADA POR PRUEBAS: CODE SMELLS Y ACOPLAMIENTO
**Estudiante:** Jorge Armando Martínez Peinado (Cód. 1152162)  
**Curso:** Patrones de Diseño de Software (1156701-A)  
**Institución:** Universidad Francisco de Paula Santander (UFPS)  

---

## 1. REFACTORIZACIONES APLICADAS
1. **Red de Seguridad (Pruebas de Caracterización):** Implementación de `FacturacionCaracterizacionTest` antes de modificar los paquetes, congelando el comportamiento esperado.
2. **Eliminación del Arrow Anti-pattern:** Supresión de condicionales anidados mediante cláusulas de guarda (*Guard Clauses*).
3. **Erradicación de Dependencias Circulares:** El paquete `facturacion` depende unidireccionalmente de `inventario`, cumpliendo el Principio de Dependencias Acíclicas (ADP).

---

## 2. INSTRUCCIONES DE EJECUCIÓN
```bash
cd refactoring-u11
mvn clean test
mvn exec:java
```
