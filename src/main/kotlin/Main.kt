package org.example

/**
 * Función principal del programa
 */
fun main() {

    val gestorElementos = GestorElementos<ElementoBiblioteca>()
    val catalogo = GestorCatalogo(gestorElementos)

    val consola = GestorConsola
    val gestorPrestamos = RegistroPrestamos()
    val biblioteca = GestorBiblioteca(gestorElementos, consola, gestorPrestamos)
    val menu = Menu(biblioteca, gestorPrestamos, catalogo, gestorElementos)

    try{
        menu.menu()
    }catch (e: Exception){
        consola.mostrarMensaje("${e.message}")
    }



}