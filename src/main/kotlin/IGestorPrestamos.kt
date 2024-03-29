package org.example

interface IGestorPrestamos {
    fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario)
    fun devolucionPrestamos(elemento: ElementoBiblioteca, usuario: Usuario)
    fun historialLibro(elemento: ElementoBiblioteca)
    fun historialUsuario(usuario: Usuario)
}