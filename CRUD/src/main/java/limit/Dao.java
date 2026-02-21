package limit;

import org.apache.ibatis.annotations.Param;
import resource.Usee;

import java.util.List;

public interface Dao {
//    分页查询
    List<Usee> selectPage(@Param("startPage") int startPage, @Param("pageSize") int pageSize);
    //    使用PageHelper
    List<Usee> selectAll();

}
