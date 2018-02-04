package com.boa.spark;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author DuenBoa
 * @date 2018/1/20
 */
public class WorldCount {


    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("TestStorageLevel");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd = sc.textFile("F:\\github\\boa-spark-java\\spark-java\\src\\main\\java\\com\\boa\\spark\\authcenter.log");
        long start = System.nanoTime();
        rdd = rdd.cache();
        JavaRDD<String> exception = rdd.filter(v1 -> v1.contains("FileNotFoundException"));
        exception.foreach(s -> System.out.println(s));
        long count = exception.count();
        System.out.println(count);
        long end = System.nanoTime();
        System.out.println("cost: " + (end - start) / (1000 * 1000));
        sc.close();
    }
}