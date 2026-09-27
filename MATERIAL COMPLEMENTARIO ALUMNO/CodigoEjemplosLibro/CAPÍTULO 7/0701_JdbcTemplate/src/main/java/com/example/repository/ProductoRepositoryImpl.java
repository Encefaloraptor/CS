package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int añadir(Producto producto) {
    return jdbcTemplate.update("INSERT INTO producto (nombre, precio) VALUES(?,?)",
        new Object[] { producto.getNombre(), producto.getPrecio() });
  }

  @Override
  public int actualizar(Producto producto) {
    return jdbcTemplate.update("UPDATE producto SET nombre=?, precio=? WHERE id=?",
        new Object[] { producto.getNombre(), producto.getPrecio(), producto.getId() });
  }

  @Override
  public Producto obtenerPorClave(Long id) {
    try {
      Producto producto = jdbcTemplate.queryForObject("SELECT * FROM producto WHERE id=?",
          BeanPropertyRowMapper.newInstance(Producto.class), id);
      return producto;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int borrarPorClave(Long id) {
    return jdbcTemplate.update("DELETE FROM producto WHERE id=?", id);
  }

  @Override
  public List<Producto> obtenerTodos() {
    return jdbcTemplate.query("SELECT * from producto", BeanPropertyRowMapper.newInstance(Producto.class));
  }

  @Override
  public List<Producto> obtenerPorPrecio(Double precio) {
    return jdbcTemplate.query("SELECT * from producto WHERE precio=?",
        BeanPropertyRowMapper.newInstance(Producto.class), precio);
  }

}
