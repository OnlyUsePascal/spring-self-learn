package example.c03_mvc.c01_concept;

public class Controller {
    Model model;
    View view;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void showInfo() {
        Student student = model.getStudent();
        view.showInfo(student);
    }

    public void changeName(String name) {
        try {
            model.changeName(name);
            view.showUpdateStatus("[@] Update succeeded !");
        } catch (Exception e) {
            view.showError(e);
        }
    }
}
