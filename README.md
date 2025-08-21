# Laboratorio 2 - CVDS (DOSW)

Este repositorio contiene el código fuente y los recursos del Laboratorio 2 para la asignatura CVDS (Diseño Orientado a Software) en el curso DOSW.

## Resumen

Proyecto de ejemplo orientado a patrones de diseño y buenas prácticas en Java. Contiene paquetes organizados por categorías (comportamentales, creacionales, estructurales, SOLID) y utilidades.

## Contenido principal

- `src/main/java/edu/dosw/lab/` - Código fuente Java del laboratorio.
- `docs/uml/` - Diagramas UML usados en el laboratorio.
- `docs/imagenes/` - Imágenes y recursos gráficos.
- `HELP.md` - Notas y descubrimientos importantes durante la construcción del proyecto.

## Nota importante del proyecto

El archivo `HELP.md` contiene una observación relevante: el nombre de paquete original `edu.dosw.lab.Laboratorio-2-CVDS-DOSW-01` es inválido en Java y en este repositorio se usa `edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01` (con guiones bajos). Si vas a cambiar el paquete padre o el POM, revisa esa modificación para evitar conflictos.

## Requisitos

- Java JDK 11+ (o la versión que indique el POM del proyecto)
- Apache Maven 3.6+
- IDE recomendado: IntelliJ IDEA / Eclipse / VS Code con extensiones Java

## Comandos útiles (PowerShell)

Compilar y empaquetar el proyecto:

```powershell
mvn clean package
```

Ejecutar pruebas unitarias:

```powershell
mvn test
```

Actualizar dependencias y verificar el árbol de dependencias:

```powershell
mvn dependency:tree
```

Si el proyecto requiere generar una imagen OCI (Spring Boot con plugin de build-image):

```powershell
mvn spring-boot:build-image
```

> Observación: los comandos asumen que Maven y Java están instalados y accesibles desde PowerShell.

## Estructura del paquete

El código está organizado por paquetes bajo `edu.dosw.lab` y subdividido en carpetas según el tipo de patrón o contenido:

- `comportamentales/` - Implementaciones de patrones comportamentales.
- `creacionales/` - Implementaciones de patrones creacionales.
- `estructurales/` - Implementaciones de patrones estructurales.
- `solid/` - Ejemplos relacionados con principios SOLID.
- `util/` - Clases utilitarias compartidas.

## Cómo contribuir

1. Crea una rama nueva con un nombre descriptivo.
2. Realiza cambios y añade pruebas cuando corresponda.
3. Abre un Pull Request describiendo los cambios y su motivación.

## Notas sobre POM y herencia

El `HELP.md` menciona que el POM del proyecto anuló elementos heredados del POM padre (por ejemplo, `<license>` y `<developers>`) mediante sobreescrituras vacías para evitar heredar contenido no deseado. Si cambias el POM padre y deseas heredar esos elementos, elimina las anulaciones vacías en el POM del proyecto.

## Recursos y documentación

- Documentación de Maven: https://maven.apache.org/guides/index.html
- Plugin Maven de Spring Boot: https://docs.spring.io/spring-boot

## Licencia

Incluye o actualiza la licencia según las políticas del curso o de tu organización. Si no hay una licencia definida, asume que el repositorio es para uso académico privado.

## Contacto

Para dudas relacionadas con el laboratorio, contacta al profesor o al equipo de curso; para cuestiones del código, abre un issue en el repositorio.

---

Archivo generado automáticamente a partir del contenido del repositorio y `HELP.md`.
