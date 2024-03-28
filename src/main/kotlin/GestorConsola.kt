package org.example

class GestorConsola {
    fun mostrarMensaje(mensaje: String){
        println(mensaje)
    }

    fun pedirOpcion(): String {
        print("->")
        val opcion = readln()

        return opcion
    }
}
