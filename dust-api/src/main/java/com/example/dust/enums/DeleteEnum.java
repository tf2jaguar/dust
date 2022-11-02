package com.example.dust.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：zhangguoong
 * @since ：Created in 2021/6/25 18:16
 */
public enum DeleteEnum {
    //0  1
    NORMAL(0, "正常"),
    DELETE(1, "删除");

    private static final Map<Integer, DeleteEnum> ALL = new HashMap<Integer, DeleteEnum>();

    static {
        for (DeleteEnum item : DeleteEnum.values()) {
            ALL.put(item.getCode(), item);
        }
    }

    private Integer code;
    private String name;

    DeleteEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static DeleteEnum instanceOf(Integer code) {
        return ALL.get(code);
    }

    /**
     * 判断参数合法性
     */
    public static boolean isValidCode(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        return Objects.nonNull(DeleteEnum.instanceOf(code));
    }

    /**
     * 根据code获取名称
     */
    public static String getNameByCode(Integer code) {
        return Objects.nonNull(instanceOf(code)) ? instanceOf(code).getName() : "";
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public boolean eq(Integer code) {
        if (Objects.isNull(code)) {
            return false;
        }
        return this.code.intValue() == code.intValue();
    }
}
