public class DataProvider {
    @org.testng.annotations.DataProvider(name = "checkout data")
    public Object[][] registerOption() {
        return new Object[][]{
                {"Test", "ExerciseOne", "00000"}
        };
    }
}