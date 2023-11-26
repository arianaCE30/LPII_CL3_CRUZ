package org.cibertec.edu.pe.repositorio;

import org.cibertec.edu.pe.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Integer>{

}