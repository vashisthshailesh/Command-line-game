public class test2 {
    @org.junit.Test(expected = VultureBiteException.class)
    public void testy2() throws Exception {
        tile x = new vulture(9);
        x.move();
    }
}
