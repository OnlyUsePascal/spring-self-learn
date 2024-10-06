package example.c04_data.cc00_dao;

public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) throws Exception {
        if (name == null) throw new Exception("[!] name must not null");
        if (name.matches(".*\\d.*")) throw new Exception("[!] name must not have number");
        this.name = name;
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
