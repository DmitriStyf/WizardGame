public class Main {

    public static void main(String[] args) {

        //System.out.println("Dear user, please enter name and surname!");

        Wizard wizard = new Wizard("Dmitri", "Styf");
        System.out.println("Hello " + wizard.name + " " + wizard.surname);
    }
}

