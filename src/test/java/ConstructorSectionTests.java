import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorSectionTests extends BaseUiTest {

    @Test
    @DisplayName("Проверка открытия раздела 'Булки'.")
    public void checkingOpeningTheBurgerBunSection(){
        mainPage.open();
        mainPage.bunConstructionSectionClick();
        assertTrue(mainPage.isBunSectionOpen());
    }


    @Test
    @DisplayName("Проверка открытия раздела 'Соусы'.")
    public void checkingOpeningTheBurgerSaucesSection(){
        mainPage.open();
        mainPage.saucesConstructionSectionClick();
        assertTrue(mainPage.isSaucesSectionOpen());
    }

    @Test
    @DisplayName("Проверка открытия раздела 'Начинки'.")
    public void checkingOpeningTheBurgerFillingSection(){
        mainPage.open();
        mainPage.fillingConstructionSectionClick();
        assertTrue(mainPage.isFillingSectionOpen());
    }
}
