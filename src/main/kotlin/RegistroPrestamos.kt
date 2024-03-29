package org.example

class RegistroPrestamos : IGestorPrestamos{

    private val registroPrestamos = mutableMapOf<Int, Usuario>()
    private val historialPrestamos = mutableListOf<Pair<Int, String>>()
    private val consola = GestorConsola

    override fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario){
        registroPrestamos[elemento.id] = usuario
        historialPrestamos.add(Pair(elemento.id, "Prestado a ${usuario.nombre}"))
    }

    override fun devolucionPrestamos(elemento: ElementoBiblioteca, usuario: Usuario){
        historialPrestamos.add(Pair(elemento.id, "Devuelto por ${usuario.nombre}"))
    }

    override fun historialLibro(elemento: ElementoBiblioteca) {
        val historial = historialPrestamos.filter { it.first == elemento.id }
        historial.forEach { println(it) }
    }

    override fun historialUsuario(usuario: Usuario){
        val elementosPrestados = registroPrestamos.filterValues { it.id == usuario.id }.keys
        if (elementosPrestados.isNotEmpty()) {
            consola.mostrarMensaje("Historial del usuario con ID ${usuario.id}:")
            for (elementoId in elementosPrestados) {
                val historial = historialPrestamos.filter { it.first == elementoId }
                historial.forEach { println(it) }
            }
        } else {
            consola.mostrarMensaje("El usuario con ID ${usuario.id} no tiene historial de préstamos.")
        }
    }

}