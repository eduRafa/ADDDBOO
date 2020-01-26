/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Author;
import bean.dao.AuthorDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Hermosilla Aguilera
 */
public class AuthorController {


    //Lista todos los autores
    public List<Author> getAllAuthors() {
        AuthorDAO ADAO = new AuthorDAO();
        return ADAO.findAll();
    }

    //Lista un autor según la id especificada
    public Author getAuthor(Long id) {
        AuthorDAO ADAO = new AuthorDAO();
        return ADAO.find(id); 
    }

    //Inserta un autor
    public void insertAuthor(Author aut) {
        AuthorDAO ADAO = new AuthorDAO();
        System.out.println("ola");
        ADAO.create(aut);
    }

    //Elimina un autor
    public void deleteAuthor(Long id) {
        AuthorDAO ADAO = new AuthorDAO();
        ADAO.remove(id);
    }

    //Edita un autor
    public void editAuthor(Author aut) {
        AuthorDAO ADAO = new AuthorDAO();
        ADAO.edit(aut);
    }
    
    
  
    
    
}
