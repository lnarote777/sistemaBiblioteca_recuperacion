package org.example

class Usuario(val id: Int, val nombre: String) {

    private val listaPrestamos = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro){
        listaPrestamos.add(libro)
    }

    fun eliminarLibroPrestado(libro: Libro){
        listaPrestamos.remove(libro)
    }

    fun consultarPrestamos(){
        listaPrestamos.forEach { println("-${it.titulo}") }
    }

}