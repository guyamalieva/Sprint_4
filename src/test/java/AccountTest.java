import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Тимоти Шаламе", true},
                {"Ти", false},
                {"Т и", true},
                {"ТестовыйТимоти Шал", true},
                {" Тимоти Пробел", false},
                {"Шаламе Пробел ", false},
                {"ТимотиШаламе", false},
                {"Ти моти Шаламе", false},
                {"null", false}
        };
    }
    @Test
    public void checkNameTest(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(actual, expected);
    }
}