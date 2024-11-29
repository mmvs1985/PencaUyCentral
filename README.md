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
--------------------------------------
1. Abrimos PostgreSQL y creamos la base de datos PencaUyCentral

2. Vamos a configurar el servidor de aplicaciones Wildfly
---------------------------------------------------------
1. Abrir el archivo add-users.bat (Windows) / add-users.sh (Linux) desde la consola/terminal
2. La ruta del archivo por lo general esta en .../wildfly-{version}.final/bin/
3. Crear un usuario para administrar del servidor de aplicaciones desde la web/consola
4. Seleccionar la opcion a) Management User
5. Digitar el nombre de usuario
6. Digitar la contraseña
7. En caso de no poseer mas de 8 caracteres digitar "yes" a la siguiente pregunta
8. Repetir la contraseña
9. Presionar la tecla Enter
10. Digitar "yes"
11. Digitar "yes"
12. Presionar la tecla Enter
13. Iniciar el servidor Wildfly ejecutando el archivo standalone.bat (Win) / standalone.sh (Linux)
14. Abrir el navegador y acceder a la URL: http://localhost:8080/ (Web de nuestro servidor Wildfly)
15. Hacer click en "Administration Console"
16. Iniciar sesion con nuestro usuario recien creado
17. Descargamos el driver de PostgreSQL y lo alojamos en la carpeta deployments
18. En la web accedemos a la pestaña Deployments y agregamos PostgreSQL a nuestro wildfly
19. Despues creamos el datasource CentralDS
20. Para crearlo accedemos a Configuration/Subsystem/Datasources/Non-XA
21. Hacemos click en el boton Add para crearlo
22. Una vez creado el datasource probamos la conexion desde el servidor con la base de datos

Guia de Instalación
===================
1. Descargar el proyecto de la web https://github.com/gityalvarez/PencaUyCentral.git
2. Descomprimir el archivo .zip
3. Abrir el IDE Eclipse e importar el proyecto
4. Hacer click sobre el proyecto y acceder Maven Update para que se actualicen las dependencias
5. Instanciar el servidor de aplicaciones que configuramos en Eclipse
6. Agregar el proyecto al servidor de aplicaciones
7. Iniciar el servidor desde Eclipse
