package org.example

class Catalogo: IGestorCatalogo {

    override val lista: MutableList<ElementoBiblioteca> = mutableListOf()
    val consola = GestorConsola

    /**
     * Muestra el catálogo completo de la biblioteca.
     */
    override fun mostrarCatalogo(){
        consola.mostrarMensaje("--------Catálogo--------")
        lista.forEach { println(it) }
    }

    /**
     * Muestra los elementos prestados de la biblioteca.
     */
    override fun mostrarElementosPrestados(){
        consola.mostrarMensaje("------------Prestados-------------")
        lista.forEach { elemento ->
            if (elemento.estado == Estado.PRESTADO){
                println(elemento)
            }
        }
    }

    /**
     * Muestra los elementos disponibles en la biblioteca.
     */
    override fun mostrarElementosDisponibles(){
        consola.mostrarMensaje("-----------Disponibles------------")
        lista.forEach { elemento ->
            if (elemento.estado == Estado.DISPONIBLE){
                println(elemento)
            }
        }
    }

    /**
     * Muestra el catálogo completo, seguido de los elementos disponibles y los elementos prestados.
     */
    override fun mostrarTodo(){
        mostrarCatalogo()
        mostrarElementosDisponibles()
        mostrarElementosPrestados()
    }

}