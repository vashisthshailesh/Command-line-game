public class test5 {

    @org.junit.Test(expected = TrampolineException.class)
    public void testy5() throws Exception {
        tile x = new trampoline(9);
        x.move();
    }
}
