package org.example

import java.io.Console

class GestorBiblioteca(
    private val catalogo: IGestorCatalogo,
    private val consola: GestorConsola,
    private val gestorPrestamos: IGestorPrestamos
){

    /**
     * Agrega un elemento al catálogo de la biblioteca según la opción seleccionada por el usuario.
     */
    fun agregarElementoCatalogo(){
        val id = UtilidadesBiblioteca.generarId()
        val elemento = consola.pedirElemento()
        val titulo = consola.pedirTitulo()
        val publicacion = consola.pedirPublicacion()

        when (elemento){
            "1" -> {
                val autor = consola.pedirAutor()
                val tematica = consola.pedirTematica()
                val libro = Libro(id, titulo, autor, publicacion, tematica)
                catalogo.lista.add(libro)

                consola.mostrarMensaje("Libro agregado correctamente.")
            }
            "2" -> {
                val dvd = Dvd(id, titulo, publicacion)
                catalogo.lista.add(dvd)

                consola.mostrarMensaje("DVD agregado correctamente.")
            }
            "3" -> {
                val tematica = consola.pedirTematica()
                val revista = Revista(id, titulo, publicacion, tematica)
                catalogo.lista.add(revista)

                consola.mostrarMensaje("Revista agregado correctamente.")
            }
            else -> consola.mostrarMensaje("Opción no válida")
        }

    }

    /**
     * Elimina un elemento del catálogo de la biblioteca según su ID.
     * @param id El ID del elemento a eliminar.
     */
    fun eliminarElementoCatalogo(id: Int){
        val elemento = buscarElemento(id)
        if (elemento != null){
            catalogo.lista.remove(elemento)
            consola.mostrarMensaje("Libro eliminado correctamente.")
        }else{
            consola.mostrarMensaje("No se encontró el libro con id: $id")
        }

    }

    /**
     * Busca un elemento en el catálogo de la biblioteca según su ID.
     * @param id El ID del elemento a buscar.
     * @return El elemento encontrado, o null si no se encontró ningún elemento con el ID especificado.
     */
    fun buscarElemento(id: Int) = catalogo.lista.find { elemento: ElementoBiblioteca -> elemento.id == id }

    /**
     * Presta un elemento de la biblioteca a un usuario.
     * @param id El ID del elemento a prestar.
     * @param usuario El usuario al que se presta el elemento.
     */
    fun prestarElemento(id: Int, usuario: Usuario){
        val elemento = buscarElemento(id)

        if (elemento != null && elemento is Prestable){

            if(elemento.prestar()){
                usuario.agregarElementoPrestado(elemento)
                gestorPrestamos.registrarPrestamo(elemento, usuario)
                consola.mostrarMensaje("Elemento prestado")
            }else{
                consola.mostrarMensaje("'${elemento.titulo}' ya está prestado.")
            }

        }else{
            consola.mostrarMensaje("Este elemento no se puede prestar.")
        }

    }

    /**
     * Devuelve un elemento prestado por un usuario.
     * @param id El ID del elemento a devolver.
     * @param usuario El usuario que devuelve el elemento.
     */
    fun devolverElemento(id: Int, usuario: Usuario){
        val elemento = buscarElemento(id)

        if (elemento != null && elemento is Prestable){

            if(elemento.devolver()){
                usuario.eliminarElementoPrestado(elemento)
                gestorPrestamos.devolucionPrestamos(elemento, usuario)
                consola.mostrarMensaje("Elemento devuelto")
            }else{
                consola.mostrarMensaje("'${elemento.titulo}' no ha sido prestado todavía.")
            }

        }else{
            consola.mostrarMensaje("Este elemento no se puede devolver.")
        }

    }

    /**
     * Verifica la disponibilidad de un elemento en la biblioteca.
     * @param id El ID del elemento a verificar.
     */
    fun disponibilidad(id: Int){
        val elemento = buscarElemento(id)

        if (elemento != null) {
            if (elemento.estado == Estado.DISPONIBLE){
                consola.mostrarMensaje("'${elemento.titulo}' se encuentra disponible en la biblioteca.")
            }else{
                consola.mostrarMensaje("'${elemento.titulo}' ha sido prestado y aun no se ha devuelto.")
            }
        }else{
            consola.mostrarMensaje("No se encuentra nada.")
        }
    }

}