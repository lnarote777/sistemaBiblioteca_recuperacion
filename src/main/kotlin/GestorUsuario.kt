package org.example

class GestorUsuario {
    private val usuarios = mutableListOf<Usuario>()
    private val consola = GestorConsola

    /**
     * Agrega un nuevo usuario al sistema.
     * @return El usuario agregado.
     */
    fun agregarUsuario(): Usuario {
        val id = UtilidadesBiblioteca.generarId()
        val nombre = consola.pedirNombreUsuario()

        val usuario = Usuario(id, nombre)
        usuarios.add(usuario)

        consola.mostrarMensaje("Usuario añadido correctamente")

        return usuario
    }

    /**
     * Busca un usuario en el sistema según su ID.
     * @param id El ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encontró ningún usuario con el ID especificado.
     */
    fun buscarUsuario(id: Int)= usuarios.find { usuario : Usuario -> usuario.id == id }

    /**
     * Muestra todos los usuarios registrados en el sistema.
     */
    fun mostrarUsuarios(){
        usuarios.forEach { println("Usuario: id -> ${it.id}, nombre ->${it.nombre}") }
    }

    /**
     * Verifica si existe un usuario en el sistema.
     * @return `true` si el usuario existe, `false` si no existe.
     */
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