package es.oposiciones.modelo.dao;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import es.oposiciones.modelo.dominio.Localidad;

public class LocalidadDao extends SuperDao<Localidad> {

	public Localidad buscar(String nombre) {
		try {
			return (Localidad) getSession().createCriteria(Localidad.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
