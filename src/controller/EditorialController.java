/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Editorial;
import bean.dao.EditorialDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Hermosilla Aguilera
 */
public class EditorialController {
    

    //Lista todos las editoriales
    public List<Editorial> getAllEditorials() {
        EditorialDAO EDAO = new EditorialDAO();
        return EDAO.findAll();
    }

    //Lista una editorial según la id especificada
    public Editorial getEditorial(Long id) {
        EditorialDAO EDAO = new EditorialDAO();
        return EDAO.find(id);
    }

    //Inserta una editorial
    public void insertEditorial(Editorial edtl) {
        EditorialDAO EDAO = new EditorialDAO();
        EDAO.create(edtl);
    }

    //Elimina una editorial
    public void deleteEditorial(Long id) {
        EditorialDAO EDAO = new EditorialDAO();
        EDAO.remove(id);
    }

    //Edita una editorial
    public void editEditorial(Editorial edtl) {
        System.out.println("controler");
        EditorialDAO EDAO = new EditorialDAO();
        EDAO.edit(edtl);
    }
    
}
