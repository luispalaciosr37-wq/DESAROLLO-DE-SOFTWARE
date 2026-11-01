# Biblia RV1960 PWA
Laboratorio de Desarrollo Web. Sin frameworks ni compilación.

## Ejecutar
- VS Code + Live Server (clic derecho en index.html → Open with Live Server), o
- `python3 -m http.server 8080` y abrir http://localhost:8080

## Pruebas unitarias
`node tests/lib.test.mjs` → 25 PASS (23 del laboratorio + 2 propias)

## Notas
- Fuente de datos: API pública bolls.life (RV1960). Reto ★★ implementado: versículo al azar (botón "Al azar").
- Cada cambio publicado requiere subir VERSION en sw.js.
