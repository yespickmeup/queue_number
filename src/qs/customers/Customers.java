/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Customers {

    public static class to_customers {

        public final int id;
        public final String customer_no;
        public final String fname;
        public final String mi;
        public final String lname;
        public final String sname;
        public final String bday;
        public final int gender;
        public final String occupation;
        public final String address;
        public final String barangay;
        public final String city;
        public final String province;
        public final String contact_no;
        public final String email_address;
        public final int status;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;

        public to_customers(int id, String customer_no, String fname, String mi, String lname, String sname, String bday, int gender, String occupation, String address, String barangay, String city, String province, String contact_no, String email_address, int status, String created_at, String updated_at, String created_by, String updated_by) {
            this.id = id;
            this.customer_no = customer_no;
            this.fname = fname;
            this.mi = mi;
            this.lname = lname;
            this.sname = sname;
            this.bday = bday;
            this.gender = gender;
            this.occupation = occupation;
            this.address = address;
            this.barangay = barangay;
            this.city = city;
            this.province = province;
            this.contact_no = contact_no;
            this.email_address = email_address;
            this.status = status;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
        }
    }

    public static void add_data(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into customers("
                    + "customer_no"
                    + ",fname"
                    + ",mi"
                    + ",lname"
                    + ",sname"
                    + ",bday"
                    + ",gender"
                    + ",occupation"
                    + ",address"
                    + ",barangay"
                    + ",city"
                    + ",province"
                    + ",contact_no"
                    + ",email_address"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ")values("
                    + ":customer_no"
                    + ",:fname"
                    + ",:mi"
                    + ",:lname"
                    + ",:sname"
                    + ",:bday"
                    + ",:gender"
                    + ",:occupation"
                    + ",:address"
                    + ",:barangay"
                    + ",:city"
                    + ",:province"
                    + ",:contact_no"
                    + ",:email_address"
                    + ",:status"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_no", to_customers.customer_no)
                    .setString("fname", to_customers.fname)
                    .setString("mi", to_customers.mi)
                    .setString("lname", to_customers.lname)
                    .setString("sname", to_customers.sname)
                    .setString("bday", to_customers.bday)
                    .setNumber("gender", to_customers.gender)
                    .setString("occupation", to_customers.occupation)
                    .setString("address", to_customers.address)
                    .setString("barangay", to_customers.barangay)
                    .setString("city", to_customers.city)
                    .setString("province", to_customers.province)
                    .setString("contact_no", to_customers.contact_no)
                    .setString("email_address", to_customers.email_address)
                    .setNumber("status", to_customers.status)
                    .setString("created_at", to_customers.created_at)
                    .setString("updated_at", to_customers.updated_at)
                    .setString("created_by", to_customers.created_by)
                    .setString("updated_by", to_customers.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update customers set "
                    + "customer_no= :customer_no "
                    + ",fname= :fname "
                    + ",mi= :mi "
                    + ",lname= :lname "
                    + ",sname= :sname "
                    + ",bday= :bday "
                    + ",gender= :gender "
                    + ",occupation= :occupation "
                    + ",address= :address "
                    + ",barangay= :barangay "
                    + ",city= :city "
                    + ",province= :province "
                    + ",contact_no= :contact_no "
                    + ",email_address= :email_address "
                    + ",status= :status "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + " where id='" + to_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_no", to_customers.customer_no)
                    .setString("fname", to_customers.fname)
                    .setString("mi", to_customers.mi)
                    .setString("lname", to_customers.lname)
                    .setString("sname", to_customers.sname)
                    .setString("bday", to_customers.bday)
                    .setNumber("gender", to_customers.gender)
                    .setString("occupation", to_customers.occupation)
                    .setString("address", to_customers.address)
                    .setString("barangay", to_customers.barangay)
                    .setString("city", to_customers.city)
                    .setString("province", to_customers.province)
                    .setString("contact_no", to_customers.contact_no)
                    .setString("email_address", to_customers.email_address)
                    .setNumber("status", to_customers.status)
                    .setString("created_at", to_customers.created_at)
                    .setString("updated_at", to_customers.updated_at)
                    .setString("created_by", to_customers.created_by)
                    .setString("updated_by", to_customers.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from customers  "
                    + " where id='" + to_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_customers> ret_data(String where) {
        List<to_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_no"
                    + ",fname"
                    + ",mi"
                    + ",lname"
                    + ",sname"
                    + ",bday"
                    + ",gender"
                    + ",occupation"
                    + ",address"
                    + ",barangay"
                    + ",city"
                    + ",province"
                    + ",contact_no"
                    + ",email_address"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_no = rs.getString(2);
                String fname = rs.getString(3);
                String mi = rs.getString(4);
                String lname = rs.getString(5);
                String sname = rs.getString(6);
                String bday = rs.getString(7);
                int gender = rs.getInt(8);
                String occupation = rs.getString(9);
                String address = rs.getString(10);
                String barangay = rs.getString(11);
                String city = rs.getString(12);
                String province = rs.getString(13);
                String contact_no = rs.getString(14);
                String email_address = rs.getString(15);
                int status = rs.getInt(16);
                String created_at = rs.getString(17);
                String updated_at = rs.getString(18);
                String created_by = rs.getString(19);
                String updated_by = rs.getString(20);

                to_customers to = new to_customers(id, customer_no, fname, mi, lname, sname, bday, gender, occupation, address, barangay, city, province, contact_no, email_address, status, created_at, updated_at, created_by, updated_by);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "00000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select customer_no from customers where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "00000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
        
  
}
