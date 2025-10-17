package com.example.SPGeorge;

import com.example.SPGeorge.components.ClientComponent;
import com.example.SPGeorge.components.SingletonComponent;
import com.example.SPGeorge.components.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        TransientComponent transientBean1 = context.getBean(TransientComponent.class);
        transientBean1.operation();
        TransientComponent transientBean2 = context.getBean(TransientComponent.class);
        transientBean2.operation();

        SingletonComponent singletonBean1 = context.getBean(SingletonComponent.class);
        singletonBean1.operation();
        SingletonComponent singletonBean2 = context.getBean(SingletonComponent.class);
        singletonBean2.operation();

        ClientComponent client1 = context.getBean(ClientComponent.class);
        client1.operation();
        ClientComponent client2 = (ClientComponent) context.getBean("clientComponent");
        client2.operation();
    }
}