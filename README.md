# api-usuarios
Repositorio Desafío Java
API RESTful de creación de usuarios.
El endpoint debe aceptar y retornar solamente JSON, inclusive al para los mensajes de error.
Todos los mensajes deben seguir el formato:
{
	"mensaje": "mensaje de error"
}
Registro
- Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña",
más un listado de objetos "teléfono", respetando el siguiente formato:
{
	"name": "User Admin",
	"email": "admin@dominio.cl",
	"password": "admin123*",
	"phones": [
		{
			"number": "945390913",
			"cityCode": "1",
			"conutryCode": "56"
		}
	]
}
- Responder el código de status HTTP adecuado
- En caso de éxito, retorne el usuario y los siguientes campos:
	- id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID).
	- created: fecha de creación del usuario.
	- modified: fecha de la última actualización de usuario.
	- last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación).
	- token: token de acceso de la API (puede ser UUID o JWT).
	- isactive: Indica si el usuario sigue habilitado dentro del sistema.
- Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".
- El correo debe seguir una expresión regular para validar que formato sea el correcto. (aaaaaaa@dominio.cl).
- La clave debe seguir una expresión regular para validar que formato sea el correcto. (El valor de la expresión regular debe ser configurable)
- El token deberá ser persistido junto con el usuario.

Herramientas Utilizadas:
- Java 11.
- Spring Boot.
- Maven.
- Eclipse - Spring Tools IDE.
- H2.
- JWT.
- Swagger.

Ejecución:
- Descargar ejecutable "api-usuarios.jar".
- En SO Windows:
	- Escribir cmd en la ventana Buscar y posteriormente hacer clic en Simbolo del Sistema.
	- Con el comando cd llegar al directorio donde se encuentra el jar.
	- Ejecutar el comando "java -jar api-usuarios.jar" para levantar el servicio, serán los siguientes mensajes que indicarán que levantó correctamente
		- Tomcat started on port(s): 8003 (http) with context path ''
		- Started ApiUsuariosApplication in 16.958 seconds (JVM running for 20.911)	
- Luego que esté cargado, en la barra de direcciones del navegador web escribir http://localhost:8003/swagger-ui/index.html.
	- En la página de swagger acceder al tag Usuarios [Usuarios Controllers].
	- Usar el endpoint "Crea Token Acceso" para obtener el token de acceso al resto de los endpoints.
		- El endpoint "Crea Token Acceso" requiere id y contraseña.
	- Para los endpoints restantes debe autorizar mediante el token recibido en el paso anterior. de lo contrario 
	  recibirá error http código 403.
- Para acceder a la BD H2: debe estar arriba el servicio.
	- http://localhost:8003/h2-console/
	- Driver Class: org.h2.Driver
	- JDBC URL: jdbc:h2:mem:testdb
	- User Name: sa
	- Password: sa

Notas: 
- El sistema carga por defecto datos del usuario admin, estas son las credenciales para acceder a crear el token:
	- id: 726ea0dd-9986-38e8-a87f-8e344d373533
	- password: admin123*
- En el directorio "anexos" se encuentra:
	- Ejecutable Jar.
	- Diagrama de la solución.
	- Script de base de datos (para postgresql).

	

