package org.example

object GestorConsola {
    fun mostrarMensaje(mensaje: String){
        println(mensaje)
    }

    fun pedirOpcion(): String {
        print("-> ")
        val opcion = readln()

        return opcion
    }

    fun respuesta(): String {
        val repuesta = readln()

        return repuesta
    }

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

    fun pedirPublicacion(): Int {
        while (true){
            mostrarMensaje("Año de publicación:")
            val publicacion = respuesta()

            if (publicacion !in ("1".."2024")){
                mostrarMensaje("El año de publicación debe estar entre el año 1 y el 2024.")
            }else {
                return publicacion.toInt()
            }
        }
    }

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

    fun pedirElemento(): String{
        while (true) {
            mostrarMensaje("")
            mostrarMensaje("¿Que tipo de elemento quiere agregar?")
            mostrarMensaje("1. Libro\n2. DVD\n3. Revista")
            val opcion = pedirOpcion()

            if (opcion != "1" || opcion != "2" || opcion != "3"){
                mostrarMensaje("Opcion inválida")
            }else{
                return opcion
            }
        }
    }
}

