package dynamic;

import org.apache.ibatis.annotations.Param;
import resource.Usee;

import java.util.List;

public interface Dao {
    List<Usee> selectIf(@Param("name") String name, @Param("salary") Double salary,@Param("workplace") String workplace);
    List<Usee> selectTrim(@Param("name") String name, @Param("salary") Double salary,@Param("workplace") String workplace);
    int updateSet(@Param("name") String name, @Param("salary") Double salary,@Param("workplace") String workplace);
}
