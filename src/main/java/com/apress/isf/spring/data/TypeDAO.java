package com.apress.isf.spring.data;

import java.util.List;

import com.apress.isf.java.model.Type;

/**
 * 
 * @since 11/17/2017
 *
 */
public interface TypeDAO {
	
	public List<Type> getAll();
	public Type findById(String id);
	public Type save(Type type);

}
