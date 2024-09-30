package example.c00_design_patterns.c01_dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T> {
    List<T> getAll();
    Optional<T> get(int id);
    void update(T t) throws Exception;
}
