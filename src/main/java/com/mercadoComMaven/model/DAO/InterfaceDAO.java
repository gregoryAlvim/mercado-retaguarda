package com.mercadoComMaven.model.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
   public abstract void create(T objeto);
   public abstract T retrive(int codigo);
   public abstract T retrive(String descricao);
   public abstract List<T> retrive();
   public abstract void update(T objeto); 
   public abstract void delete(T objeto);
   
}
