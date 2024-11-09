# price-api-hexagonal (NO MODULAR) - API REST para Gestión de Tarifas de Precios

Este proyecto implementa un controlador REST para consultar las tarifas de precios de productos en función de diferentes parámetros. La arquitectura utilizada es **hexagonal**, y la aplicación está construida sobre **Spring Boot** con **H2** como base de datos en memoria para simplificar las pruebas y la persistencia de datos durante la ejecución.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para construir la API REST.
- **H2 Database**: Base de datos en memoria para almacenar los datos temporalmente.
- **Arquitectura Hexagonal (Ports and Adapters)**: Permite una separación clara entre la lógica de negocio y las implementaciones externas.
- **Lombok**: Para simplificar la implementación de las entidades y DTOs.
- **Swagger** (opcional): Para documentación interactiva de la API.

## Arquitectura Hexagonal

La arquitectura hexagonal permite organizar el código en capas independientes, lo que facilita su mantenimiento y pruebas. En este proyecto, la lógica de negocio está separada en **puertos** (interfaces) y **adaptadores** (implementaciones de esas interfaces). El controlador actúa como un adaptador de entrada que interactúa con los casos de uso y las capas de dominio sin acoplarse a detalles de implementación específicos.

## Endpoints del Controlador

Este controlador expone el siguiente endpoint:

| Método HTTP | Endpoint                | Descripción                                                                                                                                                           |
|-------------|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `GET`       | `/prices/findByParameters` | Consultar la tarifa aplicable a un producto específico en función de la fecha de aplicación, el ID del producto y el ID de la marca. |

### Detalle del Endpoint

#### 1. Consultar tarifa aplicable para un producto en una fecha específica

- **Método HTTP**: `GET`
- **URL**: `/prices/findByParameters`
- **Descripción**: Este endpoint devuelve la tarifa de precio aplicable a un producto específico en función de la fecha de aplicación, el ID del producto y el ID de la marca.
- **Parámetros de Consulta**:
  - `brandId`: ID de la marca (requerido).
  - `productId`: ID del producto (requerido).
  - `applicationDate`: Fecha y hora en el formato `yyyy-MM-dd-HH.mm.ss` (requerido).



Created by DARWIN ROCHA
