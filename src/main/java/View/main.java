/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AutorController;
import Controller.IAutorController;
import Controller.ILibroController;
import Controller.LibroController;
import Exceptions.AutorException;
import Exceptions.DAO_Excep;
import Exceptions.LibroException;
import Model.Autor;
import Model.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author st2022270
 */
public class main extends javax.swing.JFrame {
private static final IAutorController iAcont = new AutorController();
private static final ILibroController iLibcon = new LibroController();
    /**
     * Creates new form principal
     */
    public main() {
        initComponents();
        JOptionPane.showMessageDialog(this, "Bienvenido al programa inicializando", "Iniciando Programa", JOptionPane.INFORMATION_MESSAGE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        borrarL = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        registrarL = new javax.swing.JButton();
        modificarL = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        registrarA = new javax.swing.JButton();
        modificarA = new javax.swing.JButton();
        borrarA = new javax.swing.JButton();
        consultaL = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        Titulo.setFont(new java.awt.Font("Kristen ITC", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Titulo.setText("Biblioteca");

        borrarL.setBackground(new java.awt.Color(204, 102, 255));
        borrarL.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        borrarL.setText("Borrar Libro");
        borrarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarLActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Libros");

        registrarL.setBackground(new java.awt.Color(204, 102, 255));
        registrarL.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        registrarL.setText("Registrar Libro");
        registrarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarLActionPerformed(evt);
            }
        });

        modificarL.setBackground(new java.awt.Color(204, 102, 255));
        modificarL.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        modificarL.setText("Modificar Libro");
        modificarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarLActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Autor");

        registrarA.setBackground(new java.awt.Color(204, 102, 255));
        registrarA.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        registrarA.setText("Registrar Autor");
        registrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarAActionPerformed(evt);
            }
        });

        modificarA.setBackground(new java.awt.Color(204, 102, 255));
        modificarA.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        modificarA.setText("Modificar Autor");
        modificarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarAActionPerformed(evt);
            }
        });

        borrarA.setBackground(new java.awt.Color(204, 102, 255));
        borrarA.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        borrarA.setText("Borrar Autor");
        borrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarAActionPerformed(evt);
            }
        });

        consultaL.setBackground(new java.awt.Color(204, 102, 255));
        consultaL.setFont(new java.awt.Font("Kristen ITC", 0, 18)); // NOI18N
        consultaL.setText("Consultar Libro");
        consultaL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaLActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(registrarL, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarA, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(Titulo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(consultaL, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarA, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registrarL, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarL, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrarL, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(consultaL, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarAActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de modificar autor
        List<Autor> aus = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
        } catch (DAO_Excep | AutorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty()) {
            ModificarAutor modAutor = new ModificarAutor();
            modAutor.setLocationRelativeTo(null);
            modAutor.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun autor creado", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modificarAActionPerformed

    private void registrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarAActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de registrar autor
        RegistrarAutor regAutor = new RegistrarAutor();
        regAutor.setLocationRelativeTo(null);
        regAutor.setVisible(true);
    }//GEN-LAST:event_registrarAActionPerformed

    private void borrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarAActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de borrar autor
        List<Autor> aus = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
        } catch (DAO_Excep | AutorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty()) {
            BorrarAutor borAutor = new BorrarAutor();
            borAutor.setLocationRelativeTo(null);
            borAutor.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun autor creado", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_borrarAActionPerformed

    private void registrarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarLActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de registar libro
        List<Autor> aus = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
        } catch (DAO_Excep | AutorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty()) {
            RegistrarLibro regLib = new RegistrarLibro();
            regLib.setLocationRelativeTo(null);
            regLib.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun autor creado", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrarLActionPerformed

    private void modificarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarLActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de modificar libro
        List<Autor> aus = new ArrayList<>();
        List<Libro> libs = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
            libs = iLibcon.readAllLibro();
        } catch (DAO_Excep | AutorException | LibroException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty() && !libs.isEmpty()) {
            ModificarLibro modLib = new ModificarLibro();
            modLib.setLocationRelativeTo(null);
            modLib.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun registro", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarLActionPerformed

    private void consultaLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaLActionPerformed
        //Cuando el usuario clicke sobre el lo enviara a el jframe de consultar libro
         List<Autor> aus = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
        } catch (DAO_Excep | AutorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty()) {
            ConsultarLibro consLib = new ConsultarLibro();
            consLib.setLocationRelativeTo(null);
            consLib.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun registro", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consultaLActionPerformed

    private void borrarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarLActionPerformed
//        ///Cuando el usuario clicke sobre el lo enviara a el jframe de borrar libro
        List<Autor> aus = new ArrayList<>();
        List<Libro> libs = new ArrayList<>();
        try {
            aus = iAcont.readAllAutors();
            libs = iLibcon.readAllLibro();
        } catch (DAO_Excep | AutorException | LibroException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de lectura autores", JOptionPane.ERROR_MESSAGE);
        }
       if (!aus.isEmpty() && !libs.isEmpty()) {
            BorrarLibro delLib = new BorrarLibro();
            delLib.setLocationRelativeTo(null);
            delLib.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun autor creado", "Error en registro de Libro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_borrarLActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        writeAutoresFile();
//        writeLibrosFile();
        JOptionPane.showMessageDialog(this, "Gracias por utilizar el programa guardando datos", "Finalizar Programa", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Adios");
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(this, "Bienvenido al programa inicializando", "Iniciando Programa", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*Leer fichero*/
//        try {
//            readAutoresFile();
//        } catch (AutorException e) {
//            System.out.println("Error de lectura de ficheros Autores");
//        }
//        try {
//            readLibrosFile();
//        } catch (LibroException e) {
//            System.out.println("Error de lectura de ficheros Libros");
//        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
//        writeAutoresFile();
//        writeLibrosFile();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton borrarA;
    private javax.swing.JButton borrarL;
    private javax.swing.JButton consultaL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modificarA;
    private javax.swing.JButton modificarL;
    private javax.swing.JButton registrarA;
    private javax.swing.JButton registrarL;
    // End of variables declaration//GEN-END:variables

}