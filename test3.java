public class test3 {
    @org.junit.Test(expected = CricketBiteException.class)
    public void testy3() throws Exception {
        tile x = new cricket(9);
        x.move();
    }
}
