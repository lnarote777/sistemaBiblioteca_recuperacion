package org.example

class Menu(
    private val biblioteca : GestorBiblioteca,
    private val registroPrestamos: RegistroPrestamos,
    private val catalogo: IGestorCatalogo,
    private val gestorElementos: GestorElementos<ElementoBiblioteca>)
{
    private val consola = GestorConsola
    private val gestorUsuario = GestorUsuario()

    /**
     * Muestra el menú de opciones disponibles para el sistema de gestión de una biblioteca.
     */
    private fun mostrarMenu(){
        consola.mostrarMensaje("1. Agregar elemento\n2. Eliminar elemento\n3. Prestar elemento\n4. Devolver elemento\n5. Comprobar disponibilidad elemento\n6. Mostrar catálogo\n7. Mostrar prestamos usuario\n8. Mostrar historial prestamos elemento\n9. Mostrar historial prestamos usuario\n0. Salir")
    }

    /**
     * Función que representa el menú de opciones para el sistema de gestión de una biblioteca.
     */
    fun menu(){
        while (true){
            consola.mostrarMensaje("")
            consola.mostrarMensaje("Elige una opción:")
            mostrarMenu()
            val opcion = consola.pedirOpcion()
            when(opcion){
                "1" -> biblioteca.agregarElementoCatalogo()
                "2" -> {
                    catalogo.mostrarElementosDisponibles()
                    val id = consola.pedirId()
                    biblioteca.eliminarElementoCatalogo(id)
                }
                "3" -> {
                    catalogo.mostrarElementosDisponibles()
                    val id = consola.pedirId()
                    if (gestorUsuario.usuarioExistente()){
                        gestorUsuario.mostrarUsuarios()
                        val idUsuario = consola.pedirId()
                        val usuario = gestorUsuario.buscarUsuario(idUsuario)
                        if (usuario != null) {
                            biblioteca.prestarElemento(id, usuario)
                        }
                    }else{
                        val usuario = gestorUsuario.agregarUsuario()
                        biblioteca.prestarElemento(id, usuario)
                    }

                }
                "4" -> {
                    catalogo.mostrarElementosPrestados()
                    val id = consola.pedirId()
                    if (gestorUsuario.usuarioExistente()){
                        gestorUsuario.mostrarUsuarios()
                        val idUsuario = consola.pedirId()
                        val usuario = gestorUsuario.buscarUsuario(idUsuario)
                        if (usuario != null) {
                            biblioteca.devolverElemento(id, usuario)
                        }
                    }else{
                        consola.mostrarMensaje("No tiene libros para devolver.")
                    }
                }
                "5" -> {
                    catalogo.mostrarCatalogo()
                    val id = consola.pedirId()
                    biblioteca.disponibilidad(id)
                }
                "6" -> {
                    catalogo.mostrarTodo()
                }
                "7" -> {
                    gestorUsuario.mostrarUsuarios()
                    val id = consola.pedirId()
                    gestorUsuario.buscarUsuario(id)?.consultarPrestamos()
                }
                "8" -> {
                    catalogo.mostrarCatalogo()
                    val id = consola.pedirId()
                    val elemento = gestorElementos.buscarElemento{it.id == id}
                    if (elemento != null) {
                        registroPrestamos.historialLibro(elemento)
                    }
                }
                "9" -> {
                    gestorUsuario.mostrarUsuarios()
                    val id = consola.pedirId()
                    val usuario = gestorUsuario.buscarUsuario(id)
                    if (usuario != null) {
                        registroPrestamos.historialUsuario(usuario)
                    }
                }
                "0" -> break
                else -> consola.mostrarMensaje("Opcion no válida")
            }
        }
    }

}