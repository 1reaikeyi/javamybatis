package CRUD.config;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Gender {
    GENTlEMAN(1,"男"),LADY(0,"女");
    @EnumValue
    private int i;
    private String stutus;

    Gender(int i, String stutus) {
        this.i = i;
        this.stutus = stutus;
    }
}
