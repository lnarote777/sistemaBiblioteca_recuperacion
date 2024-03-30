package org.example

class Libro(override val id: Int,
            override val titulo: String,
            private val autor: String,
            override val publicacion: Int,
            private val tematica: String,
            override var estado: Estado = Estado.DISPONIBLE
) : ElementoBiblioteca(), Prestable
{

    /**
     * Cambia el estado del elemento a prestado si está disponible.
     * @return `true` si el préstamo se realizó con éxito, `false` si el elemento no estaba disponible para préstamo.
     */
    override fun prestar(): Boolean {
        if (this.estado == Estado.DISPONIBLE){
            this.estado = Estado.PRESTADO

            return true
        }else{
            return false
        }
    }

    /**
     * Cambia el estado del elemento a disponible si está prestado.
     * @return `true` si la devolución se realizó con éxito, `false` si el elemento no estaba prestado.
     */
    override fun devolver(): Boolean {
        if (this.estado == Estado.PRESTADO){
            this.estado = Estado.DISPONIBLE

            return true
        }else{
            return false
        }
    }

    /**
     * Representación en cadena del elemento.
     * @return Una cadena que representa un libro.
     */
    override fun toString(): String {
        return "Libro - Id: $id, Titulo:$titulo, Autor: $autor, Temática: $tematica"
    }
}
