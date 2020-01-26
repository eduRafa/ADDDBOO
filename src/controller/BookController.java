/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Book;
import bean.dao.BookDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Hermosilla Aguilera
 */
public class BookController {


    //Lista todos los libros
    public List<Book> getAllBooks() {
        BookDAO BDAO = new BookDAO();
        return BDAO.findAll();
    }

    //Lista un libro según la id especificada
    public Book getBook(Long id) {
        BookDAO BDAO = new BookDAO();
        return BDAO.find(id);
    }

    //Inserta un libro
    public void insertBooks(Book bk) {
        BookDAO BDAO = new BookDAO();
        BDAO.create(bk);
    }

    //Elimina un libro
    public void deleteBook(Long id) {
        BookDAO BDAO = new BookDAO();
        BDAO.remove(id);
    }

    //Edita un libro
    public void editBooks(Book bk) {
        BookDAO BDAO = new BookDAO();
        BDAO.edit(bk);
    }
}
