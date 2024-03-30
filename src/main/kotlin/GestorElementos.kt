package org.example

class GestorElementos<T> {

    val listaElementos = mutableListOf<T>()
    val consola = GestorConsola

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     * @param elemento El elemento que se agrega al catálogo.
     */
    fun agregarElementoCatalogo(elemento: T){
        listaElementos.add(elemento)
    }

    /**
     * Elimina un elemento del catálogo de la biblioteca.
     * @param elemento El elemento que se elimina del catálogo.
     */
    fun eliminarElementoCatalogo(elemento: T) {
        listaElementos.remove(elemento)
    }

    /**
     * Busca un elemento en el catálogo de la biblioteca según un predicado.
     * @param predicate El predicado utilizado para buscar el elemento.
     * @return El elemento encontrado, o null si no se encontró ningún elemento que cumpla con el predicado.
     */
    fun buscarElemento(predicate: (T) -> Boolean ) = listaElementos.find(predicate)

    /**
     * Filtra elementos de la lista según un criterio específico.
     * @param elemento El elemento que se usará para aplicar el criterio de búsqueda.
     * @param criterio El predicado utilizado para filtrar los elementos.
     * @return El primer elemento encontrado que cumple con el criterio especificado, o null si no se encontró ningún elemento.
     */
    fun filtrarPorCriterio(elemento: T, criterio: (elemento: T) -> Boolean): T? {
        val elementoEncontrado = listaElementos.find { criterio(it) && it == elemento }
        if (elementoEncontrado == null) {
            consola.mostrarMensaje("No se encontró ningún elemento")
        }
        return elementoEncontrado
    }

}