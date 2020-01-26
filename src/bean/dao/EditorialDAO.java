/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.dao;

import bean.Author;
import bean.Editorial;
import database.Database;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rafae
 */
public class EditorialDAO {

    public EditorialDAO() {
    }

    public void create(Editorial editorial) {
        if (editorial != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();

                //Persisto la editorial en primer lugar.
                em.persist(editorial);

                /*Posteriormente si mi editorial tiene autores les agrego la editorial y 
                actualizo el autor*/
                if (editorial.getAuthors() != null && !editorial.getAuthors().isEmpty()) {
                    List<Author> authors = null;
                    for (Author author : editorial.getAuthors()) {
                        if (author != null && author.getId() != null) {
                            Author a = em.find(Author.class, author.getId());
                            a.setEditorial(editorial);
                        }
                    }
                }

                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
            em.close();
        }
    }

    public void remove(Long id) {
        if (id != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();

                //Se ha de buscar con el mismo entity manager, ya que sino al ejecutar remove,
                //lanzará una excepción con el mensaje 'Attempt to remove a detached entity object',
                //ya que remove solo funciona con entidades en el contexto de una misma transacción.
                Editorial e = em.find(Editorial.class, id);

                /*Elimino de la lista de autores la editorial*/
                List<Author> editorialAuthors = e.getAuthors();
                if (editorialAuthors != null && !editorialAuthors.isEmpty()) {
                    AuthorDAO aDAO = new AuthorDAO();
                    for (Author editorialAuthor : editorialAuthors) {
                        if (editorialAuthor != null && editorialAuthor.getId() != null) {
                            Author test = aDAO.find(editorialAuthor.getId());
                            test.setEditorial(null);
                            //aDAO.edit(test);
                        }
                    }
                }

                //Una vez eliminada la editorial de la parte del autor, elimino la 
                //propia entidad editorial.
                //Esto es equivalente a agregar el atributo orphanRemove=true, solo disponible
                //para relaciones OneToOne y OneToMany como es este caso.
                em.remove(e);

                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
            em.close();
        }
    }

    public void edit(Editorial editorial) {
        if (editorial != null && editorial.getId() != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();
                EditorialDAO eDAO = new EditorialDAO();
                AuthorDAO aDAO = new AuthorDAO();

                /*En primer lugar elimino la editorial en todos los autores donde se encuentre*/
                Editorial preUpdate = eDAO.find(editorial.getId());
                if (preUpdate.getAuthors() != null && !preUpdate.getAuthors().isEmpty()) {
                    for (Author author : preUpdate.getAuthors()) {
                        Author editorialAuthor = aDAO.find(author.getId());
                        editorialAuthor.setEditorial(null);
                        aDAO.edit(editorialAuthor);
                    }
                }

                /*Posteriormente agrego la editorial en los nuevos autores*/
                if (editorial.getAuthors() != null && !editorial.getAuthors().isEmpty()) {
                    List<Author> authors = null;
                    for (Author author : editorial.getAuthors()) {
                        if (author != null && author.getId() != null) {
                            Author editorialAuthor = aDAO.find(author.getId());
                            editorialAuthor.setEditorial(editorial);
                            aDAO.edit(editorialAuthor);
                        }
                    }
                }
                //Por último actualizo la editorial.
                em.merge(editorial);

                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
        }
    }

    public List<Editorial> findAll() {
        EntityManager em = Database.getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Editorial.class));
        List<Editorial> entities = em.createQuery(cq).getResultList();
        em.close();
        return entities;
    }

    public Editorial find(Long id) {
        EntityManager em = Database.getEntityManager();
        Editorial entity = em.find(Editorial.class, id);
        em.close();
        return entity;
    }

}
