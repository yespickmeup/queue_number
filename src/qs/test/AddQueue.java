/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import java.util.Date;
import java.util.List;
import qs.departments.Departments;
import qs.queues.Queues;
import qs.util.DateType;

/**
 *
 * @author Ronescape
 */
public class AddQueue {

    public static void main(String[] args) {
        System.setProperty("pool_db", "db_queue");
        System.setProperty("pool_password", "password");
        for (int i = 0; i < 20; i++) {
            String date = DateType.sf.format(new Date());
            List<Departments.to_departments> deps = Departments.ret_data(" where id='" + "2" + "' ");
            Departments.to_departments dep1 = (Departments.to_departments) deps.get(0);
            String queue_no = Queues.increment_id("Payment", "2", dep1.shortcut);
//                System.out.println("queue_no: "+queue_no);
//                List<Queues.to_queues> exist = Queues.ret_data(" where queue_no='" + queue_no + "' and department_id='" + dep.id + "' and Date(created_at)='" + date + "' ");

            String department = "Payment";
            String department_id = "" + "2";
            String customer = "";
            String customer_id = "";
            String counter_no = null;
            String teller = null;
            String teller_id = null;
            String remarks = "";
            int status = 0;
            String created_at = DateType.now();
            String updated_at = DateType.now();
            String created_by = "";
            String updated_by = "";
            Queues.to_queues q = new Queues.to_queues(0, queue_no, department, department_id, customer, customer_id, counter_no, teller, teller_id, remarks, status, created_at, updated_at, created_by, updated_by);
            Queues.add_data(q);
        }

    }
}
