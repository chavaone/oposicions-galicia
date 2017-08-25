package es.oposiciones.modelo.dao;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import es.oposiciones.modelo.dominio.Centro;

public class CentroDao extends SuperDao<Centro> {

	public Centro buscar(String nombre) {
		try {
			return (Centro) getSession().createCriteria(Centro.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
