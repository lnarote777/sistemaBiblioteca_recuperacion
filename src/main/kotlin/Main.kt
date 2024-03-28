package org.example

fun main() {
    val biblioteca = GestorBiblioteca()

    val libro1 = Libro("9832", "El trono de fuego", "Rick Riordan", 2011, "Ciencia Ficción")
    val libro2 = Libro("7625", "Reino de ladrones", "Leigh Bardugo", 2016, "Fantasía")
    val libro3 = Libro("8123", "El juego infinito", "James Dashner", 2013, "Ciencia Ficción")

    //añadir libros al catálogo
    biblioteca.agregarLibroCatalogo(libro1)
    biblioteca.agregarLibroCatalogo(libro2)
    biblioteca.agregarLibroCatalogo(libro3)

    //prestar libros
    biblioteca.prestarLibro(libro1)
    biblioteca.prestarLibro(libro3)
    biblioteca.prestarLibro(libro1)

    //devolver libros
    biblioteca.devolverLibro(libro3)
    biblioteca.devolverLibro(libro2)

    //estado actual de los libros
    biblioteca.disponibilidad(libro1)
    biblioteca.disponibilidad(libro2)
    biblioteca.disponibilidad(libro3)

    //mostrar libros
    biblioteca.mostrarLibros()



}