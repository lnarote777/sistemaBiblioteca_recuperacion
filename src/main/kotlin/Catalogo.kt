package org.example

class Catalogo: IGestorCatalogo {

    override val lista: MutableList<ElementoBiblioteca> = mutableListOf()
    val consola = GestorConsola

    override fun mostrarCatalogo(){
        consola.mostrarMensaje("--------Catálogo--------")
        lista.forEach { println(it) }
    }

    override fun mostrarElementosPrestados(){
        consola.mostrarMensaje("------------Prestados-------------")
        lista.forEach { elemento ->
            if (elemento.estado == Estado.PRESTADO){
                println(elemento)
            }
        }
    }

    override fun mostrarElementosDisponibles(){
        consola.mostrarMensaje("-----------Disponibles------------")
        lista.forEach { elemento ->
            if (elemento.estado == Estado.DISPONIBLE){
                println(elemento)
            }
        }
    }

    override fun mostrarTodo(){
        mostrarCatalogo()
        mostrarElementosDisponibles()
        mostrarElementosPrestados()
    }

}