package com.boa.java8;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author DuenBoa
 * @date 2018/2/4
 */
public class Trader {

    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trader{");
        sb.append("name='").append(name).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
