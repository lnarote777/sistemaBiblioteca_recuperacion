package org.example

/**
 * Función principal del programa
 */
fun main() {

    val catalogo = Catalogo()

    val consola = GestorConsola
    val gestorPrestamos = RegistroPrestamos()
    val biblioteca = GestorBiblioteca(catalogo, consola, gestorPrestamos)
    val menu = Menu(biblioteca, gestorPrestamos, catalogo)

    try{
        menu.menu()
    }catch (e: Exception){
        consola.mostrarMensaje("${e.message}")
    }



}