package org.example

class Revista(override val id: Int,
              override val titulo: String,
              override val publicacion: Int,
              val tematica: String,
              override var estado: Estado = Estado.NODISPONIBLE
) :ElementoBiblioteca()
{

    override fun toString(): String {
        return "Revista - Id: $id, Título: $titulo"
    }
}