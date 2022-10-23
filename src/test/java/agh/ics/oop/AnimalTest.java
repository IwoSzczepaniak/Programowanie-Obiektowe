package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void test1() {
        String [] tab = {"r","f","f","f"};
        String wyn = "(4,2),Wschód";
        assertEquals(wyn, World.main(tab));
    }
    @Test
    public void test2() {
        String [] tab = {"f","f","f", "l", "f","f","f", "l", "f","f"};
        String wyn = "(0,2),Południe";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test3() {
        String [] tab = {"l"};
        String wyn = "(2,2),Zachód";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test3_long() {
        String [] tab = {"left"};
        String wyn = "(2,2),Zachód";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test4() {
        String [] tab = {"r"};
        String wyn = "(2,2),Wschód";
        assertEquals(wyn, World.main(tab));
    }
    @Test
    public void test4_long() {
        String [] tab = {"right"};
        String wyn = "(2,2),Wschód";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test5() {
        String [] tab = {"b"};
        String wyn = "(2,1),Północ";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test5_long() {
        String [] tab = {"backward"};
        String wyn = "(2,1),Północ";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test6() {
        String [] tab = {"f"};
        String wyn = "(2,3),Północ";
        assertEquals(wyn, World.main(tab));
    }

    @Test
    public void test6_long() {
        String [] tab = {"forward"};
        String wyn = "(2,3),Północ";
        assertEquals(wyn, World.main(tab));
    }


    @Test
    public void test7() {
        String [] tab = {"b", "b", "b", "b", "r", "f"};
        String wyn = "(3,0),Wschód";
        assertEquals(wyn, World.main(tab));
    }
}
