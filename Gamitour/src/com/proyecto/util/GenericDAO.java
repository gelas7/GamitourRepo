package com.proyecto.util;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, Id extends Serializable> {
    
    public void insertar(T t);
    
    public void actualizar(T t);   
    
    public void eliminar(T t);
    
    public List<T> buscarTodos();
    
    public T buscarPorClave(Id id);
    
}