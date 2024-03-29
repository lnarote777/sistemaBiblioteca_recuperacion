package org.example

class RegistroPrestamos {
    companion object{
        private val registroPrestamos = mutableMapOf<Int, Usuario>()
        private val historialPrestamos = mutableListOf<Pair<Int, String>>()
    }

    private val consola = GestorConsola

    fun registrarPrestamo(libro: Libro, usuario: Usuario){
        registroPrestamos[libro.id] = usuario
        historialPrestamos.add(Pair(libro.id, "Prestado"))
    }

    fun devolverLibro(libro: Libro, usuario: Usuario){
        historialPrestamos.add(Pair(libro.id, "Devuelto"))
    }

    fun historialLibro(libro: Libro) {
        val historial = historialPrestamos.filter { it.first == libro.id }
        historial.forEach { println(it) }
    }

    fun historialUsuario(usuario: Usuario){
        val librosPrestados = registroPrestamos.filterValues { it.id == usuario.id }.keys
        if (librosPrestados.isNotEmpty()) {
            consola.mostrarMensaje("Historial del usuario con ID ${usuario.id}:")
            for (libroId in librosPrestados) {
                val historial = historialPrestamos.filter { it.first == libroId }
                historial.forEach { println(it) }
            }
        } else {
            consola.mostrarMensaje("El usuario con ID ${usuario.id} no tiene historial de préstamos.")
        }
    }

}