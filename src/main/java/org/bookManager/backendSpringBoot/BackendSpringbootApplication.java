package org.bookManager.backendSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@SpringBootApplication
public class BackendSpringbootApplication {

    public static HashMap<String, Queue> listOfQueue;

    public static void main(String[] args) {
        System.out.println("Start application...");

        for (int i = 0; i < args.length; i++) {
            //Создаем столько очередей сколько типов нам передали
            //Так же еще надо где то указывать сколько потоков будет обрабатывать их По 5 на каждую очередь или
            listOfQueue.put(args[i],new PriorityQueue());
        }

        SpringApplication.run(BackendSpringbootApplication.class, args);
        System.out.println("Application is running!");
    }

}

