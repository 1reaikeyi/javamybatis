package all;

import org.apache.ibatis.annotations.Param;
import resource.Usee;

import java.util.List;

public interface Dao {
    int deleteForeach(@Param("ids") List<Integer> ids);
    int insertForeach(@Param("list") List<Usee> list);
}
