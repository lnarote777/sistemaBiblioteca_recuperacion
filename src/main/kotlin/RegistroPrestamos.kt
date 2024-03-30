package org.example

class RegistroPrestamos : IGestorPrestamos{

    private val registroPrestamos = mutableMapOf<Int, Usuario>()
    private val historialPrestamos = mutableListOf<Pair<Int, String>>()
    private val consola = GestorConsola

    /**
     * Registra un préstamo de un elemento de biblioteca a un usuario.
     * @param elemento El elemento de biblioteca que se presta.
     * @param usuario El usuario al que se presta el elemento.
     */
    override fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario){
        registroPrestamos[elemento.id] = usuario
        historialPrestamos.add(Pair(elemento.id, "Prestado a ${usuario.nombre}"))
    }

    /**
     * Registra la devolución de un elemento de biblioteca por un usuario.
     * @param elemento El elemento de biblioteca que se devuelve.
     * @param usuario El usuario que devuelve el elemento.
     */
    override fun devolucionPrestamos(elemento: ElementoBiblioteca, usuario: Usuario){
        historialPrestamos.add(Pair(elemento.id, "Devuelto por ${usuario.nombre}"))
    }

    /**
     * Muestra el historial de préstamos de un elemento de biblioteca.
     * @param elemento El elemento de biblioteca del que se muestra el historial.
     */
    override fun historialLibro(elemento: ElementoBiblioteca) {
        val historial = historialPrestamos.filter { it.first == elemento.id }
        historial.forEach { println(it) }
    }

    /**
     * Muestra el historial de préstamos de un usuario.
     * @param usuario El usuario del que se muestra el historial de préstamos.
     */
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