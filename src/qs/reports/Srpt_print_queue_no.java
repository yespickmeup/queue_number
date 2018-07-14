/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.reports;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_print_queue_no {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String counter_no;
    public final String department;
    public final String queue_no;
    public final String date;

    public Srpt_print_queue_no(String business_name, String address, String contact_no, String counter_no, String department, String queue_no, String date) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.counter_no = counter_no;
        this.department = department;
        this.queue_no = queue_no;
        this.date = date;
    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "XYZ Marketing");
        String address = System.getProperty("address", "Daro, Dumaguete City");
        String contact_no = System.getProperty("contact_no", "");
        String counter_no = "01";
        String department = "Evaluation";
        String queue_no = "00001";
        String date = "30-JAN-2018 10:51 AM";
        Srpt_print_queue_no rpt = new Srpt_print_queue_no(business_name, address, contact_no, counter_no, department, queue_no, date);
        String jrxml = "rpt_print_queue_no.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String print_queue_no = System.getProperty("print_queue_no", "false");
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

    }
    static JasperPrint jasperPrint = null;

    private void print_or() {

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_print_queue_no.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_print_queue_no to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }
}
