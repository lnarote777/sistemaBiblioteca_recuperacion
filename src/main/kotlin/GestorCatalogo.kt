package org.example

class GestorCatalogo (val gestorElementos: GestorElementos<ElementoBiblioteca>): IGestorCatalogo {

    val consola = GestorConsola

    /**
     * Muestra el catálogo completo de la biblioteca.
     */
    override fun mostrarCatalogo(){
        consola.mostrarMensaje("--------Catálogo--------")
        gestorElementos.listaElementos.forEach { println(it) }
    }

    /**
     * Muestra los elementos prestados de la biblioteca.
     */
    override fun mostrarElementosPrestados(){
        consola.mostrarMensaje("------------Prestados-------------")
        gestorElementos.listaElementos.forEach { elemento ->
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
        gestorElementos.listaElementos.forEach { elemento ->
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