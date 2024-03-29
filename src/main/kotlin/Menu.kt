package org.example

class Menu(
    private val biblioteca : GestorBiblioteca,
    private val registroPrestamos: RegistroPrestamos,
    private val catalogo: IGestorCatalogo)
{
    private val consola = GestorConsola
    private val gestorUsuario = GestorUsuario()
    private fun mostrarMenu(){
        consola.mostrarMensaje("1. Agregar libro\n2. Eliminar libro\n3. Prestar libro\n4. Devolver libro\n5. Comprobar disponibilidad libro\n6. Mostrar catálogo\n7. Mostrar prestamos usuario\n8. Mostrar historial prestamos libro\n9. Mostrar historial prestamos usuario\n0. Salir")
    }

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
                    val elemento = biblioteca.buscarElemento(id)
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