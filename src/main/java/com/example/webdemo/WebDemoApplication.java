package com.example.webdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan({"com.example.webdemo.dao", "com.example.webdemo.mapper"})
public class WebDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String cDir = "C:\\Users\\liuyuzhu\\Downloads\\";
        Map<String, String> cMap = getMap(cDir);
        String fDir = "F:\\tools\\";
        Map<String, String> fMap = getMap(fDir);
        printPart(cMap, fMap, 0);
        System.out.println("----------------------- in");
//        printPart(cMap, fMap, 1);
//        System.out.println("----------------------- not in");
//        printPart(cMap, fMap, 2);
//        System.out.println("----------------------- all");
    }

    public Map<String, String> getMap(String dir) {
        Map<String, String> map = new HashMap<>();
        File file = new File(dir);
        if (!file.exists()) {
            return map;
        }
        String[] names = file.list();
        for(String name: names) {
            File subFile = new File(dir + name);
            if (subFile.isFile()) {
                map.put(name, dir);
            }
        }
        return map;
    }

    public void printPart(Map<String, String> cMap, Map<String, String> fMap, int flag) {// flag 0:include, 1:exclude, 2:all
        for(Map.Entry<String, String>entry: cMap.entrySet()) {
            if (0 == flag) {
                if (null != fMap.get(entry.getKey())) {
                    System.out.println(entry.getKey());
                }
            }
            else if (1 == flag) {
                if (null == fMap.get(entry.getKey())) {
                    System.out.println(entry.getKey());
//                    try {
//                        Files.copy(new File(entry.getValue() + entry.getKey()).toPath(), new File("F:\\tools\\" + entry.getKey()).toPath());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }
            else {
                System.out.println(entry.getKey());
            }
        }
    }
}
