public class FrontendDeveloper extends Developer {


    @Override
    void drinkCoffee() {
        System.out.println("front drinkCoffee");
    }

    @Override
    void smoke() {
        System.out.println("front smoke");
    }

    public void developGUI() {
        System.out.println("front create GUI");
    }
}
