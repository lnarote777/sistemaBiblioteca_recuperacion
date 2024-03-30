package org.example

object GestorConsola {

    /**
     * Muestra un mensaje en la consola.
     * @param mensaje El mensaje a mostrar.
     */
    fun mostrarMensaje(mensaje: String){
        println(mensaje)
    }

    /**
     * Solicita al usuario que ingrese una opción y devuelve la opción ingresada.
     * @return La opción ingresada por el usuario.
     */
    fun pedirOpcion(): String {
        print("-> ")
        val opcion = readln()

        return opcion
    }

    /**
     * Solicita al usuario que ingrese una respuesta y devuelve la respuesta ingresada.
     * @return La respuesta ingresada por el usuario.
     */
    fun respuesta(): String {
        val repuesta = readln()

        return repuesta
    }


    /**
     * Solicita al usuario que ingrese el nombre del autor y devuelve el nombre ingresado.
     * @return El nombre del autor ingresado por el usuario.
     */
    fun pedirAutor(): String {
        while (true){
            mostrarMensaje("Autor:")
            val autor = respuesta()

            if (autor.isNullOrBlank()){
                mostrarMensaje("El autor no puede estar en blanco.")
            }else{
                return autor
            }
        }
    }

    /**
     * Solicita al usuario que ingrese la temática y devuelve la temática ingresada.
     * @return La temática ingresada por el usuario.
     */
    fun pedirTematica(): String {
        while (true){
            mostrarMensaje("Temática:")
            val tematica = respuesta()

            if (tematica.isNullOrBlank()){
                mostrarMensaje("Indique la temática por favor.")
            }else{
                return tematica
            }
        }

    }

    /**
     * Solicita al usuario que ingrese el año de publicación y devuelve el año ingresado.
     * @return El año de publicación ingresado por el usuario.
     */
    fun pedirPublicacion(): Int {
        while (true){
            mostrarMensaje("Año de publicación:")
            val publicacion = respuesta()

            if (publicacion.toInt() in (1..2024)){
                return publicacion.toInt()
            }else {
                mostrarMensaje("El año de publicación debe estar entre el año 1 y el 2024.")
            }
        }
    }

    /**
     * Solicita al usuario que ingrese el título y devuelve el título ingresado.
     * @return El título ingresado por el usuario.
     */
    fun pedirTitulo(): String {
        while (true) {
            mostrarMensaje("Título:")
            val titulo = respuesta()

            if (titulo.isNullOrBlank()){
                mostrarMensaje("El título no puede estar en blanco.")
            }else{
                return titulo
            }
        }
    }

    /**
     * Solicita al usuario que ingrese un identificador y devuelve el identificador ingresado.
     * @return El identificador ingresado por el usuario.
     */
    fun pedirId(): Int {
        while (true) {
            mostrarMensaje("Ingrese el identificador:")
            val id = pedirOpcion()

            if (!id.all { it.isDigit() }){
                mostrarMensaje("Introduzca un identificador válido")
            }else {
                return id.toInt()
            }
        }
    }

    /**
     * Solicita al usuario que ingrese el nombre de usuario y devuelve el nombre ingresado.
     * @return El nombre de usuario ingresado por el usuario.
     */
    fun pedirNombreUsuario(): String{
        while (true) {
            mostrarMensaje("Nombre usuario:")
            val nombre = respuesta()

            if (nombre.isNullOrBlank()) {
                mostrarMensaje("Ingrese un nombre para el usuario por favor.")
            } else {
                return nombre
            }
        }
    }

    /**
     * Solicita al usuario que seleccione el tipo de elemento a agregar y devuelve la opción seleccionada.
     * @return La opción seleccionada por el usuario.
     */
    fun pedirElemento(): String{
        while (true) {
            mostrarMensaje("")
            mostrarMensaje("¿Que tipo de elemento quiere agregar?")
            mostrarMensaje("1. Libro\n2. DVD\n3. Revista")
            val opcion = pedirOpcion()

            if (opcion == "1" || opcion == "2" || opcion == "3"){
                return opcion
            }else{
                mostrarMensaje("Opción inválida")
            }
        }
    }
}

