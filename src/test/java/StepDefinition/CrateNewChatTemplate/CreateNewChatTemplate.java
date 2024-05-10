package StepDefinition.CrateNewChatTemplate;
import StepDefinition.BaseClass.WebDriverSingleton;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CreateNewChatTemplate {


    private WebDriver driver;
    Actions action;

    @Before
    public void setUp() {
        // atau inisialisasi driver lainnya
        this.driver = WebDriverSingleton.getDriver();
    }

    @Given("User sudah login")
    public void userSudahLogin() {

        driver.get("https://qonek-uat.web.app/");
        driver.findElement(By.id("sign_in_text_input_email")).sendKeys("uattesting@gmail.com");
        driver.findElement(By.id("sign_in_text_input_password")).sendKeys("DevPassword381!");
        driver.findElement(By.id("sign_in_button_sign_in")).click();


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> driver.findElement(By.id("navmenu_navbtn_guidebook")).isDisplayed());

//        verify jika user sudah berhasil login
        Boolean LoggedInUser = driver.findElement(By.id("navmenu_navbtn_guidebook")).isDisplayed();

        assertTrue(LoggedInUser);
    }

    @And("User berada di halaman Chat Template")
    public void userBeradaDiHalamanChatTemplate() {
        driver.findElement(By.id("navmenu_navbtn_guidebook")).click();

//        verify jika user sudah berada di halaman chat template
        Boolean buttonChatTemplate = driver.findElement(By.id("sidebar_sidebartemplate_btn_template")).isDisplayed();
        assertTrue(buttonChatTemplate);

        String chatTemplateText = driver.findElement(By.id("sidebar_sidebartemplate_btn_template")).getText();
        assertEquals(chatTemplateText, "Chat Template");
    }

    @And("User belum pernah membuat Chat Template sebelumnya dan terdapat button “Create New Template”")
    public void userBelumPernahMembuatChatTemplateSebelumnyaDanTerdapatButtonCreateNewTemplate() {
        Boolean buttonCreateNewTemplate = driver.findElement(By.xpath("//p[normalize-space()='Create New Template']")).isDisplayed();
        assertTrue(buttonCreateNewTemplate);

        String neverCreateTemplate = driver.findElement(By.xpath("//h4[normalize-space()='There are no Chat Templates added yet']")).getText();
        assertEquals(neverCreateTemplate, "There are no Chat Templates added yet");
    }

    @When("User menekan button “Create New Template”")
    public void userMenekanButtonCreateNewTemplate() {
        driver.findElement(By.xpath("//p[normalize-space()='Create New Template']")).click();
    }

    @Then("Menampilkan pop-up Create New Chat Template")
    public void menampilkanPopUpCreateNewChatTemplate() {
//        cek title pop up
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> driver.findElement(By.className("BroadcastChatTemplate")).isDisplayed());

        String popUpTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[1]")).getText();
        assertEquals(popUpTitle, "Create New Chat Template");
    }

    @And("terbagi menjadi {int} bagian, yaitu bagian “Editorial Template” dan bagian “Preview Template”")
    public void terbagiMenjadiBagianYaituBagianEditorialTemplateDanBagianPreviewTemplate(int arg0) {
//        cek button widget jika muncul maka editorial template ada dan cek preview template
//        untuk kelengkapan editorial akan di cek di step bawahnya

        Boolean loadExistingButton = driver.findElement(By.id("addnewtemplatechat_btn_loadexisting")).isDisplayed();
        assertTrue(loadExistingButton);

        Boolean preview = driver.findElement(By.xpath("//div[@class='CardPreviewAddNewTemplate']")).isDisplayed();
        assertTrue(preview);
    }

    @And("pada bagian “Editorial Template” terdapat input form “Template Name” dan button “Load Existing” Box bubble chat {int} button “Add Bubble Chat” dan button “Wait For Second” Input form “Template Hotkey” \\(Defaultnya tergenerate oleh sistem)")
    public void padaBagianEditorialTemplateTerdapatInputFormTemplateNameDanButtonLoadExistingBoxBubbleChatButtonAddBubbleChatDanButtonWaitForSecondInputFormTemplateHotkeyDefaultnyaTergenerateOlehSistem(int arg0) {
//        cek widget template name
        Boolean templateName = driver.findElement(By.id("addnewtemplatechat_textinput_templatename")).isDisplayed();
        assertTrue(templateName);
//          cek button load existing
        Boolean loadExistingButton = driver.findElement(By.id("addnewtemplatechat_btn_loadexisting")).isDisplayed();
        assertTrue(loadExistingButton);
//        Box buble chat 1
        Boolean boxBubbleChat = driver.findElement(By.id("addnewtemplatechat_editorial_part")).isDisplayed();
        assertTrue(boxBubbleChat);
//        button add bubble chat
        Boolean addBuubleChat = driver.findElement(By.id("addnewtemplate_buble_btn_addbublechat")).isDisplayed();
        assertTrue(addBuubleChat);
//        button wait for a second
        Boolean waitForASecond = driver.findElement(By.id("addnewtemplate_buble_btn_waitforrespond")).isDisplayed();
        assertTrue(waitForASecond);
//        input form template hotkey
        Boolean templateHotKey = driver.findElement(By.id("inputlabel_textinput_hotkey")).isDisplayed();
        assertTrue(templateHotKey);

    }

    @And("pada bagian “Preview Template” akan menampilkan contoh pesan seperti pada Bubble chat yang telah ditambahkan")
    public void padaBagianPreviewTemplateAkanMenampilkanContohPesanSepertiPadaBubbleChatYangTelahDitambahkan() {
//        input bubble chat
        WebElement inputElement = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_1"));
        inputElement.click();
        System.out.println("click by ID");
        action = new Actions(driver);
        action.click(inputElement).sendKeys("Tester text").perform();
        System.out.println("text element by ID");
//        cek chat pada preview

        String textPreview = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_1")).getText();
        assertEquals(textPreview, "Tester text");
    }

    @And("pada kanan bawah pop-up terdapat button “Save Template”")
    public void padaKananBawahPopUpTerdapatButtonSaveTemplate() {
        Boolean buttonSaveTemplate = driver.findElement(By.id("addnewtemplate_buble_btn_createtemplate")).isDisplayed();
        assertTrue(buttonSaveTemplate);
    }

    @When("User klik dan mengetikkan “Promo produk” pada form Template Name")
    public void userKlikDanMengetikkanPromoProdukPadaFormTemplateName() {
        String templateName = "Promo produk";
        driver.findElement(By.id("addnewtemplatechat_textinput_templatename")).sendKeys(templateName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("Input form Template Name akan aktif dan terisi “Promo produk”")
    public void inputFormTemplateNameAkanAktifDanTerisiPromoProduk() {
        String validasiInput = "Promo produk";
        //        validasi input nya
        String afterInput = driver.findElement(By.id("addnewtemplatechat_textinput_templatename")).getAttribute("value");
        assertEquals(validasiInput, afterInput);
//        validasi aktifnya
        Boolean activeField = driver.findElement(By.id("addnewtemplatechat_textinput_templatename")).isEnabled();
        assertTrue(activeField);
    }

    @When("User klik dan mengetikkan “Promo produk terbaru tahun ini” pada form box Bubble Chat {int}")
    public void userKlikDanMengetikkanPromoProdukTerbaruTahunIniPadaFormBoxBubbleChat(int arg0) {
        String inputBubbleChat = "Promo produk terbaru tahun ini";
        action = new Actions(driver);
        WebElement bubbleChat = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_1"));
        action.click(bubbleChat)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        action.click(bubbleChat).sendKeys(inputBubbleChat).perform();
    }

    @Then("Box bubble chat {int} akan terisi pesan “Promo produk terbaru tahun ini”")
    public void boxBubbleChatAkanTerisiPesanPromoProdukTerbaruTahunIni(int arg0) {
        String validasiBubbleChat = "Promo produk terbaru tahun ini";
        String inputBubbleChatValidate = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_1")).getText();
        assertEquals(inputBubbleChatValidate,validasiBubbleChat);
    }

    @And("pada bagian Preview menampilkan bubble chat dengan pesan “Promo produk terbaru tahun ini”")
    public void padaBagianPreviewMenampilkanBubbleChatDenganPesanPromoProdukTerbaruTahunIni() {
        String validasiBubbleChat = "Promo produk terbaru tahun ini";
        String textPreview = driver.findElement(By.xpath("//p[@class='text']//div[contains(text(),'Promo produk terbaru tahun ini')]")).getText();
        assertEquals(textPreview, validasiBubbleChat);
    }

    @When("User klik button “Add Bubble Chat”")
    public void userKlikButtonAddBubbleChat() {
        driver.findElement(By.id("addnewtemplate_buble_btn_addbublechat")).click();
    }

    @Then("Akan muncul bubble chat baru pada bagian “Editorial Template”")
    public void akanMunculBubbleChatBaruPadaBagianEditorialTemplate() {
        Boolean newBubbleChat = driver.findElement(By.id("bublechat_reusable_btn_openorderbuble_addnewtemplate_buble_btn_3")).isDisplayed();
        assertTrue(newBubbleChat);
    }

    @When("User klik button “Add File”")
    public void userKlikButtonAddFile() {
//        click button file attachment
        driver.findElement(By.id("bublechat_reusable_quilltoolbar_selectfile_addnewtemplate_buble_btn_3")).click();
    }

    @And("klik pilihan “Image”")
    public void klikPilihanImage() {
        driver.findElement(By.id("bublechat_reusable_btn_selectimage_addnewtemplate_buble_btn_3")).click();
    }

    @And("user memilih image dari komputernya")
    public void userMemilihImageDariKomputernya() throws IOException {
        driver.findElement(By.id("inputFileImage")).sendKeys("D:\\Data C\\Pictures\\cat.jpg");
    }

    @Then("Image yang dipilih akan ditambahkan pada box bubble chat {int}")
    public void imageYangDipilihAkanDitambahkanPadaBoxBubbleChat(int arg0) {
        Boolean imageUploaded = driver.findElement(By.id("bublechat_reusable_image_addnewtemplate_buble_btn_3")).isDisplayed();
        assertTrue(imageUploaded);
    }

    @And("pada bagian Preview menampilkan bubble chat {int} dengan pesan “Image yang ditambahkan”")
    public void padaBagianPreviewMenampilkanBubbleChatDenganPesanImageYangDitambahkan(int arg0) {
        Boolean imageUploadedPreview = driver.findElement(By.xpath("//div[@id='1']//div//img")).isDisplayed();
        assertTrue(imageUploadedPreview);
    }

    @When("User klik dan mengetikkan “Produk {int}, potongan harga {int}ribu” pada form box Bubble Chat {int}")
    public void userKlikDanMengetikkanProdukPotonganHargaRibuPadaFormBoxBubbleChat(int arg0, int arg1, int arg2) {
        action = new Actions(driver);
        WebElement bubbleChat = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_3"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        bubbleChat.click();
        System.out.println("click by ID");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        action.click(bubbleChat).sendKeys("Produk 1, potongan harga 20ribu").perform();
        System.out.println("input text");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Then("Box bubble chat {int} akan terisi pesan “Produk {int}, potongan harga {int}ribu”")
    public void boxBubbleChatAkanTerisiPesanProdukPotonganHargaRibu(int arg0, int arg1, int arg2) {
        String validateBubbleChat = driver.findElement(By.id("bublechat_reusable_quillinput_addnewtemplate_buble_btn_3")).getText();
        assertEquals("Produk 1, potongan harga 20ribu", validateBubbleChat);
    }

    @And("pada bagian Preview menampilkan bubble chat {int} dengan pesan “[Image] + Produk {int}, potongan harga {int}ribu”")
    public void padaBagianPreviewMenampilkanBubbleChatDenganPesanImageProdukPotonganHargaRibu(int arg0, int arg1, int arg2) {
        String previewText = driver.findElement(By.xpath("//p[@class='text']//div[contains(text(),'Produk 1, potongan harga 20ribu')]")).getText();
        assertEquals(previewText, "Produk 1, potongan harga 20ribu");
    }

    @When("User klik dan mengetikkan “Promo{int}” pada form Template Hotkey")
    public void userKlikDanMengetikkanPromoPadaFormTemplateHotkey(int arg0) {
        action = new Actions(driver);
        WebElement bubbleChat = driver.findElement(By.id("inputlabel_textinput_hotkey"));
        action.click(bubbleChat)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        action.click(bubbleChat).sendKeys("Promo2024").perform();
    }

    @Then("Input form Template Hotkey akan aktif dan terisi “Promo{int}”")
    public void inputFormTemplateHotkeyAkanAktifDanTerisiPromo(int arg0) {
        String promoValue = driver.findElement(By.id("inputlabel_textinput_hotkey")).getAttribute("value");
        assertEquals(promoValue, "Promo2024");
    }

    @When("User klik button “Create Template”")
    public void userKlikButtonCreateTemplate() {
        driver.findElement(By.id("addnewtemplate_buble_btn_createtemplate")).click();
    }

    @Then("Pop-up akan tertutup")
    public void popUpAkanTertutup() {
        Boolean popUpDisabled = driver.findElement(By.xpath("//div[@class='ContactListPage_action']")).isDisplayed();
    }

    @And("template akan bertambah pada tabel daftar template dengan isi kolom <Template Name>, <Hotkey>, <Created Time>, dan <Guide Book>")
    public void templateAkanBertambahPadaTabelDaftarTemplateDenganIsiKolomTemplateNameHotkeyCreatedTimeDanGuideBook() {
        String templateName = driver.findElement(By.id("contactlist_bodytable_btn_3_0")).getText();
        assertEquals(templateName, "Promo produk");
    }

    @And("pada bagian kanan tabel akan terdapat kolom button “Edit” dan “Delete”")
    public void padaBagianKananTabelAkanTerdapatKolomButtonEditDanDelete() {
        Boolean buttonDelete = driver.findElement(By.id("chattemplate_page_btn_delete")).isDisplayed();
        Boolean buttonEdit = driver.findElement(By.id("chattemplate_page_btn_edit")).isDisplayed();

        assertTrue(buttonEdit);
        assertTrue(buttonDelete);
    }

}
