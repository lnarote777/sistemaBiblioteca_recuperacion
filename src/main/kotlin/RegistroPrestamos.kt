package org.example

class RegistroPrestamos {
    val registroPrestamos = mutableMapOf<Int, Usuario>()
    val historialPrestamos = mutableMapOf<Int, String>()
    val consola = GestorConsola

    fun registrarPrestamo(libro: Libro, usuario: Usuario){
        registroPrestamos[libro.id] = usuario
        historialPrestamos[libro.id] = "Prestado"
    }

    fun devolverLibro(libro: Libro, usuario: Usuario){
        registroPrestamos.remove(libro.id, usuario)
        historialPrestamos[libro.id] = "Devuelto"
    }

    fun historialLibro(libro: Libro){

    }

    fun historialUsuario(usuario: Usuario){

    }

}