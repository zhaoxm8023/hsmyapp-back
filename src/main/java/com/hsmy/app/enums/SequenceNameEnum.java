package com.hsmy.app.enums;

/**
 * @Author: zhaoxm
 * @Date: 2019/3/7 10:22
 * @Version 1.0
 * @Desc:
 */
public enum SequenceNameEnum implements  BaseEnum<String> {
    //枚举类的实例对象必须在最前面先定义，而且必须每个实例对象都必须维护上chinese成员变量
    INFOPUBSEQUENCE("infopub","信息发布sequence"),DEMOSEQUENCE("demose","demo sequence");

    private String info;
    private String description;

    //枚举类型的构造函数默认为private，因为枚举类型的初始化要在当前枚举类中完成。
    SequenceNameEnum (String chinese, String desc){
        this.info= chinese;
        this.description = desc;
    }

    public String value(){
        return info;
    }

    public String Description(){
        return description;
    }
}
//public enum SequenceNameEnum implements BaseEnum<String> {;

//    public static   SequenceNameEnum transNameOf(String value){
//        SequenceNameEnum[] values = SequenceNameEnum.values();
//        for(SequenceNameEnum trans:values){
//            if(trans.value().equals(value)){
//                return trans;
//            }
//        }
//    }
//}
