package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ecomanager.model.Usuario;
import br.com.ecomanager.util.JPAUtil;

public class UsuarioDAO implements GenericDAO <Usuario> {

	@Override
	public void salvar(Usuario entidade) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		em.getTransaction().begin();
		if (entidade.getId() == null) {
			em.persist(entidade);
		}else {
			em.merge(entidade);{
			}
			em.getTransaction().commit();
		}
			}finally {
			em.close();
		}
			
		
	}

	@Override
	public void remover(int id) {
	 EntityManager em = JPAUtil.getEntityManager();
	 try {
		 em.getTransaction().begin();
			
			Usuario usuario = em.find(Usuario.class, id);
			
			em.remove(usuario);
			
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	 }
		

	@Override
	public Usuario buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Usuario.class, id);
		}finally {
			em.close();
		}
		}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		EntityManager em = JPAUtil.getEntityManager();
		{
			try {
				usuarios = em.createQuery("from " + Usuario.class.getSimpleName(), Usuario.class).getResultList();
				return usuarios;
		}finally {
			em.close();
		}
	}

	}
}
		
