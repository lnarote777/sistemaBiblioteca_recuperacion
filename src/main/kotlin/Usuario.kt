package org.example

class Usuario(val id: Int, val nombre: String) {

    private val listaPrestamos = mutableListOf<ElementoBiblioteca>()

    /**
     * Agrega un elemento a la lista de elementos prestados por el usuario.
     * @param elemento El elemento de biblioteca que se agrega a la lista de préstamos del usuario.
     */
    fun agregarElementoPrestado(elemento: ElementoBiblioteca){
        listaPrestamos.add(elemento)
    }

    /**
     * Elimina un elemento de la lista de elementos prestados por el usuario.
     * @param elemento El elemento de biblioteca que se elimina de la lista de préstamos del usuario.
     */
    fun eliminarElementoPrestado(elemento: ElementoBiblioteca){
        listaPrestamos.remove(elemento)
    }

    /**
     * Consulta los elementos prestados por el usuario y los muestra en la consola.
     */
    fun consultarPrestamos(){
        listaPrestamos.forEach { println("-${it.titulo}") }
    }

}