import java.io.IOException;

import static org.junit.Assert.*;
public class tst8 {
    @org.junit.Test
    public void checky() throws IOException, ClassNotFoundException {
        game5 x =new game5("lkj",800);
        game5.serialize(x);
        game5 y = lab_5.deserialize("lkj");
        assertEquals(x,y);
    }
}
