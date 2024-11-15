package test.aatest;

public class Start {
    private MainMenu mainMenu;

    public static void main(String[] args) {
        new Start().showMainMenu();
    }

    public void showMainMenu() {
        mainMenu = new MainMenu();
        mainMenu.createAndShowGUI();
    }
}
