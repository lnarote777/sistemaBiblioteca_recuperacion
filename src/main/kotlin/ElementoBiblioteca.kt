package org.example

abstract class ElementoBiblioteca {
    abstract val id: Int
    abstract val titulo: String
    abstract val publicacion: Int
    abstract var estado: Estado
}