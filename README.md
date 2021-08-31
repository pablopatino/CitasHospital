# CitasHospital
Api Rest para creacion de citas

##Instrucciones de uso (Todo lo explicado a continuacion esta configurado en local, con Bd de h2)
***

Para crear un usuario, se deben enviar los suguientes parametros a la url

http://localhost:8080/pacientes/guardar
![image](https://user-images.githubusercontent.com/29610386/131552302-e7513d1b-fcbe-461a-9a4e-0a21849b222d.png)

Para guardar un Doctor, se deben enviar los siguientes parametros a la url

http://localhost:8080/doctores/guardar
![image](https://user-images.githubusercontent.com/29610386/131552065-ce780b25-ed95-43d3-a362-aa03b256cf4c.png)

Para crear una Cita, se deben de pasar la id del usuario por URL:

http://localhost:8080/cita/guardar/{idUsuario}
![image](https://user-images.githubusercontent.com/29610386/131552605-8060d894-b629-4377-a0ba-a21a6f618f12.png)

Pd: Solo se permite una cita por dia, el doctor es asignado aleatoriamente, dependiendo de los doctores que estan activos en el sistema.

***
##Consultar Citas

Los usuarios pueden consultar sus citas, asi la informacion personal.

http://localhost:8080/pacientes/getall/idPaciente

![image](https://user-images.githubusercontent.com/29610386/131553406-9dabf65b-85b0-4455-b45d-a745138bccd2.png)

http://localhost:8080/pacientes/buscar/123
![image](https://user-images.githubusercontent.com/29610386/131553439-ded37b77-017f-4878-99a6-9fbe67ba73cf.png)

La primera imagen representa todas las citas de un paciente, mientras que la segunda muestra la informacion del paciente y el numero de citas totales que tiene.

***

Para los doctores, se usa la suiguiente url
http://localhost:8080/doctores/getall?nombre=Pablo+"Apellido"  (Pd: el nombre se tiene que separar con + ejmp: Santiago+Cabrera+Ramirez)

![image](https://user-images.githubusercontent.com/29610386/131553731-d557a6e6-c5cf-4e4e-b0a7-ceae33629272.png)

La informacion qeu trae, son todas las citas del doctor, con la informacion del paciente correspondiente.

Tambien existe una busqueda para encontrar al doctor por su identificacion:

http://localhost:8080/doctores/buscar/idDoctor

![image](https://user-images.githubusercontent.com/29610386/131553900-dca79e92-5691-4b67-a186-8f1639713b59.png)


***
##Modificacion del estado del Doctor

Los doctores tienen un estado, este significa que si esta activo puede recibir citas, para cambiar el estado de un doctor se utiliza:

http://localhost:8080/doctores/estado

Enviando un body con su identificacion
![image](https://user-images.githubusercontent.com/29610386/131554167-cbfa12cd-f2d6-462e-bf83-a847767aafed.png)

***
##Eliminacion de citas.

Se puede eliminar las citas, sabiendo la identificacion de la cita

http://localhost:8080/cita/eliminar/idCita




