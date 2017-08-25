package es.oposiciones.modelo.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import es.oposiciones.modelo.util.InstanceNotFoundException;

public class SuperDao<E> {
	private SessionFactory sessionFactory;

	private Class<E> claseEntidad;

	@SuppressWarnings("unchecked")
	public SuperDao() {
		Type genericSuperClass = getClass().getGenericSuperclass();

		if (getClass().getName().contains("$$EnhancerBySpringCGLIB$$")) {
			genericSuperClass = getClass().getSuperclass().getGenericSuperclass();
		}

		claseEntidad = (Class<E>) ((ParameterizedType) genericSuperClass).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected DataAccessException convertHibernateAccessException(HibernateException e) {
		return SessionFactoryUtils.convertHibernateAccessException(e);
	}

	public void guardar(E entidad) {
		try {
			getSession().saveOrUpdate(entidad);
			getSession().flush();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	public boolean existe(int id) {
		try {
			return getSession().createCriteria(claseEntidad).add(Restrictions.idEq(id)).setProjection(Projections.id()).uniqueResult() != null;
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public E buscar(int id) {
		try {
			return (E) getSession().get(claseEntidad, id);
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	public List<E> buscarTodos() {
		try {
			@SuppressWarnings("unchecked")
			List<E> entidades = getSession().createCriteria(claseEntidad).list();
			return entidades;
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

	public void eliminar(int id) throws InstanceNotFoundException {
		try {
			getSession().delete(buscar(id));
			getSession().flush();
		} catch (HibernateException e) {
			throw convertHibernateAccessException(e);
		}
	}

}
