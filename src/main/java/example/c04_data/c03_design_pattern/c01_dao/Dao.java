package example.c04_data.c03_design_pattern.c01_dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T> {
    List<T> getAll();
    Optional<T> get(int id);
    void update(T t) throws Exception;
}
