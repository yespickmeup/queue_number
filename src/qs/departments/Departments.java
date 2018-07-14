/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Departments {

    public static class to_departments {

        public final int id;
        public final String department;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;

        public to_departments(int id, String department, String created_at, String updated_at, String created_by, String updated_by, int status) {
            this.id = id;
            this.department = department;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
        }
    }

    public static void add_data(to_departments to_departments) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into departments("
                    + "department"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ")values("
                    + ":department"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_departments.department)
                    .setString("created_at", to_departments.created_at)
                    .setString("updated_at", to_departments.updated_at)
                    .setString("created_by", to_departments.created_by)
                    .setString("updated_by", to_departments.updated_by)
                    .setNumber("status", to_departments.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Departments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_departments to_departments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "update departments set "
                    + "department= :department "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + " where id='" + to_departments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("department", to_departments.department)
                    .setString("created_at", to_departments.created_at)
                    .setString("updated_at", to_departments.updated_at)
                    .setString("created_by", to_departments.created_by)
                    .setString("updated_by", to_departments.updated_by)
                    .setNumber("status", to_departments.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = "update counters set "
                    + "department= :department "
                    + " where department_id='" + to_departments.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("department", to_departments.department)
                    .ok();
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Departments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_departments to_departments) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);

            String s0 = "delete from departments  "
                    + " where id='" + to_departments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement("");
            stmt.addBatch(s0);

            String s2 = "delete from counters  "
                    + " where department_id='" + to_departments.id + "' "
                    + " ";
            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Departments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_departments> ret_data(String where) {
        List<to_departments> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",department"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + " from departments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String department = rs.getString(2);
                String created_at = rs.getString(3);
                String updated_at = rs.getString(4);
                String created_by = rs.getString(5);
                String updated_by = rs.getString(6);
                int status = rs.getInt(7);

                to_departments to = new to_departments(id, department, created_at, updated_at, created_by, updated_by, status);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
