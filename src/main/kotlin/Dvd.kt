package org.example

class Dvd(override val id: Int,
          override val titulo: String,
          override val publicacion: Int,
          override var estado: Estado = Estado.DISPONIBLE
): ElementoBiblioteca(), Prestable
{

    override fun prestar(): Boolean {
        if (this.estado == Estado.DISPONIBLE){
            this.estado = Estado.PRESTADO

            return true
        }else{
            return false
        }
    }

    override fun devolver(): Boolean {
        if (this.estado == Estado.PRESTADO){
            this.estado = Estado.DISPONIBLE

            return true
        }else{
            return false
        }
    }

    override fun toString(): String {
        return "DVD - Id: $id, Título: $titulo "
    }
}