package many;

import java.util.List;

public interface Twomapper {
    List<Two> teacherById(int id);
    List<Two> studentStep(int id);
    List<Two> teacherCollection(int id);
    List<Two> teacherStep(int id);
}
