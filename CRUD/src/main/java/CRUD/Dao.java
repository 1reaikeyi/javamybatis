package CRUD;

import resource.Usee;

import java.util.List;

public interface Dao {
    int update(Usee usee);
    int delete(int id);
    int insert(Usee usee);
    Usee selectOne(int id);
    List<Usee> selectAll();

}
