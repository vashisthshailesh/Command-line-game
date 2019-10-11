public class test4 {
    @org.junit.Test(expected = VultureBiteException.class)
    public void testy4() throws Exception {
        tile x = new vulture(9);
        x.move();
    }
}
