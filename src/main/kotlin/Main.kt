package org.example

fun main() {

    val consola = GestorConsola
    val biblioteca = GestorBiblioteca()
    val menu = Menu(biblioteca)

    try{
        menu.menu()
    }catch (e: Exception){
        consola.mostrarMensaje("${e.message}")
    }



}