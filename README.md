# PencaUyCentral
TSE 2018 Proyecto PencaUy Servidor Central

Proyecto creado por 
Yamandú Alvarez
Hector Alfonso
Fernando Guarisco
Leonardo Manzuetti
Marcos Viera

Instalación
===========

Pre-requisitos
==============
1. JDK y JRE en su versión 1.8
2. IDE Eclipse
3. Servidor de aplicaciones WildFly 10
4. DBMS PostgreSQL

Configuraciones
===============
1. Vamos a configurar la base de datos
1.1. Abrimos PostgreSQL y creamos la base de datos PencaUyCentral

2. Vamos a configurar el servidor de aplicaciones Wildfly
2.1. Abrir el archivo add-users.bat (Windows) / add-users.sh (Linux) desde la consola/terminal
2.1.1. La ruta del archivo por lo general esta en .../wildfly-{version}.final/bin/
2.2. Crear un usuario para administrar del servidor de aplicaciones desde la web/consola
2.2.1. Seleccionar la opcion a) Management User
2.2.2. Digitar el nombre de usuario
2.2.3. Digitar la contraseña
2.2.3.1. En caso de no poseer mas de 8 caracteres digitar "yes" a la siguiente pregunta
2.2.4. Repetir la contraseña
2.2.5. Presionar la tecla Enter
2.2.6. Digitar "yes"
2.2.7. Digitar "yes"
2.2.8. Presionar la tecla Enter
2.3. Iniciar el servidor Wildfly ejecutando el archivo standalone.bat (Win) / standalone.sh (Linux)
2.4. Abrir el navegador y acceder a la URL: http://localhost:8080/ (Web de nuestro servidor Wildfly)
2.4.1. Hacer click en "Administration Console"
2.4.2. Iniciar sesion con nuestro usuario recien creado
2.4.3. Descargamos el driver de PostgreSQL y lo alojamos en la carpeta deployments
2.4.4. En la web accedemos a la pestaña Deployments y agregamos PostgreSQL a nuestro wildfly
2.4.5. Despues creamos el datasource CentralDS
2.4.5.1 Para crearlo accedemos a Configuration/Subsystem/Datasources/Non-XA
2.4.5.2 Hacemos click en el boton Add para crearlo
2.4.6 Una vez creado el datasource probamos la conexion desde el servidor con la base de datos

Guia de Instalación
===================
1. Descargar el proyecto de la web https://github.com/gityalvarez/PencaUyCentral.git
2. Descomprimir el archivo .zip
3. Abrir el IDE Eclipse e importar el proyecto
4. Hacer click sobre el proyecto y acceder Maven Update para que se actualicen las dependencias
5. Instanciar el servidor de aplicaciones que configuramos en Eclipse
6. Agregar el proyecto al servidor de aplicaciones
7. Iniciar el servidor desde Eclipse
