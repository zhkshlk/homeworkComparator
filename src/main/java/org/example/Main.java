package org.example;

import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Sasha");
        list.add("Kolya");
        list.add("Yura");
        list.add("Gena");
        list.add("Sergei");
        list.add("Denis");
        System.out.println(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        list.sort((o1, o2) -> o1.compareTo(o2));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        MyFunctionalInterface math = (a1, b1) -> a1 + b1;
        System.out.println("сумма равна: " + math.sum(a, b));

        StringUtil util = new StringUtil();
        util.actions.concate("a", "b");

        int countChars = util.actions.countChars("Hello");
        char findChars = util.actions.findChars("Hello", 3);
        System.out.println(countChars);
        System.out.println(findChars);

        Random rnd = new Random();
        List<Integer> listNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listNumbers.add(rnd.nextInt(50, 500));
        }
        System.out.println(listNumbers);
        listNumbers.sort((a2, b2) -> b2.compareTo(a2));
        System.out.println(listNumbers);

        List<String> list1 = new ArrayList<>();
        list1.add("asdlkjflksadjf");
        list1.add("asd");
        list1.add("lkjflksadjf");
        list1.add("sadjf");
        list1.add("asdlkjflksadjf");
        System.out.println(list1);
        List<String> filteredStrings =  list1.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        }).collect(Collectors.toList());
        System.out.println(filteredStrings);

        List<Double> doubles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            doubles.add(rnd.nextDouble(1, 20));
        }
        System.out.println(doubles);
        double avg = doubles.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println(avg);

        double s = 0;
        for (int i = 0; i < doubles.size(); i++) {
            s += doubles.get(i);
        }
        System.out.println(s / doubles.size());

        List<MyClass> myClasses = new ArrayList<>();
        myClasses.add(new MyClass(10, 20.5));
        myClasses.add(new MyClass(11, 21.5));
        myClasses.add(new MyClass(12, 22.5));
        myClasses.add(new MyClass(13, 23.5));
        myClasses.add(new MyClass(14, 19.5));

        MyClass maxClass = myClasses.stream().max(new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return o1.getDoubleValue() > o2.getDoubleValue() ? 1 : (o1.getDoubleValue() == o2.getDoubleValue() ? 0 : -1);
            }
        }).get();
//        myClasses.sort(new Comparator<MyClass>() {
//            @Override
//            public int compare(MyClass o1, MyClass o2) {
//                if(o1.getDoubleValue() == o2.getDoubleValue()) return 0;
//                else if(o1.getDoubleValue() > o2.getDoubleValue()) return 1;
//                else return -1;
//            }
//        });
//        System.out.println(myClasses.get(myClasses.size()-2));


        List<Integer> listNumbers2 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listNumbers2.add(i);
        }
        System.out.println(listNumbers2);
        List<Integer> mult2 = listNumbers2.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(mult2);
    }
}