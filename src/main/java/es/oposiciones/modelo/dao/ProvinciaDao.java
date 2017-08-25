package es.oposiciones.modelo.dao;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import es.oposiciones.modelo.dominio.Provincia;

public class ProvinciaDao extends SuperDao<Provincia> {

	public Provincia buscar(String nombre) {
		try {
			return (Provincia) getSession().createCriteria(Provincia.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
