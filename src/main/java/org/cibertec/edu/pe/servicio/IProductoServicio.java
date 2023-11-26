package org.cibertec.edu.pe.servicio;

import java.util.List;

import org.cibertec.edu.pe.model.Producto;

public interface IProductoServicio {

    public List<Producto> listarProductos(); //Listar los productos

    public Producto guardarProducto(Producto producto); //Guardar nuevo producto

    public Producto obtenerProductoxId(int id); //Obtene el producto por el id

    public Producto actualizarProducto(Producto producto);//Actualizar producto

    public void eliminarProducto(int id);//Eliminar producto utilizando el id

}