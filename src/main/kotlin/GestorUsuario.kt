package org.example

class GestorUsuario {
    private val usuarios = mutableListOf<Usuario>()
    private val consola = GestorConsola

    fun agregarUsuario(): Usuario {
        val id = UtilidadesBiblioteca.generarId()
        val nombre = consola.pedirNombreUsuario()

        val usuario = Usuario(id, nombre)
        usuarios.add(usuario)

        consola.mostrarMensaje("Usuario añadido correctamente")

        return usuario
    }

    fun buscarUsuario(id: Int)= usuarios.find { usuario : Usuario -> usuario.id == id }

    fun mostrarUsuarios(){
        usuarios.forEach { println("Usuario: id -> ${it.id}, nombre ->${it.nombre}") }
    }

    fun usuarioExistente(): Boolean {
        while (true) {
            consola.mostrarMensaje("Usuario existente? (s/n)")
            val respuesta = consola.respuesta()

            if (respuesta == "s") {
                return true
            } else if (respuesta == "n") {
                return false
            } else {
                consola.mostrarMensaje("Respuesta inválida. Por favor ingrese 's' para si o 'n' para no.")
            }
        }
    }
}