package org.example

class UtilidadesBiblioteca {
    companion object{
        val listaId = mutableListOf<Int>()

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