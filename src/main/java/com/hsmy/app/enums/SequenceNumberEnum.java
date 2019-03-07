package com.hsmy.app.enums;

/**
 * @Author: zhaoxm
 * @Date: 2019/3/7 10:41
 * @Version 1.0
 * @Desc:
 */
public enum SequenceNumberEnum  implements  BaseEnum<String> {
    EIGHTSEQUENCE("8","八位长度"),ZEROSEQUENCE("0","空位");

    private String nums;
    private String description;

    SequenceNumberEnum (String nums, String desc){
        this.nums= nums;
        this.description = desc;
    }

    @Override
    public String value() {
        return nums;
    }

    @Override
    public String Description() {
        return description;
    }
}
