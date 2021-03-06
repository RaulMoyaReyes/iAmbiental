/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ujaen.iambiental.modelosimulacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.*;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Agustín Ruiz Linares <www.agustruiz.es>
 */
public class Interfaz extends javax.swing.JFrame {

    //Variables del sistema
    boolean enFuncionamiento;
    EmisorUDP socket;
    ReceptorUDP receptorUDP;
    GeneradorTemperatura gt;

    /**
     * Creates new form Main
     */
    public Interfaz() {
        //Inicializar componentes
        initComponents();
        //Marcar que no está en funcionamiento
        this.enFuncionamiento = false;

        //Cargar las lecturas de temperatura
        gt = new GeneradorTemperatura();

        //Inicializar servidor UDP de test
        String ipReceptorUDP = this.getLocalIp();
        Integer puertoReceptorUDP = 60000;
        receptorUDP = new ReceptorUDP(ipReceptorUDP, puertoReceptorUDP, this);
        receptorUDP.start();
    }

    /**
     * Establecer label de datos del servidor UDP
     *
     * @param label Etiqueta de datos del servidor (ip:puerto)
     */
    public void setLblDatosServidorUDP(String label) {
        this.lblDatosServidorUDP.setText(label);
    }

    /**
     * Añade una cadena al log del Servidor UDP
     *
     * @param mensaje Cadena a insertar en el log del Servidor UDP
     */
    public void addLogServidorUDP(String mensaje) {
        this.txtServidorUDP.setText(this.txtServidorUDP.getText() + mensaje);
    }

