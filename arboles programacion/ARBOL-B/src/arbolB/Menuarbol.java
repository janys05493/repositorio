package arbolB;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
public class Menuarbol extends javax.swing.JFrame {
    ListaB datos;
    Metodos raiz1;
    boolean ya = false;
    boolean existe = false;
    Metodos raizAux = new Metodos(2);
    public Menuarbol() {
    	setTitle("ARBOL B NUMEROS ENTEROS");
        initComponents();
    }

    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        frameArbol = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        frameArbol.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel4.setText("El Arbol B con los valores ingresados esta asi: ");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout frameArbolLayout = new javax.swing.GroupLayout(frameArbol.getContentPane());
        frameArbol.getContentPane().setLayout(frameArbolLayout);
        frameArbolLayout.setHorizontalGroup(
            frameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameArbolLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(frameArbolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        frameArbolLayout.setVerticalGroup(
            frameArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameArbolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setToolTipText("Numero entero");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setToolTipText("Numero entero");
        jTextField3.setPreferredSize(new java.awt.Dimension(73, 20));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setToolTipText("Numero entero");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(33)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jTextField3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        				.addComponent(jButton3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(jButton2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jTextField2, Alignment.LEADING)
        					.addComponent(jButton1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jTextField1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
        			.addGap(31))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jTextField1)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton1)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jTextField2)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jTextField3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(5)
        			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setToolTipText("Grado");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton5.setText("ORDEN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton4 = new javax.swing.JButton();
        
                jButton4.setText("Ver Arbol");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton4ActionPerformed(evt);
                    }
                });
        
        btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        				.addComponent(jButton5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        				.addComponent(jTextField4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        				.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton5)
        			.addGap(37)
        			.addComponent(jButton4)
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addComponent(btnSalir)
        			.addGap(22))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        
        if(!jTextField2.getText().equals("")){
        boolean numero = raizAux.COMPROBARENTERO(jTextField2.getText());
        if(numero){
        if(ya){
        boolean esta = raiz1.BUSCARNUMERO(Integer.parseInt(jTextField2.getText()));
        if(esta){
            JOptionPane.showMessageDialog(this, "El elemento " + 
                    jTextField2.getText() + " SI se encuentra en el arbol B",
               "Dato encontrado!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "El elemento " + 
                    jTextField2.getText() + " NO se encuentra en el arbol B",
               "Dato no encontrado!!!", JOptionPane.WARNING_MESSAGE);
        }
        
      }else{
          JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
               "Error!!", JOptionPane.WARNING_MESSAGE);
      }
      
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese numeros entero diferentes de 0",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
      }else{
          JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
               "Error!!", JOptionPane.WARNING_MESSAGE);
      }
      jTextField2.setText("");  
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        raiz1.TREE = "";
        if(ya){
        String raiz = "raiz [ ";
        for(int i = 0; i < raiz1.NUEVO.NUMEROS.length && raiz1.NUEVO.NUMEROS[i] != 0; i++){
            raiz += raiz1.NUEVO.NUMEROS[i] + ", ";
        }
        raiz += " ]\n";
        raiz += raiz1.IMPRIMIR();
        jTextArea1.setText(raiz);
        }
        frameArbol.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
            raiz1.TREE = "";
            if(!jTextField4.getText().equals("")){
            boolean numero = raizAux.COMPROBARENTERO(jTextField4.getText());
            if(numero){
                if(!(Integer.parseInt(jTextField4.getText()) < 1)){
                    datos = new ListaB();
                    existe = true;
                    raiz1 = new Metodos(Integer.parseInt(jTextField4.getText()));
                     JOptionPane.showMessageDialog(this, "se ha creado un nuevo arbol de grado " 
                             + jTextField4.getText(),
               "Novedad", JOptionPane.WARNING_MESSAGE);
                    ya = true;
                }else{
                    JOptionPane.showMessageDialog(this, "Ingrese un grado entero mayor o igual que 1",
               "Error!!", JOptionPane.WARNING_MESSAGE);
                    
                }
            }else{
               JOptionPane.showMessageDialog(this, "Ingrese un grado entero mayor o igual que 1",
               "Error!!", JOptionPane.WARNING_MESSAGE); 
            }
        }else{
           JOptionPane.showMessageDialog(this, "Ingrese datos en el campo de texto",
               "Error!!", JOptionPane.WARNING_MESSAGE); 
        }
        jTextField4.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        if(!jTextField1.getText().equals("")){
            boolean numero = raizAux.COMPROBARENTERO(jTextField1.getText());
            if(numero){
        boolean adentro = false;
        if(existe){
        for(int i = 0; i < datos.INSERTADOSARRAY.size(); i++){
            if(datos.INSERTADOSARRAY.get(i) == Integer.parseInt(jTextField1.getText())){
                 adentro = true;
            }
        }
        }
        if(!adentro){
        if(!jTextField1.getText().equals("")){
            if(!jTextField1.getText().equals("0")){ 
            if(ya){    
        raiz1.INGRESAR1(Integer.parseInt(jTextField1.getText()));
        JOptionPane.showMessageDialog(this, "INSERTANDO" + 
                    jTextField1.getText(),
               "Novedad", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "INGRESE EL ORDEN EN EL ARBOL",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
           }else{
               JOptionPane.showMessageDialog(this, "INSERTE DATOS DIFERENTES A CERO",
               "Error!!", JOptionPane.WARNING_MESSAGE);
           }   
            
        }else{
           JOptionPane.showMessageDialog(this, "INSERTE DATOS",
               "Error!!", JOptionPane.WARNING_MESSAGE); 
        }
        }else{
            JOptionPane.showMessageDialog(this, "ESTE ELEMENTO YA EXISTE",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
            }else{
                JOptionPane.showMessageDialog(this, "INSERTE NUMEROS ENTEROS DIFERENTES A CERO",
               "Error!!", JOptionPane.WARNING_MESSAGE);
            }
    }else{
          JOptionPane.showMessageDialog(this, "INSERTE UN NUMERO",
               "Error!!", JOptionPane.WARNING_MESSAGE);   
        }
        jTextField1.setText("");
        
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        boolean esta = false;
        boolean numero = raizAux.COMPROBARENTERO(jTextField3.getText());
        if(!jTextField3.getText().equals("")){ 
            if(numero){
            if(ya){
            for(int i = 0; i < datos.INSERTADOSARRAY.size(); i++){
                if(datos.INSERTADOSARRAY.get(i) == Integer.parseInt(jTextField3.getText())){
                    esta = true;
                }
            }    
             raiz1.BORRAR(Integer.parseInt(jTextField3.getText()));
             if(esta){
           JOptionPane.showMessageDialog(this, "ELIMINADO: " + jTextField3.getText(),
               "Novedad", JOptionPane.WARNING_MESSAGE);
             }else{
               JOptionPane.showMessageDialog(this, "NO ESTA: " + jTextField3.getText(),
               "Novedad", JOptionPane.WARNING_MESSAGE);  
             }
            }else{
                JOptionPane.showMessageDialog(this, "ERROR, CREE EL ARBOL",
               "Error!!", JOptionPane.WARNING_MESSAGE);
            }
                
         }else{
             JOptionPane.showMessageDialog(this, "NUMERO ENTEROS DISTINTOS DE 0",
               "Novedad", JOptionPane.WARNING_MESSAGE);
                
         }
         jTextField3.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "INSERTE DATOS",
               "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuarbol().setVisible(true);
            }
        });
    }

    private javax.swing.JFrame frameArbol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private JButton btnSalir;

}