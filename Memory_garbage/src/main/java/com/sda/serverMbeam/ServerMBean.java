package com.sda.serverMbeam;

/**
 * Created by mariusz.przybysz on 2017-04-08.
 */
public interface ServerMBean {
    int countRegisteredCustomers();
    void addCustomer(String name, int age);
}
