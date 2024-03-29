package org.example

class GestorUsuario {
    private val usuarios = mutableListOf<Usuario>()
    private val consola = GestorConsola

    fun agregarUsuario(): Usuario {
        val id = UtilidadesBiblioteca.generarId()
        val nombre = consola.pedirNombreUsuario()

        val usuario = Usuario(id, nombre)
        usuarios.add(usuario)

        return usuario
    }

    fun buscarUsuario(id: Int)= usuarios.find { usuario : Usuario -> usuario.id == id }

    fun mostrarUsuarios(){
        usuarios.forEach { println("Usuario: id -> ${it.id}, nombre ->${it.nombre}") }
    }

    fun usuarioNuevo(): Boolean {
        while (true) {
            consola.mostrarMensaje("Usuario nuevo? (s/n)")
            val respuesta = consola.respuesta()

            if (respuesta == "s") {
                return true
            } else if (respuesta == "n") {
                return false
            } else {
                consola.mostrarMensaje("respuesta inválida. Por favor ingrese 's' para si y 'n' para no.")
            }
        }
    }
}