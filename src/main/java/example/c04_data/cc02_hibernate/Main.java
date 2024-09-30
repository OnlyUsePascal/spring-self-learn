package example.c04_data.cc02_hibernate;

public class Main {

    public void exec() {
        // new _Basics().execHibernate();
        // new _Transaction().execHibernate();

        new _Basics().execJpa();
        new _Transaction().execJpa();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Main().exec();
    }
}