package map;

import org.apache.ibatis.annotations.MapKey;
import resource.Usee;

import java.util.List;
import java.util.Map;

public interface Dao {

    int deleteAll(String id);
    Usee selectOne(int id);
    List<Usee> selectList();
    Map<String,Object> selectOneMap();
    List<Map<String,Object>> selectListMap();
    @MapKey("id")
    Map<String,Map<Integer,Object>> selectMapMap();
    List<Usee> resultMap();

}
