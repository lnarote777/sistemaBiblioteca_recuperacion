package org.example

class GestorUsuario {
    val usuarios = mutableListOf<Usuario>()
    val consola = GestorConsola

    fun agregarUsuario(){
        val id = UtilidadesBiblioteca.generarId()
        val nombre = consola.pedirNombreUsuario()

        val usuario = Usuario(id, nombre)
        usuarios.add(usuario)
    }

    fun buscarUsuario(id: Int)= usuarios.find { usuario : Usuario -> usuario.id == id }

}