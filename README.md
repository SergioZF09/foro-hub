<h1>💬 ForoHub API Rest 💬</h1>

# Insignias

<div align="center">
    <img src="https://img.shields.io/badge/Estado-En desarrollo-green">
    <img src="https://img.shields.io/badge/Java-v17-blue">
    <img src="https://img.shields.io/badge/Framework-Spring Boot 3-green">
    <img src="https://img.shields.io/badge/Base de Datos-MySQL-blue">
    <img src="https://img.shields.io/badge/ORM-Hibernate-blue">
    <img src="https://img.shields.io/badge/Autenticación-JWT-blue">
    <img src="https://img.shields.io/badge/Versión-v1.0.0-green">
</div>

# Índice

- [Insignias](#insignias)

- [Descripción del proyecto](#descripción-del-proyecto)

- [Estado del proyecto](#estado-del-proyecto)

- [Demostración de funcionalidades](#demostración-de-funcionalidades)

    - [Funcionalidades del proyecto](#funcionalidades-del-proyecto-🔧)

    - [Uso del proyecto](#uso-del-proyecto)

- [Acceso al proyecto](#acceso-al-proyecto)

- [Teconologías utilizadas](#teconologías-utilizadas)

- [Persona Desarrolladora del Proyecto](#persona-desarrolladora-del-proyecto)

# Descripción del proyecto 📄

¡Bienvenido/a a ForoHub!
Es una aplicación API Rest CRUD en la que puedes crear un tópico, leer todos los tópicos creados, leer un tópico en específico, actualizar algún datos de un tópico y eliminar un tópico, con tópico me refiero a una duda de algún tema en específico, los tópicos se guardan en una base de datos el cual es MySQL Workbench, ya que usa Flyway Migration para controlar las versiones de consultas con archivos SQL. 
Se debe usar alguna herramienta/aplicación como Postman o Insomnia Rest para simular las solicitudes (requests) y respuestas (responses) de un cliente a la API y de la API a la base de datos con los verbos HTTP: Create para crear, GET para leer, PUT para actualizar y DELETE para eliminar, y para las operaciones CRUD se usa el formato JSON.

# Estado del proyecto

✅ Proyecto completado.

# Demostración de funcionalidades

## Funcionalidades del proyecto 🔧

1. **Registrar tópico**: Registra en la base de datos un tópico con los siguientes datos: título, mensaje, fecha de creación, estado, autor y curso.

    ⚠️ Importante: no puede haber registros de tópicos duplicados (con el mismo título y mensaje).

2. **Listar tópicos**: Muestra todos los tópicos que fueron registrados en la base de datos.
3. **Listar un tópico**: Muestra sólo un tópico pasando el id como parámetro en la URI.
4. **Actualizar un tópico**: Actualiza uno o varios datos de un tópico y no permite que los datos estén vacíos o nulos. Se debe usar el id en el body de Postman o Insomnia Rest para realizar la actualización.
También sucede como en Registrar tópico de que no acepta datos de tópicos duplicados.
5. **Eliminar un tópico**: Elimina un tópico pasando el id como parámetro en la URI.
6. **Conexión a la base de datos**: Toda la información se guarda en una base de datos de MySQL.
7. **Respuestas con códigos HTTP**: Al realizar alguna operación CRUD en Postman o Insomnia, muestra su código HTTP correcto, por ejemplo, al crear un tópico devuelve 201, si no existe un tópico devuelve 404, etc.
8. **Seguridad en operaciones CRUD**: La aplicación tiene Spring Security para que los usuarios que no iniciaron sesión no puedan usar las operaciones CRUD.
9. **Inicio de sesión (Login)**: Inicia sesión ingresando el nombre de usuario y la contraseña, y al enviarlos devuelve un JWT Token con el cual podrá usar las operaciones CRUD.

    ⚠️ Importante: Es necesario introducir la información del usuario en la base de datos para realizar correctamente el login. Y para introducir la contraseña encriptada se debe usar la siguiente página: [Bcrypt Encrypt](https://www.browserling.com/tools/bcrypt), donde dice Password introduce la contraseña a usar, dar click en Bcrypt y en el campo cuadrado mostrará dicha contraseña ya encriptada.

10. **Documentación de la API Rest ForoHub**: Incluye una documentación para probar su funcionamiento usando Spring Doc con Swagger. De igual forma, para usar las operaciones CRUD hay que hacer login.

## Uso del Proyecto

**Login**: Para iniciar sesión es necesario registrar al usuario desde la base de datos usando el siguiente comando, sustituyendo los valores por otros y la contraseña hasheada en la página Bcrypt Encrypt:
`INSERT INTO usuarios (nombre, correo_electronico, contrasena) VALUES ('carlos.garcia', 'carlos.garcia@gmail.com', '123456');`

Para la ruta `http://localhost:8080/login` usando el verbo POST se usa el siguiente ejemplo:
````
{
  "nombre": "string",
  "contrasena": "string"
}
````

**Registrar Tópico**: Para registrar un tópico se usa en la ruta `http://localhost:8080/topicos` con el verbo POST y con la siguiente estructura JSON como ejemplo:
````
{
  "titulo": "string",
  "mensaje": "string",
  "fechaCreacion": "2025-01-24T01:06:20.582Z",
  "estado": "string",
  "autor": "string",
  "curso": "string"
}
````

**Listar Tópicos**: Para mostrar todos los tópicos se usa la ruta `http://localhost:8080/topicos` con el verbo GET y todos los tópicos se muestra con la misma estructura JSON como en Registrar Tópico.

**Listar un Tópico**: Para mostrar un tópico se usa la ruta `http://localhost:8080/topicos/{id}` con el verbo GET y con el id del tópico en específico, y como resultado dicho tópico se muestra con la misma estructura JSON como en Registrar Tópico.

**Actualizar un Tópico**: Para actualizar un tópico se usa la ruta `http://localhost:8080/topicos` con el verbo PUT, copiando un tópico registrado y pegándolo en el body de la herramienta para simular el cliente. Se puede modificar cualquier dato del tópico, menos el id ya que es un número único y también no se puede duplicar algún dato de un tópico registrado.

**Eliminar un Tópico**: Para eliminar un tópico se usa la ruta `http://localhost:8080/topicos/{id}` con el verbo DELETE, y con el id del tópico en específico, y como resultado dicho tópico se elimina de la base de datos. Ese tópico eliminado no se mostrará en las rutas para mostrar tópicos y mostrar un tópico.

# Acceso al Proyecto

1. Crear sólo la base de datos en MySQL Workbench
2. Crear una carpeta y clonar el repositorio en la terminal o en Git Bash con el siguiente comando:

    `git clone https://github.com/SergioZF09/foro-hub.git`

3. Ir a dicha carpeta y abrirla con el IDE preferido (por ejemplo IntelliJ IDEA)
4. Configurar el archivo application.properties para que se conecte la aplicación a la base de datos.

    Se deben modificar las siguientes variables por las variables que tu tengas:

    `${DATASOURCE_URL}, ${DATASOURCE_USERNAME}, ${DATASOURCE_PASSWORD} y ${JWT_SECRET}`

    En DATASOURCE_URL debe estar de esta forma: `jdbc:mysql://localhost:puerto que use)/(nombre de la base de datos)`.
    
    En DATASOURCE_USERNAME debe ser por defecto root o el que se introdujo al instalar MySQL Workbench.

    En DATASOURCE_PASSWORD debe ser la contraseña que se introdujo al instalar MySQL Workbench.

    Y en JWT_SECRET es la contraseña que se usa para el inicio de sesión.

5. Y por último inicar el proyecto para que arranque el servidor y puedas usarlo con Postman o Insomnia Rest.
6. Para usar la documentación Swagger puedes acceder al siguiente enlace:
`http://localhost:8080/swagger-ui/index.html`

# Teconologías utilizadas 🔨

- Java 17
- Spring Boot 3
- Maven
- Spring Web
- Spring Data JPA
- Spring Boot DevTools
- Lombok
- Flyway Migration
- Validation
- Spring Security
- Spring Doc
- Postman o Insomnia Rest para la simulación del cliente
- MySQL Workbench

# Persona Desarrolladora del Proyecto 💻

[<img src="https://avatars.githubusercontent.com/u/107082359?v=4" width=115><br><sub>Sergio Zuñiga Fraga</sub>](https://github.com/SergioZF09)

# Agradecimientos

Agradezco a los Instructores Diego Rojas y Bruno Darío Fernández Ellerbach de Alura Latam junto con Oracle por haber creado un reto interesante y en donde pude aplicar todo lo aprendido en la formación Java y Spring Boot.
