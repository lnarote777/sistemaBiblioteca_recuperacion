package org.example

class GestorBiblioteca {
    private val catalogo = mutableListOf<Libro>()
    private val registroPrestamos = mutableMapOf<String, String>()
    private val consola = GestorConsola()

    fun agregarLibroCatalogo(libro: Libro){
        catalogo.add(libro)
    }

    fun eliminarLibroCatalogo(libro: Libro){
        catalogo.remove(libro)
    }

    private fun buscarLibro(id: String) = catalogo.find { libro: Libro -> libro.id == id }

    fun prestarLibro(libro: Libro){
        val libro = buscarLibro(libro.id)

        if (libro != null){
            if (libro.estado == Estado.DISPONIBLE){
                libro.estado = Estado.PRESTADO
                registroPrestamos[libro.id] = "Libro prestado"
            }else{
                consola.mostrarMensaje("El libro: ${libro.titulo} ya está prestado.")
            }
        }else{
            consola.mostrarMensaje("No se encontró ningún libro.")
        }

    }

    fun devolverLibro(libro: Libro){
        val libro = buscarLibro(libro.id)

        if (libro != null){
            if (libro.estado == Estado.PRESTADO){
                libro.estado = Estado.DISPONIBLE
                registroPrestamos[libro.id] = "Libro devuelto"
            }else{
                consola.mostrarMensaje("El libro: ${libro.titulo} no ha sido prestado todavía.")
            }
        }else{
            consola.mostrarMensaje("No se encontró ningún libro.")
        }

    }

    fun disponibilidad(libro: Libro){
        val libro = buscarLibro(libro.id)

        if (libro != null) {
            if (libro.estado == Estado.DISPONIBLE){
                consola.mostrarMensaje("El libro: ${libro.titulo} se encuentra disponible en la biblioteca.")
            }else{
                consola.mostrarMensaje("El libro: ${libro.titulo} ha sido prestado y aun no se ha devuelto.")
            }
        }else{
            consola.mostrarMensaje("No se encuentra ningún libro.")
        }
    }

    fun mostrarLibros(){
        consola.mostrarMensaje("--------Catálogo de libros--------")
        catalogo.forEach { println(it) }

        consola.mostrarMensaje("-----------Disponibles------------")
        mostrarLibrosDisponibles()

        consola.mostrarMensaje("------------Prestados-------------")
        mostrarLibrosPrestados()
    }

    private fun mostrarLibrosPrestados(){
        catalogo.forEach { libro ->
            if (libro.estado == Estado.PRESTADO){
                println(libro)
            }
        }
    }

    private fun mostrarLibrosDisponibles(){
        catalogo.forEach { libro ->
            if (libro.estado == Estado.DISPONIBLE){
                println(libro)
            }
        }
    }

}