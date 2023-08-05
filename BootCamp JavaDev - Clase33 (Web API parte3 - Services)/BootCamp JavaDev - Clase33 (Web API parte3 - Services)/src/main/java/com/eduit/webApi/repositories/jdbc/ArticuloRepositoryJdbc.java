package com.eduit.webApi.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eduit.webApi.entities.Articulo;
import com.eduit.webApi.repositories.interfaces.I_ArticuloRepository;


public class ArticuloRepositoryJdbc implements I_ArticuloRepository{
	
	
	// La Conexion va a entrar por el constructor, y es la unica forma de instanciar la Clase. 
	private Connection conn;
	
	
	public ArticuloRepositoryJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void save(Articulo articulo) {
		if(articulo==null) return;
		try(PreparedStatement ps =conn.prepareStatement("insert into articulos (id,descripcion,precio) values (?,?,?)")) {
			ps.setInt(1, articulo.getId());
			ps.setString(2, articulo.getDescripcion());
			ps.setFloat(3, articulo.getPrecio());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
				
	}

	@Override
	public void remove(Articulo articulo) {
		try(PreparedStatement ps =conn.prepareStatement("delete from articulos where id=?")) {
			ps.setInt(1, articulo.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<Articulo> getAll() {
		List<Articulo> list = new ArrayList();
		try(ResultSet rs =conn.createStatement().executeQuery("select * from articulos")) {
			if(rs==null) {return list;}
			while(rs.next()) {
				list.add(new Articulo(
						rs.getInt("id"),
						rs.getString("descripcion"),
						rs.getFloat("precio")
						));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Articulo> getLikeDescripcion(String descripcion) {
		List<Articulo> list = new ArrayList();
		if(descripcion==null) {return list;}
		try(ResultSet rs =conn.createStatement().executeQuery("select * from articulos where descripcion like '%"+descripcion+"%'")) {
			while(rs.next()) {
				list.add(new Articulo(
						rs.getInt("id"),
						rs.getString("descripcion"),
						rs.getFloat("precio")
						));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public Articulo getById(int id) {
		Articulo articulo = new Articulo();
		if(id==0) {return articulo;}
		try(ResultSet rs =conn.createStatement().executeQuery("select * from articulos where id ="+id)) {
			while(rs.next()) {
				articulo = new Articulo(
										rs.getInt("id"),
										rs.getString("descripcion"),
										rs.getFloat("precio")
										);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return articulo;
	}

	
	
}
