package CRUD.resource;

import CRUD.config.Gender;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.DateTypeHandler;

import java.util.Date;
import java.util.Map;

@TableName(value = "shuihu",autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usee {
    /**
     * create table shuihu
     (
     name        varchar(10) null,
     id          int         null comment '工号',
     workplace   varchar(10) null comment '居住地',
     salary      double      null,
     gender      int         null,
     job         varchar(10) null comment '岗位',
     status      int         null comment '状态',
     create_time datetime    null comment '工作时间'
     )
     */
//          自增
//    @TableId(value = "id",type = IdType.AUTO)
//           手动输入
    @TableId(value = "id",type = IdType.NONE)
//            雪花填入
//    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Integer id;
    //    @TableField("name")，如果Class和数据库不一致，使用这个去匹配
    private String name;
//    @TableField(select = false ),如果不希望出现工作地点
//    @TableField(exist = false)，如果job属性在数据库不存在
    private String workplace;
//    @TableField("`salary`"),如果salary是关键字
    private Double salary;
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String,String> job;

    @TableLogic(value = "1",delval = "0")
    private int status;
    @EnumValue
    private Gender gender;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    @Override
    public String toString() {
        return "Usee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workplace='" + workplace + '\'' +
                ", salary=" + salary +
                ", job='" + job.toString() + '\'' +
                '}'+"\n";
    }
}