    /**
     * Añade una cadena al log
     *
     * @param mensaje Cadena a insertar en el log
     */
    public void addLog(String mensaje) {
        this.txtLog.setText(this.txtLog.getText() + mensaje);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarSimulacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpConfiguracion = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        btnEnviarMensaje = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnEnviarLecturas = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbDiaInicio = new javax.swing.JComboBox();
        cmbMesInicio = new javax.swing.JComboBox();
        cmbAnyoInicio = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbHoraInicio = new javax.swing.JComboBox();
        cmbDiaFin = new javax.swing.JComboBox();
        cmbMesFin = new javax.swing.JComboBox();
        cmbAnyoFin = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbHoraFin = new javax.swing.JComboBox();
        jpServerUDP = new javax.swing.JPanel();
        lblDatosServidorUDP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtServidorUDP = new javax.swing.JTextArea();
        jpLog = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iAmbiental - Modelo de Simulación");
        setMinimumSize(new java.awt.Dimension(450, 420));
        setPreferredSize(new java.awt.Dimension(600, 420));

        btnIniciarSimulacion.setText("Iniciar");
        btnIniciarSimulacion.setFocusable(false);
        btnIniciarSimulacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarSimulacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIniciarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSimulacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha y hora:");

        lblFecha.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblFecha.setText("--/--/---- --:--:--");

        jLabel12.setText("Dirección IP");

        txtIp.setText("localhost");

        txtPuerto.setText("60000");
        txtPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuertoActionPerformed(evt);
            }
        });

        jLabel13.setText("Puerto");

        jLabel14.setText("Mensaje");

        txtMensaje.setText("Mensaje de prueba");
        txtMensaje.setEnabled(false);

        btnEnviarMensaje.setText("Enviar");
        btnEnviarMensaje.setEnabled(false);
        btnEnviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMensajeActionPerformed(evt);
            }
        });

        btnEnviarLecturas.setText("Enviar lecturas");
        btnEnviarLecturas.setEnabled(false);
        btnEnviarLecturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarLecturasActionPerformed(evt);
            }
        });

        jLabel16.setText("Inicio");

        jLabel17.setText("Fin");

        cmbDiaInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbMesInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbMesInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesInicioActionPerformed(evt);
            }
        });

        cmbAnyoInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014" }));

        jLabel2.setText("-");

        cmbHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));

        cmbDiaFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbMesFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbAnyoFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014" }));

        jLabel4.setText("-");

        cmbHoraFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));

        javax.swing.GroupLayout jpConfiguracionLayout = new javax.swing.GroupLayout(jpConfiguracion);
        jpConfiguracion.setLayout(jpConfiguracionLayout);
        jpConfiguracionLayout.setHorizontalGroup(
            jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpConfiguracionLayout.createSequentialGroup()
                        .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(txtIp)))
                    .addComponent(jSeparator1)
                    .addGroup(jpConfiguracionLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviarMensaje))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConfiguracionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarLecturas))
                    .addGroup(jpConfiguracionLayout.createSequentialGroup()
                        .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAnyoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAnyoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpConfiguracionLayout.setVerticalGroup(
            jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarMensaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnyoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnyoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviarLecturas)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Configuración", jpConfiguracion);

        lblDatosServidorUDP.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblDatosServidorUDP.setText("<No ha sido posible arrancar>");

        jLabel5.setText("Servidor UDP funcionando en");

        txtServidorUDP.setEditable(false);
        txtServidorUDP.setColumns(20);
        txtServidorUDP.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12)); // NOI18N
        txtServidorUDP.setRows(5);
        jScrollPane1.setViewportView(txtServidorUDP);

        javax.swing.GroupLayout jpServerUDPLayout = new javax.swing.GroupLayout(jpServerUDP);
        jpServerUDP.setLayout(jpServerUDPLayout);
        jpServerUDPLayout.setHorizontalGroup(
            jpServerUDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpServerUDPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpServerUDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpServerUDPLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDatosServidorUDP, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpServerUDPLayout.setVerticalGroup(
            jpServerUDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpServerUDPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpServerUDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDatosServidorUDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Receptor UDP de tests", jpServerUDP);

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 12)); // NOI18N
        txtLog.setRows(5);
        jpLog.setViewportView(txtLog);
        txtLog.getAccessibleContext().setAccessibleParent(jtpPrincipal);

        jtpPrincipal.addTab("Log", jpLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIniciarSimulacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addContainerGap())
            .addComponent(jtpPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIniciarSimulacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpPrincipal))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSimulacionActionPerformed
        // Habilitar/deshabilitar controles
        if (!this.enFuncionamiento) {
            //Iniciar
            if (this.comprobarIp(this.txtIp.getText()) && this.comprobarPuerto(this.txtPuerto.getText())) {
                //Puerto a entero
                int puerto = Integer.parseInt(this.txtPuerto.getText());
                this.socket = new EmisorUDP(txtIp.getText(), puerto, this, gt);
                if (this.socket.isOk()) {
                    //Ip y Puerto correctos
                    this.enFuncionamiento = true;
                    this.btnIniciarSimulacion.setText("Detener");
//                this.jtpPrincipal.setSelectedIndex(1);
                    this.txtIp.setEnabled(false);
                    this.txtPuerto.setEnabled(false);
                    this.txtMensaje.setEnabled(true);
                    this.btnEnviarMensaje.setEnabled(true);
                    this.btnEnviarLecturas.setEnabled(true);
                    
                    this.addLog("[INICIANDO SIM. ]\n");
                } else {
                    //Error al crear el socket
                    showMessageDialog(null, "Ha ocurrido un error al intentar crear el socket", "No se puede iniciar", 2);
                    this.jtpPrincipal.setSelectedIndex(0);
                }
            } else {
                //Error en IP o Puerto
                showMessageDialog(null, "La dirección IP y/o el puerto son incorrectos.", "No se puede iniciar", 2);
                this.jtpPrincipal.setSelectedIndex(0);
            }
        } else {
            //Apagar
            this.enFuncionamiento = false;
            this.btnIniciarSimulacion.setText("Iniciar");
            this.txtIp.setEnabled(true);
            this.txtPuerto.setEnabled(true);
            this.addLog("[DETENIENDO SIM.]\n");
            this.txtMensaje.setEnabled(false);
            this.btnEnviarMensaje.setEnabled(false);
            this.btnEnviarLecturas.setEnabled(false);
            this.socket = null;
        }
    }//GEN-LAST:event_btnIniciarSimulacionActionPerformed

    /**
     * Devuelve la IP local del equipo
     * (http://stackoverflow.com/questions/20714276/how-to-get-only-public-ip-addresses-in-java)
     *
     * @return String con la IP del equipo o null en caso de error
     */
    private String getLocalIp() {
        String res = null;
        try {
            String localhost = InetAddress.getLocalHost().getHostAddress();
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                if (ni.isLoopback()) {
                    continue;
                }
                if (ni.isPointToPoint()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = (InetAddress) addresses.nextElement();
                    if (address instanceof Inet4Address) {
                        String ip = address.getHostAddress();
                        if (!ip.equals(localhost)) {
                            res = ip;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private void btnEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensajeActionPerformed
        if ("".equals(this.txtMensaje.getText())) {
            //No hay nada que enviar
            showMessageDialog(null, "No ha indicado nada para enviar", "No se ejecutó la operación", 2);
        } else {
            if (this.socket.mandarMensajeUDP(this.txtMensaje.getText())) {
                showMessageDialog(null, "¡Mensaje enviado!", "Éxito", 2);
            } else {
                showMessageDialog(null, "Ha ocurrido un error en el envío del mensaje", "Error", 2);
            }
        }
    }//GEN-LAST:event_btnEnviarMensajeActionPerformed

    private void btnEnviarLecturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarLecturasActionPerformed
        // TODO add your handling code here:
        
        //Desactivar botón
        this.btnEnviarLecturas.setEnabled(false);
        
        Long gap = 600000l; //10 minutos en milisegundos

        Timestamp timestamp = Timestamp.valueOf(
                cmbAnyoInicio.getSelectedItem().toString() + "-"
                + cmbMesInicio.getSelectedItem().toString() + "-"
                + cmbDiaInicio.getSelectedItem().toString() + " "
                + cmbHoraInicio.getSelectedItem().toString() + ":00");
        
        Timestamp timestampFin = Timestamp.valueOf(
                cmbAnyoFin.getSelectedItem().toString() + "-"
                + cmbMesFin.getSelectedItem().toString() + "-"
                + cmbDiaFin.getSelectedItem().toString() + " "
                + cmbHoraFin.getSelectedItem().toString() + ":01"); //Tiene 1 ms más para contar también el instante final
        
        socket.setIntervalo(timestamp, timestampFin, gap);
        
        try{
        socket.start();
        }catch(Exception e){
            showMessageDialog(null, "Ha ocurrido un error.\nIntenta detener y volver a iniciar el simulador", "Error", 2);
        }
        
    }//GEN-LAST:event_btnEnviarLecturasActionPerformed
    
    public void setFechaHora(String fechaHora) {
        this.lblFecha.setText(fechaHora);
    }
    
    private void txtPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuertoActionPerformed

    private void cmbMesInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMesInicioActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Interfaz().setVisible(true);
            }
        });
    }

    /**
     * Comprueba si una IP es correcta según una expresión regular
     *
     * @param ip Cadena con la IP
     * @return true si es correcta o false en caso contrario
     */
    private boolean comprobarIp(String ip) {
        String ipPattern
                = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches() || "localhost".equals(ip);
    }

    /**
     * Comprueba si un puerto de red es correcto [1, 65534]
     *
     * @param puerto Cadena con el puerto
     * @return true si es correcto o false en caso contrario
     */
    private boolean comprobarPuerto(String puerto) {
        try {
            Integer p = Integer.parseInt(puerto);
            return (p > 1 && p < 655350);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarLecturas;
    private javax.swing.JButton btnEnviarMensaje;
    private javax.swing.JButton btnIniciarSimulacion;
    private javax.swing.JComboBox cmbAnyoFin;
    private javax.swing.JComboBox cmbAnyoInicio;
    private javax.swing.JComboBox cmbDiaFin;
    private javax.swing.JComboBox cmbDiaInicio;
    private javax.swing.JComboBox cmbHoraFin;
    private javax.swing.JComboBox cmbHoraInicio;
    private javax.swing.JComboBox cmbMesFin;
    private javax.swing.JComboBox cmbMesInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpConfiguracion;
    private javax.swing.JScrollPane jpLog;
    private javax.swing.JPanel jpServerUDP;
    private javax.swing.JTabbedPane jtpPrincipal;
    private javax.swing.JLabel lblDatosServidorUDP;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextArea txtServidorUDP;
    // End of variables declaration//GEN-END:variables
}
