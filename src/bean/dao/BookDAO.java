/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.dao;

import bean.Author;
import bean.Book;
import database.Database;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rafae
 */
public class BookDAO {

    public BookDAO() {
    }

    public void create(Book book) {
        if (book != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();
                //En primer lugar persisto el libro
                em.persist(book);

                //Posteriormente recorroro todos los autores y agrego el nuevo libro
                if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
                    for (Author author : book.getAuthors()) {                   //Recorroro todos los autores para añadir el nuevo libro.
                        if (author != null) {
                            Author bookAuthor = em.find(Author.class, author.getId());
                            if (bookAuthor != null) {
                                if (bookAuthor.getBooks() == null) {
                                    List<Book> authorBooks = new ArrayList<>();
                                    authorBooks.add(book);
                                    bookAuthor.setBooks(authorBooks);
                                } else {
                                    List<Book> authorBooks = bookAuthor.getBooks();
                                    authorBooks.add(book);
                                    bookAuthor.setBooks(authorBooks);
                                }
                            }
                        }
                    }
                }

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

    public void remove(Long id) {
        if (id != null) {
            EntityManager em = Database.getEntityManager();
            try {
                em.getTransaction().begin();

                //Se ha de buscar con el mismo entity manager, ya que sino al ejecutar remove,
                //lanzará una excepción con el mensaje 'Attempt to remove a detached entity object',
                //ya que remove solo funciona con entidades en el contexto de una misma transacción,
                Book e = em.find(Book.class, id);

                List<Author> bookAuthors = e.getAuthors();
                if (bookAuthors != null && !bookAuthors.isEmpty()) {
                    for (Author bookAuthor : bookAuthors) {// Obtengo  todos los autores que escribieron este libro
                        Author a = em.find(Author.class, bookAuthor.getId());
                        if (a != null && a.getId() != null) {
                            List<Book> authorBooks = a.getBooks(); //Obtengo todos los libros del autor.
                            if (authorBooks != null && !authorBooks.isEmpty()) {
                                boolean removed = false;
                                for (int i = 0; i < authorBooks.size() && !removed; i++) {
                                    if (id.intValue() == authorBooks.get(i).getId().intValue()) {//Elimino el libro del autor si coincide con este.
                                        authorBooks.remove(i);
                                        a.setBooks(authorBooks);
                                        em.merge(a);
                                        removed = true;
                                    }
                                }
                            }
                        }
                    }
                }

                //Finalmente remuevo el libro.
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

    public void edit(Book book) {

    }

    public List<Book> findAll() {
        EntityManager em = Database.getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Book.class));
        List<Book> entities = em.createQuery(cq).getResultList();
        em.close();
        return entities;
    }

    public Book find(Long id) {
        EntityManager em = Database.getEntityManager();
        Book entity = em.find(Book.class, id);
        em.close();
        return entity;
    }

}
