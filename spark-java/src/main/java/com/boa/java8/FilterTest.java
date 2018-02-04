package com.boa.java8;

import org.apache.avro.ipc.specific.Person;
import org.apache.avro.ipc.specific.PrivacyType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * @author DuenBoa
 * @date 2018/1/27
 */
public class FilterTest {


    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        ArrayList<T> ts = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                ts.add(t);
            }
        }
        return ts;
    }

    public static <T> void foreach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static <T, R> Collection<R> map(List<T> ts, Function<T, R> func) {
        List<R> rs = new ArrayList<>();
        for (T t : ts) {
            rs.add(func.apply(t));
        }
        return rs;
    }


    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>() {{
            add(Person.newBuilder(new Person("22", 2017, "sh", "ok", null, null, PrivacyType.PUBLIC)).build());
            add(Person.newBuilder(new Person("1", 2017, "hb", "ok", null, null, PrivacyType.PUBLIC)).build());
            add(Person.newBuilder(new Person("333", 2017, "wh", "ok", null, null, PrivacyType.PUBLIC)).build());
        }};

        //判断 boolean java.util.function.Predicate.test()
        List<Person> filter = filter(list, p -> !p.getCountry().equals("hb"));

        //消费 java.util.function.Consumer.accept
        foreach(list, p -> System.out.println(p));

        //归类 java.util.function.Function.apply()
        Collection<Integer> l = map(list, (p) -> p.getName().length());
        System.out.println(l); //[1, 2, 3]

        //排序
        list.sort(comparing(Person::getName));

    }

}
