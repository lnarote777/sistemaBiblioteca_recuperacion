package org.example

class GestorBiblioteca {
    private val catalogo = mutableListOf<Libro>(Libro(5, "Alicia en el país de las maravillas", "Lewis Carroll", 1865, "Fantasía"),
        Libro(890, "Bruma Roja", "Lucía G. Sobrado", 2023, "Fantasía")) //Para hacer las pruebas
    private val consola = GestorConsola
    private val prestamos = RegistroPrestamos()

    fun agregarLibroCatalogo(){
        val id = UtilidadesBiblioteca.generarId()
        val titulo = consola.pedirTitulo()
        val autor = consola.pedirAutor()
        val tematica = consola.pedirTematica()
        val publicacion = consola.pedirPublicacion()


        val libro = Libro(id, titulo, autor, publicacion, tematica)
        catalogo.add(libro)

        consola.mostrarMensaje("Libro agregado correctamente.")
    }

    fun eliminarLibroCatalogo(id: Int){
        val libro = buscarLibro(id)
        if (libro != null){
            catalogo.remove(libro)
            consola.mostrarMensaje("Libro eliminado correctamente.")
        }else{
            consola.mostrarMensaje("No se encontró el libro con id: $id")
        }

    }

    fun buscarLibro(id: Int) = catalogo.find { libro: Libro -> libro.id == id }

    fun prestarLibro(id: Int, usuario: Usuario){
        val libro = buscarLibro(id)

        if (libro != null){
            if (libro.estado == Estado.DISPONIBLE){
                libro.estado = Estado.PRESTADO

                usuario.agregarLibroPrestado(libro)
                prestamos.registrarPrestamo(libro, usuario)
            }else{
                consola.mostrarMensaje("El libro: '${libro.titulo}' ya está prestado.")
            }
        }else{
            consola.mostrarMensaje("No se encontró ningún libro.")
        }

    }

    fun devolverLibro(id: Int, usuario: Usuario){
        val libro = buscarLibro(id)

        if (libro != null){
            if (libro.estado == Estado.PRESTADO){
                libro.estado = Estado.DISPONIBLE

                usuario.eliminarLibroPrestado(libro)
                prestamos.devolverLibro(libro, usuario)
            }else{
                consola.mostrarMensaje("El libro: '${libro.titulo}' no ha sido prestado todavía.")
            }
        }else{
            consola.mostrarMensaje("No se encontró ningún libro.")
        }

    }

    fun disponibilidad(id: Int){
        val libro = buscarLibro(id)

        if (libro != null) {
            if (libro.estado == Estado.DISPONIBLE){
                consola.mostrarMensaje("El libro: '${libro.titulo}' se encuentra disponible en la biblioteca.")
            }else{
                consola.mostrarMensaje("El libro: '${libro.titulo}' ha sido prestado y aun no se ha devuelto.")
            }
        }else{
            consola.mostrarMensaje("No se encuentra ningún libro.")
        }
    }

    fun mostrarCatalogo(){
        consola.mostrarMensaje("--------Catálogo de libros--------")
        catalogo.forEach { println(it) }
    }

    fun mostrarLibrosPrestados(){
        consola.mostrarMensaje("------------Prestados-------------")
        catalogo.forEach { libro ->
            if (libro.estado == Estado.PRESTADO){
                println(libro)
            }
        }
    }

    fun mostrarLibrosDisponibles(){
        consola.mostrarMensaje("-----------Disponibles------------")
        catalogo.forEach { libro ->
            if (libro.estado == Estado.DISPONIBLE){
                println(libro)
            }
        }
    }

    fun mostraTodo(){
        mostrarCatalogo()
        mostrarLibrosDisponibles()
        mostrarLibrosPrestados()
    }

}