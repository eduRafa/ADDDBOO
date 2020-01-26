/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadd_dboo.frames.autores;

import aadd_dboo.frames.editoriales.*;
import bean.Author;
import bean.Book;
import bean.Editorial;
import bean.dao.EditorialDAO;
import controller.AuthorController;
import controller.BookController;
import controller.EditorialController;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Antonio
 */
public class AutoresFrame extends javax.swing.JFrame {

    EditorialController editorialController;
    DefaultListModel modelLibros;
    DefaultListModel modelTodosLibros;
    DefaultListModel modelEditoriales;
    DefaultListModel modelTodasEditoriales;
    AuthorController authorController;
    BookController bookController;

    public AutoresFrame() {
        initComponents();
        nombreErrorJLabel.setVisible(false);
        idJLabel.setVisible(false);
        botonGuardar.setEnabled(false);
        editorialController = new EditorialController();
        authorController = new AuthorController();
        modelLibros = new DefaultListModel();
        modelTodosLibros = new DefaultListModel();
        modelEditoriales = new DefaultListModel();
        modelTodasEditoriales = new DefaultListModel();
        todosLibrosJList.setModel(modelTodosLibros);
        librosJList.setModel(modelLibros);
        bookController = new BookController();
        cargarTabla();
        autoresTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Long id = (Long) autoresTable.getValueAt(autoresTable.getSelectedRow(), 0);
                    cargarAutor(id);
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idJLabel = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botonEditar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        autoresTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};
            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            nombreJTextField = new javax.swing.JTextField();
            jScrollPane2 = new javax.swing.JScrollPane();
            librosJList = new javax.swing.JList<>();
            jScrollPane3 = new javax.swing.JScrollPane();
            todosLibrosJList = new javax.swing.JList<>();
            nombreErrorJLabel = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            edadJTextField = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            fNacimientoJTextField = new javax.swing.JTextField();
            jButton3 = new javax.swing.JButton();
            jButton4 = new javax.swing.JButton();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            editorialJComboBox = new javax.swing.JComboBox<>();

            idJLabel.setText("-1");

            jToolBar2.setRollover(true);

