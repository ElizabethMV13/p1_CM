
<h1># INDICE</h1>


<h2>1. Requerimientos generales</h2>
<h2>2. Elementos extras</h2>



<h1>1. Requerimientos generales</h1>

Realizar una aplicación en Android con el IDE oficial que presente un formulario con los siguientes datos a ingresar: 

Nombre(s) y Apellido(s)
Fecha de nacimiento (pueden usar opcionalmente un DatePicker)
Correo electrónico.
Número de cuenta (9 dígitos)
Carrera (agregar un Spinner con las 15 carreras de la FI). Las pueden obtener del siguiente enlace Carreras FI
A partir de los datos ingresados, se deberá implementar un botón para ver el perfil final del usuario donde se calculará su edad (años cumplidos), su signo zodiacal, su signo con respecto al horóscopo chino, mostrando también una imagen relacionada a la carrera seleccionada.

Deberán presentar la información al usuario (perfil) mediante una interfaz que consideren apropiada.


<h3>Ejemplo de datos a ingresar:</h3>

```

Nombre: Valeria

Apellidos: Ramírez Cervantes.

Fecha de nacimiento: 4-Diciembre-1999

Correo electrónico: valeria@correo.com

Número de cuenta: 123456789

Carrera: Ingeniería Civil
 ```

<h3>RESULTADO:</h3>


 ```

Valeria Ramírez Cervantes

Edad: 23 años cumplidos

Signo zodiacal: Sagitario

Signo horóscopo chino: Conejo

Correo: valeria@correo.com

Número de cuenta: 123456789

Carrera: (imagen relacionada a su carrera)

 ```


<h3>Consideraciones adicionales:</h3>

Al entrar a la aplicación se deberá mostrar un splash screen en donde aparecerá el logo, la versión y el creador de la aplicación por alrededor de 3 segundos.
Se calificará que haya validaciones y/o mensajes de error en todo el formulario (no se puede calcular nada a menos que se ingrese todo “correctamente”).
Pueden definir todos los elementos gráficos y/o de multimedia que deseen para hacer más llamativa la interfaz.
No deben existir cadenas de texto en hard-code.
La aplicación debe estar en por lo menos dos idiomas desde el archivo de recursos de texto (español y otro adicional que prefieran).
El nivel mínimo de API a soportar será el 23.


<h1>2. Elementos extras</h1>


--> Manejo de recyclerView para el uso del target

--> Uso de Clases para el llenado de las recyclerView

Por medio de una clase recupera los datos por medio de un listOf de les da formato y se visualiza en la opción de lisa de carreras

--> Inserción y manejo de audio en MainActivity

El audio se muestra solo en esa ventana, se detiene al cerrar la app o presionar algunos de los botones del menú

--> Se agrego uso de GIFs

Esto se esto se usó en el slash (esto con el fin de no ver una imagen en plano) y dentro de la view que se da en "Quienes somos"

--> Creación de APK

--> Se modifico el icono de la aplicación al descargarla

No pude lograr ver mi app en mis dispositivos para debuggear, por lo que decidí realizar el APK para poder instalarlo y ver que todo funcionara bien

--> Inserción de imágenes por medio de una URL con GLIDE

La imagen que se inserta en la respuesta del formulario es obtenida por internet, solo se necesita la URL 

--> envió y recepción de datos entre vistas por Parcelable implementación generador


