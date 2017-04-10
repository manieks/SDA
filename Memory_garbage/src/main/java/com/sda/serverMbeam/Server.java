package com.sda.serverMbeam;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import static java.lang.management.ManagementFactory.*;

/**
 * Created by mariusz.przybysz on 2017-04-08.
 */
public class Server implements ServerMBean {
    private List<Customer> customersList;


    public Server() {

        Customer cust1 = new Customer("Adam", 1);
        Customer cust2 = new Customer("benek", 21);
        Customer cust3 = new Customer("ceee", 32);

        customersList = new ArrayList<Customer>();
        customersList.add(cust1);
        customersList.add(cust2);
        customersList.add(cust3);

    }


    @Override
    public int countRegisteredCustomers() {
        return customersList.size();
    }

    @Override
    public void addCustomer(String name, int age) {
        Customer cust4 = new Customer(name, age);
        customersList.add(cust4);
    }





}


