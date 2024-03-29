package org.example

class Usuario(val id: Int, val nombre: String) {

    private val listaPrestamos = mutableListOf<ElementoBiblioteca>()

    fun agregarElementoPrestado(elemento: ElementoBiblioteca){
        listaPrestamos.add(elemento)
    }

    fun eliminarElementoPrestado(elemento: ElementoBiblioteca){
        listaPrestamos.remove(elemento)
    }

    fun consultarPrestamos(){
        listaPrestamos.forEach { println("-${it.titulo}") }
    }

}