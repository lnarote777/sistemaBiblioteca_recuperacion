package org.example

class Revista(override val id: Int,
              override val titulo: String,
              override val publicacion: Int,
              val tematica: String,
              override var estado: Estado = Estado.NODISPONIBLE
) :ElementoBiblioteca()
{

    /**
     * Representación en cadena del elemento.
     * @return Una cadena que representa una revista.
     */
    override fun toString(): String {
        return "Revista - Id: $id, Título: $titulo"
    }
}