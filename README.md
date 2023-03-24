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

Ejecución:
- Descargar ejecutable api-usuarios-0.0.1-SNAPSHOT.jar.
- En SO Windows:
	- Escribir cmd en la ventana Buscar y posteriormente hacer clic en Simbolo del Sistema.
	- Con el comando cd llegar al directorio donde se encuentra el jar.
	- Ejecutar el comando java -jar api-usuarios-0.0.1-SNAPSHOT.jar. En este únto se iniciará el servicio. Serán los siguientes mensajes que indicarán que está cargado
		- Tomcat started on port(s): 8001 (http) with context path ''
		- Started ApiUsuariosApplication in 16.958 seconds (JVM running for 20.911)	
- Luego que esté cargado, en la barra de direcciones del navegador web escribir http://localhost:8001/swagger-ui/index.html
