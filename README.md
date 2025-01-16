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

    - [Funcionalidades del proyecto](#funcionalidades-del-proyecto)

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
5. **Eliminar un tópico**: Elimina un tópico pasando el id como parámetro en la URI.
6. **Conexión a la base de datos**: Toda la información se guarda en una base de datos de MySQL.

    ⚠️ Importante: Es necesario crear la base de datos y modificar el archivo application.properties. Esto es para que se conecte la aplicación a la base de datos.
    Se deben modificar las siguientes variables por las variables que tu tengas:

    `${DATASOURCE_URL}, ${DATASOURCE_USERNAME}, ${DATASOURCE_PASSWORD} y ${JWT_SECRET}`

    En DATASOURCE_URL debe estar de esta forma: `jdbc:mysql://localhost:puerto que use)/(nombre de la base de datos)`.
    
    En DATASOURCE_USERNAME debe ser por defecto root o el que se introdujo al instalar MySQL Workbench.

    En DATASOURCE_PASSWORD debe ser la contraseña que se introdujo al instalar MySQL Workbench.

    Y en JWT_SECRET es la contraseña que se usa para el inicio de sesión.

Se deben modificar las siguientes variables por las variables que tu tengas:
7. **Respuestas con códigos HTTP**: Al realizar alguna operación CRUD en Postman o Insomnia, muestra su código HTTP correcto, por ejemplo, al crear un tópico devuelve 201, si no existe un tópico devuelve 404, etc.
8. **Seguridad en operaciones CRUD**: La aplicación tiene Spring Security para que los usuarios que no iniciaron sesión no puedan usar las operaciones CRUD.
9. **Inicio de sesión (Login)**: Inicia sesión ingresando el nombre de usuario y la contraseña, y al enviarlos devuelve un JWT Token con el cual podrá usar las operaciones CRUD.

    ⚠️ Importante: Es necesario introducir la información del usuario en la base de datos para realizar correctamente el login. Y para introducir la contraseña encriptada se debe usar la siguiente página: [Bcrypt Encrypt](https://www.browserling.com/tools/bcrypt), donde dice Password introduce la contraseña a usar, dar click en Bcrypt y en el campo cuadrado mostrará dicha contraseña ya encriptada.

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
- Postman o Insomnia Rest para la simulación del cliente
- MySQL Workbench

# Persona Desarrolladora del Proyecto 💻

[<img src="https://avatars.githubusercontent.com/u/107082359?v=4" width=115><br><sub>Sergio Zuñiga Fraga</sub>](https://github.com/SergioZF09)

# Agradecimientos

Agradezco a los Instructores Diego Rojas y Bruno Darío Fernández Ellerbach de Alura Latam junto con Oracle por haber creado un reto interesante y en donde pude aplicar todo lo aprendido en la formación Java y Spring Boot.
