package org.example

class Libro(override val id: Int,
            override val titulo: String,
            private val autor: String,
            override val publicacion: Int,
            private val tematica: String,
            override var estado: Estado = Estado.DISPONIBLE
) : ElementoBiblioteca(), Prestable
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
        return "Libro - Id: $id, Titulo:$titulo, Autor: $autor, Temática: $tematica"
    }
}
