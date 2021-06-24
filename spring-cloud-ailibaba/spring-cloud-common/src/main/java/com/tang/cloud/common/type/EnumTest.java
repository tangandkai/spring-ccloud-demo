package com.tang.cloud.common.type;

public class EnumTest {

    public static void main(String[] args) {
        WeekDay monday = WeekDay.Saturday;
        switch (monday){
            case Friday:
                System.out.println(monday.getInfo());
                break;
            case Tuesday:
                System.out.println(monday.getInfo());
                break;
            case Thursday:
                System.out.println(monday.getInfo());
                break;
            case Wednesday:
                System.out.println(monday.getInfo());
                break;
            case Saturday:
                System.out.println(monday.getInfo());
                break;
            case Sunday:
                System.out.println(monday.getInfo());
                break;
            case Monday:
                System.out.println(monday.getInfo());
                break;
            default:
                break;
        }
        System.out.println(monday.name());
        System.out.println(monday.getInfo());
        System.out.println(monday.getNum());
    }
}
