# Proyecto imorales-losheroes
API REST Client CRUD

## Utilizacion
_La Api se encuentra desplegada en un servicio de Heroku, para acceder a esta se utiliza el siguiente host: **https://imorales-losheroes.herokuapp.com**.

_Para acceder a los recursos se utilizan las siguientes rutas:

GET    /api/clients     -> Retorna una lista de clientes alojados en la base de datos.
GET    /api/client/{id} -> Retorna un objeto con los datos del cliente.
POST   /api/client      -> Inserta un cliente en la base de datos, Body: **{ "dni": "...", "name": "...", "lastName": "...", "email": "..." }**
PUT    /api/client/{id} -> Modifica los datos de un cliente, Body: **{ "dni": "...", "name": "...", "lastName": "...", "email": "..." }**   
DELETE /api/client/{id} -> Elimina un cliente de la base de datos.

_Coleccion de postman para hacer pruebas: **https://www.getpostman.com/collections/64484b9bb878309af7e9**