package com.boa.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

/**
 * @author DuenBoa
 * @date 2018/2/4
 */
public class TradeTransPractise {
    public static void main(String[] args) {
        List<Transaction> transactions = init();
//        allTransAndOrderByValue(transactions);
//        distinctCitys(transactions);
//        findCambridgeTradersName(transactions);
        //findAllTradersName(transactions);
        //hasTraderWorkInMilan(transactions);
        //printSumValueOfCambridge(transactions);
        //maxValue(transactions);
        transOfMinValue(transactions);

    }

    private static List<Transaction> init() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    /**
     * 找出2011年发生的交易, 并按交易额排序从低到高.
     * Transaction{trader=Trader{name='Brian', city='Cambridge'}, year=2011, value=300}
     * Transaction{trader=Trader{name='Raoul', city='Cambridge'}, year=2011, value=400}
     *
     * @param transactions
     */
    public static void allTransAndOrderByValue(List<Transaction> transactions) {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(t -> System.out.println(t));
    }

    /**
     * 交易员都来自哪些不同的城市
     * Cambridge
     * Milan
     *
     * @param transactions
     */
    public static void distinctCitys(List<Transaction> transactions) {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(t -> System.out.println(t));
    }

    /**
     * 查找所有来自剑桥的交易员,姓名排序
     * Alan
     * Brian
     * Raoul
     *
     * @param transactions
     */
    public static void findCambridgeTradersName(List<Transaction> transactions) {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(t -> System.out.println(t));
    }


    /**
     * 查找所有交易员的姓名字符串,并按照字母顺序排序
     * Alan
     * Brian
     * Mario
     * Raoul
     *
     * @param transactions
     */
    public static void findAllTradersName(List<Transaction> transactions) {
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(t -> System.out.println(t));
    }


    /**
     * 有没有交易员在米兰工作的? true
     *
     * @param transactions
     */
    public static void hasTraderWorkInMilan(List<Transaction> transactions) {
        boolean milan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }


    /**
     * 打印在剑桥的交易员的所有交易额
     * 2650
     *
     * @param transactions
     */
    public static void printSumValueOfCambridge(List<Transaction> transactions) {
        Integer camSumValue = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .reduce((i, j) -> i + j)
                .get();
        System.out.println(camSumValue);
    }

    /**
     * 所有交易中,最高的交易额是多少
     * 1000
     *
     * @param transactions
     */
    public static void maxValue(List<Transaction> transactions) {
        Integer maxValue = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max)
                .get();
        System.out.println(maxValue);
    }

    /**
     * 所有交易中,交易额最小的那笔交易
     * Optional[Transaction{trader=Trader{name='Brian', city='Cambridge'}, year=2011, value=300}]
     *
     * @param transactions
     */
    public static void transOfMinValue(List<Transaction> transactions) {
        //1
        Optional<Transaction> min1 = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        //2
        Optional<Transaction> min2 = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println(min1.get());
        System.out.println(min2.get());
    }

}
