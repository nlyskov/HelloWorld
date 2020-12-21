package lesson5;

public class ClassTest {
    public String instanceName;
    public boolean result;
    public int param1;
    public int param2;
    public int failedTestCounter;


    public ClassTest(int param1, int param2, String instanceName) {
        this.instanceName = instanceName;
        this.param1 = param1;
        this.param2 = param2;
    }

    @Before
    public void methodBefore() {
        System.out.printf("Секция Before для: %s%n", instanceName);
    }

    @Test
    public void methodTest1() {
        try {
            System.out.printf("Результат запуска %s равен: %s%n", instanceName, param1 > param2);
        }
        catch (RuntimeException e) {
            System.out.printf("Внимание! %s упал с ошибкой %s%n", instanceName, e);
            failedTestCounter++;
        }
    }

    @Test
    public void methodTest2() {
        try {
            System.out.printf("Результат запуска %s равен: %s%n", instanceName, param1 < param2);
            throw new RuntimeException();
        }
        catch (RuntimeException e) {
            System.out.printf("Внимание! %s упал с ошибкой %s%n", instanceName, e);
            failedTestCounter++;
        }
    }

    @Test
    public void methodTest3() {
        try {
            System.out.printf("Результат запуска %s равен: %s%n", instanceName, param1 < param2);
        }
        catch (RuntimeException e) {
            System.out.printf("Внимание! %s упал с ошибкой %s%n", instanceName, e);
            failedTestCounter++;
        }
    }

    @After
    public int methodAfter() {
        System.out.printf("Секция After для: %s%n", instanceName);
        return failedTestCounter;
    }


}

