public class fts {
    @org.junit.Test(expected = GameWinnerException.class)
    public void start6() throws Exception {
        game5 x = new game5("homooo" ,567);
        x.start();
    }
}
