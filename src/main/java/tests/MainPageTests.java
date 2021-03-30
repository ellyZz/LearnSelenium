package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{

    @Test
    public void createNewPaste(){
        mainPage.openPage();
        mainPage.writeTextInToNewPasteField("Hello world");
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField("Name");
        mainPage.pressCreateNewPasteButton();
        Assert.assertEquals(mainPage.searchSuccessNote(), "NOTE: Your guest paste has been posted. If you sign up for a free account, you can edit and delete your pastes!");
    }
}

