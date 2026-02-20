package many;

import java.util.List;

public interface Onemapper {
    List<One> studentById(int id);
    List<One> studentStep(int id);
    List<One> teacherStep(int id);
}
