<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Proyecto_imoraleslosheroes_0"></a>Proyecto imorales-losheroes</h1>
<p class="has-line-data" data-line-start="1" data-line-end="2">API REST Client CRUD</p>
<h2 class="code-line" data-line-start=3 data-line-end=4 ><a id="Utilizacion_3"></a>Utilizacion</h2>
<p class="has-line-data" data-line-start="4" data-line-end="5">La Api se encuentra desplegada en un servicio de Heroku, para acceder a esta se utiliza el siguiente host: <strong><a href="https://imorales-losheroes.herokuapp.com">https://imorales-losheroes.herokuapp.com</a></strong>.</p>
<p class="has-line-data" data-line-start="6" data-line-end="7">Para acceder a los recursos se utilizan las siguientes rutas:</p>
<p class="has-line-data" data-line-start="8" data-line-end="13">
GET    /api/clients     -&gt; Retorna una lista de clientes alojados en la base de datos.<br>
GET    /api/client/{id} -&gt; Retorna un objeto con los datos del cliente.<br>
POST   /api/client      -&gt; Inserta un cliente en la base de datos, Body: <strong>{ “dni”: “…”, “name”: “…”, “lastName”: “…”, “email”: “…” }</strong><br>
PUT    /api/client/{id} -&gt; Modifica los datos de un cliente, Body: <strong>{ “dni”: “…”, “name”: “…”, “lastName”: “…”, “email”: “…” }</strong><br>
DELETE /api/client/{id} -&gt; Elimina un cliente de la base de datos.</p>
<p class="has-line-data" data-line-start="14" data-line-end="15">Coleccion de postman para hacer pruebas: <strong><a href="https://www.getpostman.com/collections/64484b9bb878309af7e9">https://www.getpostman.com/collections/64484b9bb878309af7e9</a></strong></p>
