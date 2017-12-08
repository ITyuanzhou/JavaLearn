package com.company.singleton;

/** 枚举模式（相当于恶汉模式--通过final+static，多一个自由序列化的问题）
 * Created by ZJZL_HP on 2017/12/6.
 */
public enum ColorEnum {
    INSTANCE(1);

    private int code;
    ColorEnum(int code){
        System.out.println("2344");
        this.code = code;
    }

    public static ColorEnum GetInstance(){
        return ColorEnum.INSTANCE;
    }
}
