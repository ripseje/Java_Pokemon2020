
package codigo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author xp
 */
public final class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    BufferedImage buffer2 = null;
    Image imagen1 = null;
    Image imagen2 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    HashMap<String, Pokemon> listaPokemons = new HashMap();
    
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    
    public VentanaPokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        try {
            imagen2 = ImageIO.read(getClass()
                    .getResource("/imagenes/pokedex.jpg"));
        } catch (IOException ex) {
        }
        
        buffer2 = (BufferedImage) jPanel1.createImage(
                jPanel1.getWidth(), jPanel1.getHeight());
        Graphics2D g2d = buffer2.createGraphics();
        
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaFondo();
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/test",
                            "root",
                            "");
            estado = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("select * from pokemon");
            //recorremos el array del resultado uno a uno
            //para ir cargándolo en el Hashmap
            
            while(resultadoConsulta.next()){
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString(2);
                p.especie = resultadoConsulta.getString(5);
                p.peso = resultadoConsulta.getString(4);
                p.preEvolucion = resultadoConsulta.getString(13);
                p.posEvolucion = resultadoConsulta.getString(14);
                p.id = resultadoConsulta.getString(1);
                p.altura = resultadoConsulta.getString(3);
                p.habitat = resultadoConsulta.getString(6);
                p.tipo1 = resultadoConsulta.getString(7);
                p.tipo2 = resultadoConsulta.getString(8);
                p.movimiento1 = resultadoConsulta.getString(9);
                p.movimiento2 = resultadoConsulta.getString(10);
                p.movimiento3 = resultadoConsulta.getString(11);
                p.movimiento4 = resultadoConsulta.getString(12);
                p.descripcion = resultadoConsulta.getString(16);
                
                listaPokemons.put(resultadoConsulta.getString(1), p);
                
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
        
        
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
    
    public void dibujaFondo(){
        Graphics2D g2 = (Graphics2D) buffer2.getGraphics();
        g2.setColor(Color.white);
        g2.drawImage(imagen2, 0, 0, jPanel1.getWidth(), jPanel1.getHeight(), null);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descrip = new javax.swing.JLabel();
        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        especiePokemon = new javax.swing.JLabel();
        habitatPokemon = new javax.swing.JLabel();
        tipo1 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        alturaL = new javax.swing.JLabel();
        pesoL = new javax.swing.JLabel();
        habitat = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        idPokemon = new javax.swing.JLabel();
        epecieL = new javax.swing.JLabel();
        nombrePokemon = new javax.swing.JLabel();
        verMas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        descrip.setBackground(new java.awt.Color(0, 0, 0));
        descrip.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        descrip.setForeground(new java.awt.Color(255, 255, 255));
        descrip.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descrip.setOpaque(true);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        especiePokemon.setBackground(new java.awt.Color(0, 0, 0));
        especiePokemon.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        especiePokemon.setForeground(new java.awt.Color(255, 255, 255));
        especiePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        especiePokemon.setOpaque(true);

        habitatPokemon.setBackground(new java.awt.Color(0, 0, 0));
        habitatPokemon.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        habitatPokemon.setForeground(new java.awt.Color(255, 255, 255));
        habitatPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        habitatPokemon.setOpaque(true);

        tipo1.setBackground(new java.awt.Color(0, 0, 0));
        tipo1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        tipo1.setForeground(new java.awt.Color(255, 255, 255));
        tipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo1.setOpaque(true);

        tipo2.setBackground(new java.awt.Color(0, 0, 0));
        tipo2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        tipo2.setForeground(new java.awt.Color(255, 255, 255));
        tipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo2.setOpaque(true);

        peso.setBackground(new java.awt.Color(0, 0, 0));
        peso.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        peso.setForeground(new java.awt.Color(255, 255, 255));
        peso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        peso.setOpaque(true);

        altura.setBackground(new java.awt.Color(0, 0, 0));
        altura.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        altura.setForeground(new java.awt.Color(255, 255, 255));
        altura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        altura.setOpaque(true);

        alturaL.setBackground(new java.awt.Color(0, 0, 0));
        alturaL.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        alturaL.setForeground(new java.awt.Color(255, 255, 255));
        alturaL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alturaL.setText("Altura:");
        alturaL.setOpaque(true);

        pesoL.setBackground(new java.awt.Color(0, 0, 0));
        pesoL.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        pesoL.setForeground(new java.awt.Color(255, 255, 255));
        pesoL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pesoL.setText("Peso:");
        pesoL.setOpaque(true);

        habitat.setBackground(new java.awt.Color(0, 0, 0));
        habitat.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        habitat.setForeground(new java.awt.Color(255, 255, 255));
        habitat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        habitat.setText("Habitat:");
        habitat.setOpaque(true);

        fondo.setBackground(new java.awt.Color(0, 0, 0));
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex.png"))); // NOI18N
        fondo.setOpaque(true);

        idPokemon.setBackground(new java.awt.Color(0, 0, 0));
        idPokemon.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        idPokemon.setForeground(new java.awt.Color(255, 255, 255));
        idPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idPokemon.setOpaque(true);

        epecieL.setBackground(new java.awt.Color(0, 0, 0));
        epecieL.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        epecieL.setForeground(new java.awt.Color(255, 255, 255));
        epecieL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        epecieL.setText("Especie: ");
        epecieL.setOpaque(true);

        nombrePokemon.setBackground(new java.awt.Color(0, 0, 0));
        nombrePokemon.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        nombrePokemon.setForeground(new java.awt.Color(255, 255, 255));
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setOpaque(true);

        verMas.setBackground(new java.awt.Color(255, 0, 0));
        verMas.setForeground(new java.awt.Color(255, 0, 0));
        verMas.setBorder(new RoundedBorder(10));
        verMas.setText("\n");
        verMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(verMas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alturaL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(habitat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(pesoL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(epecieL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(especiePokemon, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(peso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(habitatPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(altura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tipo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(idPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(descrip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 798, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verMas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombrePokemon, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alturaL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesoL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(habitatPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(habitat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(especiePokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(epecieL, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        //imprimePokemon();
        
        
        if (contador <=0){
            contador = 1;
        }
        Pokemon p = listaPokemons.get(String.valueOf(contador));
        dibujaElPokemonQueEstaEnLaPosicion(contador-1);
        if(p != null){
            idPokemon.setText(p.id);
            nombrePokemon.setText(p.nombre);
            altura.setText(p.altura);
            peso.setText(p.peso);
            especiePokemon.setText(p.especie);
            habitatPokemon.setText(p.habitat);
            String pTipo = p.tipo1;
                tipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                tipo1.setOpaque(true);
                if("".equals(p.tipo2)){
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                }else{
                    String sTipo = p.tipo2;
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + sTipo + ".png")));
                    tipo2.setOpaque(true);
                }
            /*tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);*/
            descrip.setText("<html>" + p.descripcion + "</html>");
            
        }else{
            nombrePokemon.setText("NO HAY DATOS");
        }
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        
        contador ++;
        if (contador >=150){
            contador = 150;
        }
        //imprimePokemon();
        Pokemon p = listaPokemons.get(String.valueOf(contador));
        dibujaElPokemonQueEstaEnLaPosicion(contador-1);
        if(p != null){
            idPokemon.setText(p.id);
            nombrePokemon.setText(p.nombre);
            altura.setText(p.altura);
            peso.setText(p.peso);
            especiePokemon.setText(p.especie);
            habitatPokemon.setText(p.habitat);
            String pTipo = p.tipo1;
                tipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                tipo1.setOpaque(true);
                if("".equals(p.tipo2)){
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                }else{
                    String sTipo = p.tipo2;
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + sTipo + ".png")));
                    tipo2.setOpaque(true);
                }
            /*tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);*/
            descrip.setText("<html>" + p.descripcion + "</html>");
            
        }else{
            nombrePokemon.setText("NO HAY DATOS");
        }
        
        
    }//GEN-LAST:event_derActionPerformed

    private void verMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMasActionPerformed
        if (contador <= 74){
            contador = 150;
        } else{
            contador = 0;
        }
        Pokemon p = listaPokemons.get(String.valueOf(contador));
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        if(p != null){
            idPokemon.setText(p.id);
            nombrePokemon.setText(p.nombre);
            altura.setText(p.altura);
            peso.setText(p.peso);
            especiePokemon.setText(p.especie);
            habitatPokemon.setText(p.habitat);
            String pTipo = p.tipo1;
                tipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                tipo1.setOpaque(true);
                if("".equals(p.tipo2)){
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                }else{
                    String sTipo = p.tipo2;
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + sTipo + ".png")));
                    tipo2.setOpaque(true);
                }
            /*tipo1.setText(p.tipo1);
            tipo2.setText(p.tipo2);*/
            descrip.setText("<html>" + p.descripcion + "</html>");
        }else{
            nombrePokemon.setText("NO HAY DATOS");
        }
    }//GEN-LAST:event_verMasActionPerformed
    
    private void imprimePokemon(){
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador+1));
            if(resultadoConsulta.next()){
                idPokemon.setText(resultadoConsulta.getString(1) + "º");
                nombrePokemon.setText(resultadoConsulta.getString(2));
                peso.setText(resultadoConsulta.getString(4) + " kg");
                altura.setText(resultadoConsulta.getString(3) + " m");
                especiePokemon.setText(resultadoConsulta.getString(5));
                habitatPokemon.setText(resultadoConsulta.getString(6));
                String pTipo = resultadoConsulta.getString(7);
                tipo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                tipo1.setOpaque(true);
                if("".equals(resultadoConsulta.getString(8))){
                    String sTipo = "No tiene";
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + pTipo + ".png")));
                }else{
                    String sTipo = resultadoConsulta.getString(8);
                    tipo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipos/" + sTipo + ".png")));
                    tipo2.setOpaque(true);
                }
                descrip.setText("<html>" + resultadoConsulta.getString(16) + "</html>");
                
            }
            else{
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
            }
        } catch (SQLException ex) {
            System.err.println("Error con la base de datos");
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
    }
    
    private static class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+2, this.radius+2, this.radius+2, this.radius+2);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altura;
    private javax.swing.JLabel alturaL;
    private javax.swing.JButton der;
    private javax.swing.JLabel descrip;
    private javax.swing.JLabel epecieL;
    private javax.swing.JLabel especiePokemon;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel habitat;
    private javax.swing.JLabel habitatPokemon;
    private javax.swing.JLabel idPokemon;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel pesoL;
    private javax.swing.JLabel tipo1;
    private javax.swing.JLabel tipo2;
    private javax.swing.JButton verMas;
    // End of variables declaration//GEN-END:variables
}
