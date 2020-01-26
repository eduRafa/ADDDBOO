/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.dao;

import bean.Author;
import bean.Book;
import bean.Editorial;
import database.Database;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rafae
 */
public class AuthorDAO {

    public AuthorDAO() {
    }

    public void create(Author author) {
        EntityManager em = Database.getEntityManager();
        try {
            em.getTransaction().begin();

            //Ya que el objeto editorial del author no el mismo objeto que el de la base de datos,
            // busco dicho objeto y lo seteo en el autor.
            Editorial e = null;
            if (author.getEditorial() != null && author.getEditorial().getId() != null) {
                e = em.find(Editorial.class, author.getEditorial().getId());
            }
            author.setEditorial(e);

            //Ya que el array de libros del author no el mismo objeto que el de la base de datos,
            // busco dicho array y lo seteo en el autor.
            List<Book> books = null;
            if (author.getBooks() != null && !author.getBooks().isEmpty()) {
                books = new ArrayList<>();
                for (Book book : author.getBooks()) {
                    if (book != null && book.getId() != null) {
                        books.add(em.find(Book.class, book.getId()));
                    }
                }
            }
            author.setBooks(books);

            //Añado el autor
            em.persist(author);
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

    public void remove(Long id) {
        if (id != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();

                //Busco el objeto Author en la base de datos.
                Author guiAutho = em.find(Author.class, id);

                //Elimino la relación(seteando los campos a null) en la clase Author,
                //ya que es la propietara de la relación en ambos casos y esto hará
                //que se elimine la relación bidireccionalmente
                guiAutho.setBooks(null);
                guiAutho.setEditorial(null);
                //em.merge(guiAutho);
                //Posteriormente elimino el autor
                em.remove(guiAutho);
                em.getTransaction().commit();
            } catch (Exception e) {

            } finally {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
            em.close();
        }
    }

    public void edit(Author author) {
        if (author != null && author.getId() != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();

                //Ya que el objeto editorial del author no el mismo objeto que el de la base de datos,
                // busco dicho objeto y lo seteo en el autor.
                List<Book> books = null;
                if (author.getBooks() != null && !author.getBooks().isEmpty()) {
                    BookDAO bDAO = new BookDAO();
                    books = new ArrayList<>();
                    for (Book book : author.getBooks()) {
                        if (book != null && book.getId() != null) {
                            books.add(bDAO.find(book.getId()));
                        }
                    }
                }
                author.setBooks(books);

                //Ya que el array de libros del author no el mismo objeto que el de la base de datos,
                // busco dicho array y lo seteo en el autor.
                EditorialDAO eDAO = new EditorialDAO();
                if (author.getEditorial() != null && author.getEditorial().getId() != null) {
                    author.setEditorial(eDAO.find(author.getEditorial().getId()));
                }
                
                //Finalmente edito el author
                em.merge(author);
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

    public List<Author> findAll() {
        EntityManager em = Database.getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Author.class));
        List<Author> entities = em.createQuery(cq).getResultList();
        em.close();
        return entities;
    }

    public Author find(Long id) {
        EntityManager em = Database.getEntityManager();
        Author entity = em.find(Author.class, id);
        em.close();
        return entity;
    }

}
