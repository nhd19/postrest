# Postrest - Web Service SOAP + REST

Proyecto de demostración que implementa un **Web Service Dual** (SOAP + REST) usando Spring Boot que puede ser consumido tanto por **SoapUI** como por **Postman**.

## 📋 Estructura del Proyecto

```
postrest/
├── src/
│   ├── main/
│   │   ├── java/com/example/webservice/
│   │   │   ├── PostrestApplication.java          # Clase principal
│   │   │   ├── WebServiceFacade.java            # Servicio dual SOAP + REST
│   │   │   ├── SumaRequest.java                 # Modelo de request
│   │   │   ├── SumaResponse.java                # Modelo de response
│   │   │   └── CxfConfig.java                   # Configuración SOAP
│   │   └── resources/
│   │       └── application.properties             # Configuración de la aplicación
│   └── test/
├── pom.xml                                        # Dependencias Maven
└── README.md                                      # Este archivo
```

## 🚀 Instalación

### Requisitos
- Java 17+
- Maven 3.6+
- SoapUI (para pruebas SOAP)
- Postman (para pruebas REST)

### Pasos de instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/nhd19/postrest.git
cd postrest
```

2. **Compilar el proyecto:**
```bash
mvn clean install
```

3. **Ejecutar la aplicación:**
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 📡 Consumir el servicio en SoapUI

### Paso 1: Crear nuevo proyecto SOAP
1. Abre **SoapUI**
2. Haz clic en `File` → `New SOAP Project`
3. En el campo "Initial WSDL", ingresa:
   ```
   http://localhost:8080/soap?wsdl
   ```
4. Haz clic en `OK`

### Paso 2: Ver operaciones disponibles
El proyecto se creará con las operaciones SOAP disponibles. Verás en el panel izquierdo:
- `soapMethod` - Método SOAP de prueba

### Paso 3: Crear y enviar una solicitud
1. Expande el árbol de operaciones
2. Haz doble clic en `soapMethod`
3. Se abrirá un editor con plantilla SOAP
4. Modifica el request con tu entrada
5. Presiona el botón verde de "Play" para enviar

**Ejemplo de request SOAP:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                   xmlns:web="http://webservice.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <web:soapMethod>
         <arg0>Hola Mundo</arg0>
      </web:soapMethod>
   </soapenv:Body>
</soapenv:Envelope>
```

## 🔌 Consumir el servicio en Postman

### Paso 1: Crear nueva solicitud
1. Abre **Postman**
2. Haz clic en el botón `+` para crear una nueva pestaña
3. Selecciona el método `GET`

### Paso 2: Solicitud REST GET
**URL:**
```
http://localhost:8080/api/webservice/hello/Juan
```

**Pasos:**
1. Pega la URL en el campo de dirección
2. Haz clic en `Send`
3. Recibirás la respuesta en JSON

### Paso 3: Solicitud REST POST
1. Cambia el método a `POST`
2. **URL:**
   ```
   http://localhost:8080/api/webservice/sumar
   ```

3. Ve a la pestaña `Body`
4. Selecciona `raw` → `JSON`
5. Ingresa:
   ```json
   {
     "num1": 5,
     "num2": 3
   }
   ```

6. Haz clic en `Send`

**Response esperado:**
```json
{
  "sum": 8,
  "message": "Operación exitosa"
}
```

## 📝 Endpoints disponibles

### SOAP Endpoints
| Método | URL |
|--------|-----|
| `soapMethod` | `http://localhost:8080/soap` |
| WSDL | `http://localhost:8080/soap?wsdl` |

### REST Endpoints
| Método HTTP | Endpoint | Descripción |
|-------------|----------|-------------|
| GET | `/api/webservice/hello/{name}` | Saluda al usuario |
| POST | `/api/webservice/sumar` | Suma dos números |

## 🛠️ Estructura de Archivos Importantes

### WebServiceFacade.java
Contiene tanto la anotación @WebService (SOAP) como @RestController (REST) para permitir ambos tipos de solicitudes.

### SumaRequest.java
Modelo que recibe dos números (num1, num2) para sumarlos.

### SumaResponse.java
Modelo que devuelve la suma y un mensaje de confirmación.

## 🔧 Configuración

### application.properties
```properties
# Puerto del servidor
server.port=8080

# Configuración SOAP
soap.endpoint=http://localhost:8080/soap
soap.timeout=5000
```

## 📚 Dependencias principales

- **Spring Boot Starter Web** - Para crear REST APIs
- **Spring Boot Starter SOAP** - Para servicios SOAP
- **Apache CXF** - Framework SOAP/REST

## ✅ Verificación

### Verificar que el servicio está activo

```bash
# Verificar REST
curl http://localhost:8080/api/webservice/hello/Test

# Verificar SOAP WSDL
curl http://localhost:8080/soap?wsdl
```

## 🐛 Troubleshooting

### El puerto 8080 ya está en uso
Cambia el puerto en application.properties:
```properties
server.port=9090
```

### El servicio SOAP no aparece en SoapUI
1. Asegúrate de que la aplicación está corriendo
2. Intenta limpiar el caché de SoapUI
3. Usa la URL completa: http://localhost:8080/soap?wsdl

### Error de validación XML en SoapUI
Verifica que tu request SOAP esté bien formado y que incluya el namespace correcto.

## 📞 Soporte

Si encuentras problemas, crea un issue en el repositorio.

## 📄 Licencia

Este proyecto está disponible bajo la licencia MIT.

---

**¡Listo!** Tu web service SOAP + REST está completamente configurado y listo para usar.