            botonNuevo.setText("Nuevo");
            botonNuevo.setFocusable(false);
            botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            botonNuevo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonNuevoActionPerformed(evt);
                }
            });
            jToolBar2.add(botonNuevo);
            jToolBar2.add(jSeparator1);

            botonEditar.setText("Editar");
            botonEditar.setFocusable(false);
            botonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            botonEditar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonEditarActionPerformed(evt);
                }
            });
            jToolBar2.add(botonEditar);

            botonEliminar.setText("Eliminar");
            botonEliminar.setFocusable(false);
            botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            botonEliminar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonEliminarActionPerformed(evt);
                }
            });
            jToolBar2.add(botonEliminar);
            jToolBar2.add(jSeparator2);

            botonGuardar.setText("Guardar");
            botonGuardar.setFocusable(false);
            botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            botonGuardar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonGuardarActionPerformed(evt);
                }
            });
            jToolBar2.add(botonGuardar);

            autoresTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(autoresTable);

            jLabel1.setText("Nombre");

            jScrollPane2.setViewportView(librosJList);

            jScrollPane3.setViewportView(todosLibrosJList);

            nombreErrorJLabel.setForeground(new java.awt.Color(255, 0, 0));
            nombreErrorJLabel.setText("El nombre es obligatorio");

            jLabel3.setText("Edad");

            edadJTextField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    edadJTextFieldActionPerformed(evt);
                }
            });

            jLabel4.setText("Fecha Nacimiento");

            fNacimientoJTextField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fNacimientoJTextFieldActionPerformed(evt);
                }
            });

            jButton3.setText("-");
            jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton3MouseClicked(evt);
                }
            });
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            jButton4.setText("+");
            jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton4MouseClicked(evt);
                }
            });
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            jLabel5.setText("Libros");

            jLabel6.setText("Editorial");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton4)
                                .addComponent(jButton3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(fNacimientoJTextField)
                                            .addGap(26, 26, 26))
                                        .addComponent(editorialJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(edadJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombreErrorJLabel)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreErrorJLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edadJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(fNacimientoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(editorialJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addGap(82, 82, 82))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idJLabel)
                            .addGap(76, 76, 76))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(idJLabel)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        limpiar();
        idJLabel.setText("-1");
        botonGuardar.setEnabled(true);
        cargarTodosLibros();
        DefaultComboBoxModel db = new DefaultComboBoxModel(editorialController.getAllEditorials().toArray());
        editorialJComboBox.setModel(db);

    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        if (autoresTable.getSelectedRow() != -1) {
            Long id = (Long) autoresTable.getValueAt(autoresTable.getSelectedRow(), 0);
            cargarAutor(id);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        if (autoresTable.getSelectedRow() != -1) {
            long id = (long) autoresTable.getValueAt(autoresTable.getSelectedRow(), 0);
            limpiar();
            botonGuardar.setEnabled(false);
            authorController.deleteAuthor(id);
            cargarTabla();
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        if (nombreJTextField.getText().length() > 0) {
            nombreErrorJLabel.setVisible(false);
            Author a = new Author();
            if (!idJLabel.getText().equals("-1")) {
                a.setId(Long.parseLong(idJLabel.getText()));
            }

            a.setName(nombreJTextField.getText());
            if (edadJTextField.getText().length() > 0) {
                a.setAge(Integer.valueOf(edadJTextField.getText()));
            }
            if (fNacimientoJTextField.getText().length() > 0) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = formatter.parse(fNacimientoJTextField.getText());
                    a.setBithday(date);
                } catch (ParseException ex) {

                }
            }
            a.setEditorial((Editorial) editorialJComboBox.getSelectedItem());
            if (modelLibros.getSize() > 0) {
                List<Book> libros = new ArrayList<>();
                for (int i = 0; i < modelLibros.size(); i++) {
                    libros.add((Book) modelLibros.getElementAt(i));
                }
                a.setBooks(libros);
            }

            if (idJLabel.getText().equals("-1")) {
                authorController.insertAuthor(a);
            } else {
                authorController.editAuthor(a);
            }
            limpiar();
            idJLabel.setText("-1");
            botonGuardar.setEnabled(false);
            cargarTabla();
        } else {
            nombreErrorJLabel.setVisible(true);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void edadJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadJTextFieldActionPerformed

    private void fNacimientoJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNacimientoJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNacimientoJTextFieldActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (librosJList.getSelectedIndex() != -1) {
            modelTodosLibros.addElement(modelLibros.getElementAt(librosJList.getSelectedIndex()));
            modelLibros.removeElementAt(librosJList.getSelectedIndex());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (todosLibrosJList.getSelectedIndex() != -1) {
            modelLibros.addElement(modelTodosLibros.getElementAt(todosLibrosJList.getSelectedIndex()));
            modelTodosLibros.removeElementAt(todosLibrosJList.getSelectedIndex());
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable autoresTable;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JTextField edadJTextField;
    private javax.swing.JComboBox<String> editorialJComboBox;
    private javax.swing.JTextField fNacimientoJTextField;
    private javax.swing.JLabel idJLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JList<String> librosJList;
    private javax.swing.JLabel nombreErrorJLabel;
    private javax.swing.JTextField nombreJTextField;
    private javax.swing.JList<String> todosLibrosJList;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        List<Author> autores = authorController.getAllAuthors();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{
            {null, null},},
                new String[]{
                    "ID", "Nombre"
                });
        autoresTable.setModel(model);
        if (autores != null) {
            for (int i = 1; i < autores.size(); i++) {
                model.addRow(new Object[][]{{null, null}});
            }
            for (int i = 0; i < autores.size(); i++) {
                autoresTable.setValueAt(autores.get(i).getId(), i, 0);
                autoresTable.setValueAt(autores.get(i).getName(), i, 1);
            }
        }
    }

    private void limpiar() {
        this.nombreJTextField.setText(null);
        this.edadJTextField.setText(null);
        this.fNacimientoJTextField.setText(null);
        this.modelLibros.removeAllElements();
        this.modelTodosLibros.removeAllElements();
        this.editorialJComboBox.removeAllItems();
    }

    private void cargarTodosLibros() {
        List<Book> libros = null;
        modelTodosLibros.removeAllElements();
        libros = bookController.getAllBooks();
        if (libros != null) {
            for (int i = 0; i < libros.size(); i++) {
                if (!comprobarID((int) (long) libros.get(i).getId())) {
                    modelTodosLibros.addElement(libros.get(i));
                }
            }
        }
    }

    private boolean comprobarID(int id) {
        boolean found = false;
        for (int i = 0; i < modelLibros.getSize() && !found; i++) {
            Book b = (Book) modelLibros.getElementAt(i);
            if (id == (int) (long) b.getId()) {
                found = true;
            }
        }
        return found;
    }

    private void cargarAutor(Long id) {
        DefaultComboBoxModel db = new DefaultComboBoxModel(editorialController.getAllEditorials().toArray());
        editorialJComboBox.setModel(db);
        Author a = authorController.getAuthor(id);
        editorialJComboBox.setSelectedItem(a.getEditorial());
        idJLabel.setText(a.getId().toString());
        nombreJTextField.setText(a.getName());
        modelLibros.removeAllElements();
        if (a.getBooks() != null) {
            for (int i = 0; i < a.getBooks().size(); i++) {
                modelLibros.addElement(a.getBooks().get(i));
            }
        }
        if (a.getAge() != null) {
            edadJTextField.setText(String.valueOf(a.getAge()));
        }
        if (a.getBithday() != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            fNacimientoJTextField.setText(formatter.format(a.getBithday()));
        }
        cargarTodosLibros();
        botonGuardar.setEnabled(true);

    }
}