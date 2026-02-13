package com.jesus.reservasalasapi.controlador;

public class ControladorContexto {

    // Guarda el tipo de recurso esperado para esta petición (usuarios, salas o reservas)
    private static final ThreadLocal<String> tipoEsperado = new ThreadLocal<>();

    // Establece el tipo esperado detectado por el interceptor
    public static void setTipoEsperado(String tipo) {
        tipoEsperado.set(tipo);
    }

    // Obtiene el tipo esperado para esta petición
    public static String getTipoEsperado() {
        return tipoEsperado.get();
    }

    // Limpia el valor almacenado al finalizar la petición
    public static void limpiar() {
        tipoEsperado.remove();
    }
}

/*
 * Esta clase guarda temporalmente el tipo de recurso que se espera en la
 * petición
 * (usuarios, salas o reservas). Cada petición tiene su propio espacio gracias a
 * ThreadLocal.
 * El interceptor pone el tipo, los controladores lo leen y al final se limpia.
 * Sirve para evitar que envíes datos del tipo equivocado a una ruta.
 */
