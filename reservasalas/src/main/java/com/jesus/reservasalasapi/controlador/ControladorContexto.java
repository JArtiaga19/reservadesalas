package com.jesus.reservasalasapi.controlador;

public class ControladorContexto {

    // 1.
    private static final ThreadLocal<String> tipoEsperado = new ThreadLocal<>();

    // 2.
    public static void setTipoEsperado(String tipo) {
        tipoEsperado.set(tipo);
    }

    // 3.
    public static String getTipoEsperado() {
        return tipoEsperado.get();
    }

    // 4.
    public static void limpiar() {
        tipoEsperado.remove();
    }
}

/*
1. Guarda el tipo de recurso esperado en esta petición (usuarios, salas o reservas)
2. Guardar el tipo esperado
3. Obtener el tipo esperado
4. Limpiar después de cada petición

 * Esta clase actúa como un “almacén temporal” que guarda información específica de cada petición mientras se está procesando. Usa ThreadLocal, lo que significa
 * que cada petición tiene su propio espacio aislado y no se mezcla con otras.
 *
 * Su función principal es guardar el tipo de recurso que el interceptor detecta (usuarios, salas o reservas) para que los controladores puedan validar si el
 * cliente está enviando los datos correctos.
 *
 * Antes también guardaba el JSON enviado por el usuario, pero esa parte ya no se usa en la aplicación actual. Aun así, la estructura
 * sigue permitiendo guardar y limpiar datos por petición.
 *
 * Al final de cada petición, se debe llamar a limpiar() para borrar los datos almacenados y evitar que se mezclen con otras peticiones.
 * 
 * Resumen:
 * Guarda temporalmente el tipo de recurso de cada petición (usuarios, salas o reservas). Cada petición tiene su propio espacio y se limpia al terminar.
*/
