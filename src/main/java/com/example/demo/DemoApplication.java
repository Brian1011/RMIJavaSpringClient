package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication
public class DemoApplication {

    @Bean
    RmiProxyFactoryBean rmiProxy(){
        RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
        bean.setServiceInterface(ClientRMI.class);
        bean.setServiceUrl("rmi://localhost:1099/CabBookingService");

        return bean;
    }

    public static void main(String[] args) {
        //Registry registry = LocateRegistry.getRegistry("localhost");
        //Registry registra = LocateRegistry.getRegistry();

        ClientRMI rmiService = SpringApplication.run(DemoApplication.class, args).getBean(ClientRMI.class);
        System.out.println("################## CLIENT ################");
        System.out.println(rmiService.bookCab("Nairobi West"));
    }

}
