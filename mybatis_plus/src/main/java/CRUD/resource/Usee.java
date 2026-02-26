package CRUD.resource;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("shuihu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usee {
    /**
     * create table shuihu
     * (
     *     name      varchar(10) null,
     *     id        int         null comment '工号',
     *     workplace varchar(10) null comment '居住地',
     *     salary    double      null,
     *     job       varchar(10) null comment '岗位',
     *     gender    varchar(10) null
     * )
     *     comment '水浒传';
     */

    @TableId("id")
    private Integer id;
    //    @TableField("name")，如果Class和数据库不一致，使用这个去匹配
    private String name;

    private String workplace;
//    @TableField("`salary`"),如果salary是关键字
    private Double salary;
//    @TableField(exist = false)，如果job属性在数据库不存在
    private String job;

    private String gender;

    @Override
    public String toString() {
        return "Usee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workplace='" + workplace + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
