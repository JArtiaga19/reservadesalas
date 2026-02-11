package com.jesus.reservasalasapi.controlador;

public class ControladorContexto {

    private static final ThreadLocal<String> tipoEsperado = new ThreadLocal<>(); // usuarios, salas o reservas
    private static final ThreadLocal<String> jsonEnviado = new ThreadLocal<>(); // JSON enviado por el usuario

    // Guardar el tipo esperado (usuarios, salas, reservas)
    public static void setTipoEsperado(String tipo) {
        tipoEsperado.set(tipo);
    }

    // Obtener el tipo esperado
    public static String getTipoEsperado() {
        return tipoEsperado.get();
    }

    // Guardar el JSON enviado por el usuario
    public static void setJsonEnviado(String json) {
        jsonEnviado.set(json);
    }

    // Obtener el JSON enviado por el usuario
    public static String getJsonEnviado() {
        return jsonEnviado.get();
    }

    // Limpiar después de cada petición
    public static void limpiar() {
        tipoEsperado.remove();
        jsonEnviado.remove();
    }

}

