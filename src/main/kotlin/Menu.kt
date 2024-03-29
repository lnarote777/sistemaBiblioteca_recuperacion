package org.example

class Menu(val biblioteca : GestorBiblioteca){
    private val consola = GestorConsola
    private val gestorUsuario = GestorUsuario()
    private val registroPrestamos = RegistroPrestamos()

    private fun mostrarMenu(){
        consola.mostrarMensaje("1. Agregar libro\n2. Eliminar libro\n3. Prestar libro\n4. Devolver libro\n5. Comprobar disponibilidad libro\n6. Mostrar catálogo\n7. Mostrar prestamos usuario\n8. Mostrar historial prestamos libro\n9. Mostrar historial prestamos usuario\n0. Salir")
    }

    fun menu(){
        while (true){
            consola.mostrarMensaje("Elige una opción:")
            mostrarMenu()
            val opcion = consola.pedirOpcion()
            when(opcion){
                "1" -> biblioteca.agregarLibroCatalogo()
                "2" -> {
                    biblioteca.mostrarLibrosDisponibles()
                    val id = consola.pedirId()
                    biblioteca.eliminarLibroCatalogo(id)
                }
                "3" -> {
                    biblioteca.mostrarLibrosDisponibles()
                    val id = consola.pedirId()
                    if (gestorUsuario.usuarioNuevo()){
                        val usuario = gestorUsuario.agregarUsuario()
                        biblioteca.prestarLibro(id, usuario)
                    }else{
                        gestorUsuario.mostrarUsuarios()
                        val idUsuario = consola.pedirId()
                        val usuario = gestorUsuario.buscarUsuario(idUsuario)
                        if (usuario != null) {
                            biblioteca.prestarLibro(id, usuario)
                        }

                    }

                }
                "4" -> {
                    biblioteca.mostrarLibrosPrestados()
                    val id = consola.pedirId()
                    if (gestorUsuario.usuarioNuevo()){
                        consola.mostrarMensaje("No tiene libros para devolver.")
                    }else{
                        gestorUsuario.mostrarUsuarios()
                        val idUsuario = consola.pedirId()
                        val usuario = gestorUsuario.buscarUsuario(idUsuario)
                        if (usuario != null) {
                            biblioteca.devolverLibro(id, usuario)
                        }
                    }
                }
                "5" -> {
                    biblioteca.mostrarCatalogo()
                    val id = consola.pedirId()
                    biblioteca.disponibilidad(id)
                }
                "6" -> {
                    biblioteca.mostraTodo()
                }
                "7" -> {
                    gestorUsuario.mostrarUsuarios()
                    val id = consola.pedirId()
                    gestorUsuario.buscarUsuario(id)?.consultarPrestamos()
                }
                "8" -> {
                    biblioteca.mostrarCatalogo()
                    val id = consola.pedirId()
                    val libro = biblioteca.buscarLibro(id)
                    if (libro != null) {
                        registroPrestamos.historialLibro(libro)
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