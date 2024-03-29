package org.example

interface IGestorCatalogo {
    val lista : MutableList<ElementoBiblioteca>
    fun mostrarCatalogo()
    fun mostrarElementosPrestados()
    fun mostrarElementosDisponibles()
    fun mostrarTodo()
}