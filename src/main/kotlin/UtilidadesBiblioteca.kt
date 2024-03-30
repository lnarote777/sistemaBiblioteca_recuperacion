package org.example

class UtilidadesBiblioteca {
    companion object{
        val listaId = mutableListOf<Int>()

        /**
         * Genera un ID único para un elemento de la biblioteca.
         * @return Un ID único generado para el elemento.
         */
        fun generarId(): Int{
            while (true){
                val id = (1..999).random()

                if (id !in listaId){
                    listaId.add(id)
                    return id
                }

            }

        }
    }
}