# Editor de Texto SaaS

Proyecto integrador de la unidad de Cómputo en la Nube (SaaS) — Editor de documentos
de texto construido con Spring Boot, JPA/H2 y un front-end estático (Clases 1 a 4).

## Cómo abrir y correr en Visual Studio Code

1. Instala la extensión **"Extension Pack for Java"** de Microsoft (incluye soporte
   Maven, debugger, etc.) desde el marketplace de VS Code, si no la tienes.
2. Asegúrate de tener **JDK 17 o superior** instalado (`java -version` en la terminal).
   No necesitas instalar Maven aparte: el proyecto incluye el **Maven Wrapper**
   (`mvnw` / `mvnw.cmd`), que descarga Maven automáticamente la primera vez que lo usas.
3. Descomprime este proyecto y ábrelo en VS Code: `File > Open Folder...` y selecciona
   la carpeta `editor-texto-saas`.
4. Espera a que VS Code detecte el proyecto Maven (verás el ícono de Java cargando en
   la barra de estado). Puede tardar en la primera carga porque descarga dependencias.
5. Corre la aplicación de alguna de estas formas:
   - Abre `EditorTextoSaasApplication.java` y presiona **Run** (▶) arriba del método `main`.
   - O desde la terminal integrada (dentro de la carpeta del proyecto):
     - macOS/Linux: `./mvnw spring-boot:run`
     - Windows (PowerShell/CMD): `mvnw.cmd spring-boot:run`
   - La primera vez tardará un poco porque `mvnw` descarga Maven y luego las
     dependencias del proyecto; necesitas conexión a internet para ese primer paso.
6. Abre el navegador en:
   - http://localhost:8080/api/status → mensaje de prueba (Clase 1)
   - http://localhost:8080/h2-console → consola de la base de datos H2 (JDBC URL: `jdbc:h2:mem:editordb`)
   - http://localhost:8080/api/documentos → API REST del CRUD (Clase 3)
   - http://localhost:8080/ → interfaz web del editor (Clase 4)

## Estructura del proyecto

```
mvnw / mvnw.cmd                         (Maven Wrapper — no requiere Maven instalado)
.mvn/wrapper/maven-wrapper.properties
pom.xml
src/main/java/mx/edu/um/editortextosaas/
  ├── EditorTextoSaasApplication.java   (clase principal)
  ├── controller/
  │     ├── HolaController.java         (Clase 1 - endpoint de prueba)
  │     └── DocumentoController.java    (Clase 3 - CRUD REST)
  ├── service/
  │     └── DocumentoService.java       (Clase 3 - lógica de negocio)
  ├── repository/
  │     └── DocumentoRepository.java    (Clase 2 - acceso a datos JPA)
  └── model/
        └── Documento.java              (Clase 2 - entidad)
src/main/resources/
  ├── application.properties            (Clase 2 - configuración H2)
  └── static/index.html                 (Clase 4 - front-end)
```

## Endpoints REST

| Método | URL                          | Descripción                     |
|--------|------------------------------|----------------------------------|
| GET    | /api/status                  | Verifica que el servidor corre   |
| GET    | /api/documentos               | Lista todos los documentos       |
| GET    | /api/documentos/{id}          | Obtiene un documento por id      |
| POST   | /api/documentos               | Crea un documento nuevo          |
| PUT    | /api/documentos/{id}          | Actualiza un documento existente |
| DELETE | /api/documentos/{id}          | Elimina un documento             |
