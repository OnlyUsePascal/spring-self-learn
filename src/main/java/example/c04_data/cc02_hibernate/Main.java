package example.c04_data.cc02_hibernate;

public class Main {

    public void exec() {
        new _Basics().execJpa();
        new _Transaction().execJpa();

        // new _Basics().execHibernate();
        // new _Transaction().execHibernate();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Main().exec();
    }
}