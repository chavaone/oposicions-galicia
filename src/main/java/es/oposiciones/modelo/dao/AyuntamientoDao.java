package es.oposiciones.modelo.dao;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import es.oposiciones.modelo.dominio.Ayuntamiento;

public class AyuntamientoDao extends SuperDao<Ayuntamiento> {

	public Ayuntamiento buscar(String nombre) {
		try {
			return (Ayuntamiento) getSession().createCriteria(Ayuntamiento.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
