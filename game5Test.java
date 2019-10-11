import static org.junit.Assert.*;
import org.junit.runner.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
public class game5Test {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test(expected = snakeBiteException.class)
    public void start() throws
            Exception {
        tile s = new snake(5);
        s.move();
    }

    @org.junit.Test(expected = VultureBiteException.class)
    public void start2() throws Exception {
        tile x = new vulture(9);
        x.move();
    }

    @org.junit.Test(expected = CricketBiteException.class)
    public void start3() throws Exception {
        tile x = new cricket(9);
        x.move();
    }

    @org.junit.Test(expected = VultureBiteException.class)
    public void start4() throws Exception {
        tile x = new vulture(9);
        x.move();
    }

    @org.junit.Test(expected = TrampolineException.class)
    public void start5() throws Exception {
        tile x = new trampoline(9);
        x.move();
    }




}