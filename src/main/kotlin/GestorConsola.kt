package org.example

object GestorConsola {
    fun mostrarMensaje(mensaje: String){
        println(mensaje)
    }

    fun pedirOpcion(): String {
        print("-> ")
        val opcion = readln()

        return opcion
    }

    fun respuesta(): String {
        val repuesta = readln()

        return repuesta
    }

    fun pedirAutor(): String {
        mostrarMensaje("Autor:")
        val autor = respuesta()
        return autor
    }

    fun pedirTematica(): String {
        mostrarMensaje("Temática:")
        val tematica = respuesta()
        return tematica
    }

    fun pedirPublicacion(): Int {
        mostrarMensaje("Año de publicación:")
        val publicacion = respuesta().toInt()
        return publicacion
    }

    fun pedirTitulo(): String {
        mostrarMensaje("Título:")
        val titulo = respuesta()
        return titulo
    }

    fun pedirId(): Int {
        mostrarMensaje("Ingrese el id del libro")
        val id = pedirOpcion().toInt()
        return id
    }

    fun pedirNombreUsuario(): String{
        mostrarMensaje("Nombre usuario:")
        val nombre = respuesta()
        return nombre
    }
}

