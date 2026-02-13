Config TipoEsperadoInterceptor & WebConfig
-----------------------------------

1) TipoEsperadoInterceptor
2) WebConfig

¿Qué hacen juntos?

WebConfig le dice a Spring:
"Oye, usa este interceptor en todas las peticiones."

TipoEsperadoInterceptor: cada vez que llega una petición,
mira la URL y apunta qué tipo de cosa estás pidiendo:

/usuarios  -> apunta "usuarios"
/salas     -> apunta "salas"
/reservas  -> apunta "reservas"

¿Para qué sirve esto?

Para que luego, en los controladores, puedas saber
qué tipo de datos debería haber mandado el cliente.

Es como:

WebConfig = activa el portero.
Interceptor = el portero que mira por qué puerta entras.

No cambia nada del body.
No modifica la petición.
No toca la lógica.
Solo mira la URL y apunta el tipo.

Sen encarga de que si tratas de enviar una informacion tipo usuario a sala pues no lo permita y te diga eehh esto aqui no va vuleve a escribirlo