/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import qs.customers.Customers;
import qs.departments.Departments;
import qs.queues.Queues;
import qs.reports.Srpt_print_queue_no;
import qs.util.Alert;
import qs.util.DateType;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_generate_number extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_call_customer
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_generate_number(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_generate_number(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_generate_number() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_generate_number myRef;

    private void setThisRef(Dlg_generate_number myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_generate_number> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_generate_number create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_generate_number create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_generate_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_generate_number((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_generate_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_generate_number((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_generate_number dialog = Dlg_generate_number.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);

        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_degrees = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jButton1 = new Button.Success();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new Button.Default();
        jButton3 = new Button.Default();
        jButton4 = new Button.Default();
        jButton5 = new Button.Default();
        jButton6 = new Button.Default();
        jButton7 = new Button.Default();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_degrees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_degrees.setFocusable(false);
        tbl_degrees.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_degrees.setSelectionBackground(new java.awt.Color(25, 130, 191));
        jScrollPane1.setViewportView(tbl_degrees);

        jLabel1.setBackground(new java.awt.Color(25, 130, 191));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Department");
        jLabel1.setOpaque(true);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Proceed");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Customer Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setText("1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("4");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("5");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("6");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Test");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(18, 115, 172));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/link_logo (Custom) (2).png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Queing System");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sibulan Water District");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        proceed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        connect_to_teller1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        connect_to_teller_2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        connect_to_teller_3();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        connect_to_teller_4();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        connect_to_teller_5();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        connect_to_teller_6();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (out2 != null) {
            System.out.println("Test: ");
            out2.println("Hi teller 2");
        } else {
            connect_to_teller1();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        ret_customer();
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_degrees;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        String environment = System.getProperty("environment", "production");
        if (environment.equalsIgnoreCase("production")) {
            jPanel2.setVisible(false);

        }
        jLabel4.setText(System.getProperty("business_name", ""));
        init_key();
        set_font();
        init_tbl_degrees(tbl_degrees);
        ret_degrees();

//        connect_to_teller_server();
        connect_to_teller1();
        connect_to_teller_2();
        connect_to_teller_3();
        connect_to_teller_4();
        connect_to_teller_5();
        connect_to_teller_6();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTextField1.grabFocus();
            }
        });
    }

    private void set_font() {
        String font = System.getProperty("font_size", "large");
        if (font.equalsIgnoreCase("small")) {
            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        }
        if (font.equalsIgnoreCase("medium")) {
            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 26));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20));
        }
        if (font.equalsIgnoreCase("large")) {
            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30));
        }
        if (font.equalsIgnoreCase("xl")) {
            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 46));
            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 40));
        }
    }

    private void ret_customer() {
        String number = jTextField1.getText();
        if (!number.isEmpty()) {
            List<Customers.to_customers> list = Customers.ret_data(" where customer_no='" + number + "'");
            if (!list.isEmpty()) {
                Customers.to_customers to = (Customers.to_customers) list.get(0);
                jLabel3.setText(to.lname + ", " + to.fname + " " + to.mi);
            } else {
                Alert.set(0, "Consumer not found!");
                jTextField1.setText("");
                return;
            }
        }
    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    //                btn_0.doClick();
////                    in1.close();
////                    in2.close();
////                    in3.close();
////                    in4.close();
////                    in5.close();
////                    in6.close();
////
////                    out1.close();
////                    out2.close();
////                    out3.close();
////                    out4.close();
////                    out5.close();
////                    out6.close();
////                    socket1.close();
////                    socket2.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(Dlg_generate_number.class.getName()).log(Level.SEVERE, null, ex);
//                }
                disposed();
            }
        });

    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" degrees "> 
    public static ArrayListModel tbl_degrees_ALM;
    public static TbldegreesModel tbl_degrees_M;

    public static void init_tbl_degrees(JTable tbl_degrees) {
        tbl_degrees_ALM = new ArrayListModel();
        tbl_degrees_M = new TbldegreesModel(tbl_degrees_ALM);
        tbl_degrees.setModel(tbl_degrees_M);
        tbl_degrees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_degrees.setRowHeight(25);
        int[] tbl_widths_degrees = {100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_degrees.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_degrees, i, tbl_widths_degrees[i]);
        }
        Dimension d = tbl_degrees.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_degrees.getTableHeader().setPreferredSize(d);
        tbl_degrees.getTableHeader().setFont(new java.awt.Font("Arial", 0, 24));
        tbl_degrees.setRowHeight(70);
        tbl_degrees.setFont(new java.awt.Font("Arial", 0, 50));
        tbl_degrees.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        tbl_degrees.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_degrees.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

    }

    public static void loadData_degrees(List<Departments.to_departments> acc) {
        tbl_degrees_ALM.clear();
        tbl_degrees_ALM.addAll(acc);
    }

    public static class TbldegreesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Degree", "Status", "", "", "created_at", "updated_at", "status", "is_uploaded"
        };

        public TbldegreesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Departments.to_departments tt = (Departments.to_departments) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.department;
                case 1:
                    if (tt.status == 0) {
                        return " Active";
                    } else {
                        return " Inactive";
                    }
                case 2:
                    return "/qs/icons/new-file.png";
                case 3:
                    return "/qs/icons/remove11.png";
                case 4:
                    return tt.created_at;
                case 5:
                    return tt.updated_at;
                case 6:
                    return tt.status;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_degrees() {
        String where = " order by department asc ";
        List<Departments.to_departments> datas = Departments.ret_data(where);
        loadData_degrees(datas);

    }

    private void proceed() {

        int row = tbl_degrees.getSelectedRow();
        if (row < 0) {
            Alert.set(0, "Select Department!");
            return;
        }

        Departments.to_departments dep = (Departments.to_departments) tbl_degrees_ALM.get(row);
        Window p = (Window) this;
        Dlg_generate_number_prompt nd = Dlg_generate_number_prompt.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_generate_number_prompt.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_generate_number_prompt.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String date = DateType.sf.format(new Date());
                String queue_no = Queues.increment_id(dep.department, "" + dep.id);
                List<Queues.to_queues> exist = Queues.ret_data(" where queue_no='" + queue_no + "' and department_id='" + dep.id + "' and Date(created_at)='" + date + "' ");
                do {
                    queue_no = Queues.increment_id(dep.department, "" + dep.id);
                } while (!exist.isEmpty());

                String department = dep.department;
                String department_id = "" + dep.id;
                String customer = jLabel3.getText();
                String customer_id = jTextField1.getText();
                String counter_no = null;
                String teller = null;
                String teller_id = null;
                String remarks = "";
                int status = 0;
                String created_at = DateType.now();
                String updated_at = DateType.now();
                String created_by = "";
                String updated_by = "";

                Queues.to_queues q = new Queues.to_queues(id, queue_no, department, department_id, customer, customer_id, counter_no, teller, teller_id, remarks, status, created_at, updated_at, created_by, updated_by);
                Queues.add_data(q);

                send_message("hi teller");

                //<editor-fold defaultstate="collapsed" desc=" Print Queue No ">
                String business_name = System.getProperty("business_name", "");
                String address = System.getProperty("address", "");
                String contact_no = System.getProperty("contact_no", "");

                String date2 = DateType.day_and_time.format(new Date());
                Srpt_print_queue_no rpt = new Srpt_print_queue_no(business_name, address, contact_no, counter_no, department, queue_no, date2);
                String jrxml = "rpt_print_queue_no.jrxml";
                String print_queue_no = System.getProperty("print_queue_no", "true");
                if (print_queue_no.equalsIgnoreCase("true")) {
                    InputStream is = Srpt_print_queue_no.class.getResourceAsStream(jrxml);
                    try {
                        JasperReport jasperReport = JasperCompileManager.compileReport(is);
                        jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                setParameter(rpt), JasperUtil.emptyDatasource());

                        try {
                            if (jasperPrint != null) {
                                JasperPrintManager.printReport(jasperPrint, false);
                            }
                        } catch (JRException e) {
                            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
                            throw new RuntimeException(e);
                        }

                    } catch (JRException ex) {
                        Logger.getLogger(Srpt_print_queue_no.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                }
                //</editor-fold>

                Alert.set(1, "");
                tbl_degrees.clearSelection();
                jTextField1.setText("");
                jLabel3.setText("");
                jTextField1.grabFocus();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }
    PrintWriter sout1 = null;
    PrintWriter sout2 = null;
    PrintWriter sout3 = null;
    PrintWriter sout4 = null;
    PrintWriter sout5 = null;
    PrintWriter sout6 = null;

    private void send_message(String message) {
        try {
            System.out.println("Sending Message to Server...");

            String counter_no_1_ip = System.getProperty("counter_no_1_ip", "");
            if (!counter_no_1_ip.isEmpty()) {
                int counter_no_1_port = FitIn.toInt(System.getProperty("counter_no_1_port", ""));
                Socket s = new Socket(counter_no_1_ip, counter_no_1_port);
                sout1 = new PrintWriter(s.getOutputStream(), true);
                sout1.println(message);
                System.out.println("Message: " + message);
            }
            String counter_no_2_ip = System.getProperty("counter_no_2_ip", "");
            if (!counter_no_2_ip.isEmpty()) {
                int counter_no_2_port = FitIn.toInt(System.getProperty("counter_no_2_port", ""));
                Socket s = new Socket(counter_no_2_ip, counter_no_2_port);
                sout2 = new PrintWriter(s.getOutputStream(), true);
                sout2.println(message);
                System.out.println("Message: " + message);
            }
            String counter_no_3_ip = System.getProperty("counter_no_3_ip", "");
            if (!counter_no_3_ip.isEmpty()) {
                int counter_no_3_port = FitIn.toInt(System.getProperty("counter_no_3_port", ""));
                Socket s = new Socket(counter_no_3_ip, counter_no_3_port);
                sout3 = new PrintWriter(s.getOutputStream(), true);
                sout3.println(message);
                System.out.println("Message: " + message);
            }
            String counter_no_4_ip = System.getProperty("counter_no_4_ip", "");
            if (!counter_no_4_ip.isEmpty()) {
                int counter_no_4_port = FitIn.toInt(System.getProperty("counter_no_4_port", ""));
                Socket s = new Socket(counter_no_4_ip, counter_no_4_port);
                sout4 = new PrintWriter(s.getOutputStream(), true);
                sout4.println(message);
                System.out.println("Message: " + message);
            }
            String counter_no_5_ip = System.getProperty("counter_no_5_ip", "");
            if (!counter_no_5_ip.isEmpty()) {
                int counter_no_5_port = FitIn.toInt(System.getProperty("counter_no_5_port", ""));
                Socket s = new Socket(counter_no_5_ip, counter_no_5_port);
                sout5 = new PrintWriter(s.getOutputStream(), true);
                sout5.println(message);
                System.out.println("Message: " + message);
            }
            String counter_no_6_ip = System.getProperty("counter_no_6_ip", "");
            if (!counter_no_6_ip.isEmpty()) {
                int counter_no_6_port = FitIn.toInt(System.getProperty("counter_no_6_port", ""));
                Socket s = new Socket(counter_no_6_ip, counter_no_6_port);
                sout6 = new PrintWriter(s.getOutputStream(), true);
                sout6.println(message);
                System.out.println("Message: " + message);
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }

    JasperPrint jasperPrint = null;

    private void generate() {

    }

    //<editor-fold defaultstate="collapsed" desc=" Chat Server ">
    BufferedReader in1;
    PrintWriter out1;

    BufferedReader in2;
    PrintWriter out2;

    BufferedReader in3;
    PrintWriter out3;

    BufferedReader in4;
    PrintWriter out4;

    BufferedReader in5;
    PrintWriter out5;

    BufferedReader in6;
    PrintWriter out6;

    public void connect_to_teller_server() {

    }
    Socket socket1 = null;
    Socket socket2 = null;

    private void connect_to_teller1() {
        String counter_no_1_ip = System.getProperty("counter_no_1_ip", "192.168.1.152");
        System.out.println("counter_no_1_ip: " + counter_no_1_ip);

        if (!counter_no_1_ip.isEmpty()) {
            int counter_no_1_port = FitIn.toInt(System.getProperty("counter_no_1_port", "2001"));
            String screen_name = System.getProperty("teller", "Ronald Pascua1");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        if (socket1 == null) {
                            socket1 = new Socket(counter_no_1_ip, counter_no_1_port);
                            in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                            out1 = new PrintWriter(socket1.getOutputStream(), true);
                            out1.println("Initializing teller no 1");
                        } else {
                            System.out.println("Connected: " + socket1.isConnected());
                            if (socket1.isConnected()) {
                                socket1.close();
                                in1.close();
                                out1.close();
                                socket1 = new Socket(counter_no_1_ip, counter_no_1_port);
                                in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                                out1 = new PrintWriter(socket1.getOutputStream(), true);
                            } else {

                            }

                        }

//                        while (true) {
//                            String line = in1.readLine();
//                            if (line.startsWith("SUBMITNAME")) {
//                                out1.println(screen_name);
//                            } else if (line.startsWith("NAMEACCEPTED")) {
//                            } else if (line.startsWith("MESSAGE")) {
//                                String message = line.substring(8);
//                            }
//                        }
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 1 server!");
                        System.out.println("Teller Logs: " + ex);

                    }
                }
            });
            t.start();
        }
    }

    private void connect_to_teller_2() {
        String counter_no_2_ip = System.getProperty("counter_no_2_ip", "192.168.1.153");

        if (!counter_no_2_ip.isEmpty()) {
            int counter_no_2_port = FitIn.toInt(System.getProperty("counter_no_2_port", "2002"));
            System.out.println("counter_no_2_ip: " + counter_no_2_ip);
            System.out.println("counter_no_2_port: " + counter_no_2_port);
            try {
                if (in2 != null) {
                    System.out.println("Ready: in2: " + in2.ready());
                }
            } catch (IOException ex) {
                Logger.getLogger(Dlg_generate_number.class.getName()).log(Level.SEVERE, null, ex);
            }
            String screen_name = System.getProperty("teller", "Ronald Pascua2");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        if (socket2 == null) {
                            socket2 = new Socket(counter_no_2_ip, counter_no_2_port);
                            in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                            out2 = new PrintWriter(socket2.getOutputStream(), true);
                            out2.println("Initializing teller no 1");
                        } else {
                            System.out.println("Connected: " + socket2.isConnected());
                            if (socket2.isConnected()) {
                                socket2.close();
                                in2.close();
                                out2.close();
                                socket2 = new Socket(counter_no_2_ip, counter_no_2_port);
                                in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                                out2 = new PrintWriter(socket2.getOutputStream(), true);
                            } else {

                            }

                        }
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 2 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }

    private void connect_to_teller_3() {
        String counter_no_3_ip = System.getProperty("counter_no_3_ip", "192.168.1.154");
        System.out.println("counter_no_3_ip: " + counter_no_3_ip);
        if (!counter_no_3_ip.isEmpty()) {
            int counter_no_3_port = FitIn.toInt(System.getProperty("counter_no_3_port", "2003"));
            String screen_name = System.getProperty("teller", "Ronald Pascua3");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_3_ip, counter_no_3_port);
                        in3 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out3 = new PrintWriter(socket.getOutputStream(), true);
                        out3.println("Initializing teller no 1");
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 3 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }

    private void connect_to_teller_4() {
        String counter_no_4_ip = System.getProperty("counter_no_4_ip", "192.168.1.155");
        System.out.println("counter_no_4_ip: " + counter_no_4_ip);
        if (!counter_no_4_ip.isEmpty()) {
            int counter_no_4_port = FitIn.toInt(System.getProperty("counter_no_4_port", "2004"));
            String screen_name = System.getProperty("teller", "Ronald Pascua4");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_4_ip, counter_no_4_port);
                        in4 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out4 = new PrintWriter(socket.getOutputStream(), true);
                        out3.println("Initializing teller no 1");
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 4 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }

    private void connect_to_teller_5() {
        String counter_no_5_ip = System.getProperty("counter_no_5_ip", "192.168.1.156");
        System.out.println("counter_no_5_ip: " + counter_no_5_ip);
        if (!counter_no_5_ip.isEmpty()) {
            int counter_no_5_port = FitIn.toInt(System.getProperty("counter_no_5_port", "2005"));
            String screen_name = System.getProperty("teller", "Ronald Pascua5");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_5_ip, counter_no_5_port);
                        in5 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out5 = new PrintWriter(socket.getOutputStream(), true);
                        out5.println("Initializing teller no 1");
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 5 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }

    private void connect_to_teller_6() {
        String counter_no_6_ip = System.getProperty("counter_no_6_ip", "192.168.1.157");
        System.out.println("counter_no_6_ip: " + counter_no_6_ip);
        if (!counter_no_6_ip.isEmpty()) {
            int counter_no_6_port = FitIn.toInt(System.getProperty("counter_no_6_port", "2006"));
            String screen_name = System.getProperty("teller", "Ronald Pascua6");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_6_ip, counter_no_6_port);
                        in6 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out6 = new PrintWriter(socket.getOutputStream(), true);
                        out6.println("Initializing teller no 1");
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 6 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }
    //</editor-fold>
}
