package com.tang.cloud.common.type;

public enum WeekDay {

    Monday(1,"星期一，开始上班"),
    Tuesday(2,"星期二，一般般"),
    Wednesday(3,"星期三，周报"),
    Thursday(4,"星期四，有感觉了"),
    Friday(5,"星期五,pmp"),
    Saturday(6,"星期六,休息的第一天"),
    Sunday(7,"星期日,感觉有点不对");

    private Integer num;
    private String info;

    private WeekDay(Integer num,String info){
        this.num = num;
        this.info = info;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
