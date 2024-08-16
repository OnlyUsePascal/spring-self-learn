package example.c04_data.c03_design_pattern.c01_dao;

public class Client {
    public static void main(String[] args) throws Exception {
        StudentDao studentDao = new StudentDao();

        System.out.println(studentDao.getAll());

        // update student
        int id = 1;
        Student student = studentDao.get(id)
                .orElseThrow(() -> new Exception("Cannot find student with id: " + id));
        student.setName("java");
        studentDao.update(student);

        System.out.println(studentDao.getAll());
    }
}
