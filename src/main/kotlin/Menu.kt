package org.example

class Menu(val biblioteca : GestorBiblioteca){
    val consola = GestorConsola
    fun mostrarMenu(){
        consola.mostrarMensaje("1. Agregar libro\n2. Eliminar libro\n3. Prestar libro\n4. Devolver libro\n5. Comprobar disponibilidad libro\n6. Mostrar catálogo\n0. Salir")
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
                    biblioteca.prestarLibro(id, )
                }
                "4" -> {
                    biblioteca.mostrarLibrosPrestados()
                    val id = consola.pedirId()
                    biblioteca.devolverLibro(id)
                }
                "5" -> {
                    biblioteca.mostrarCatalogo()
                    val id = consola.pedirId()
                    biblioteca.disponibilidad(id)
                }
                "6" -> {
                    biblioteca.mostraTodo()
                }
                "0" -> break
                else -> consola.mostrarMensaje("Opcion no válida")
            }
        }
    }

}