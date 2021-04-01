package tests;


import org.testng.annotations.Test;

public class MainPageTests extends BaseTest {

    @Test
    public void createNewPaste() {
        mainPage.openPage();
        mainPage.writeTextInToNewPasteField("Hello world");
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField("Name");
        mainPage.pressCreateNewPasteButton();

    }
}

