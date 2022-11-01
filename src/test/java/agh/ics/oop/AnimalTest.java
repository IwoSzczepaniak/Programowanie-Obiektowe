package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    private static String test(String [] args) {
        Animal ssak = new Animal();
        OptionsParser joystic = new OptionsParser();
        MoveDirection [] moves = joystic.parse(args);
        int i;
        for(i=0; i< moves.length; i++) ssak.move(moves[i]);
        return ssak.toString();
    }
    @Test
    public void test1() {
        String [] tab = {"r","f","f","f"};
        String wyn = "(4,2),E";
        assertEquals(wyn, test(tab));
    }
    @Test
    public void test2() {
        String [] tab = {"f","f","f", "l", "f","f","f", "l", "f","f"};
        String wyn = "(0,2),S";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test3() {
        String [] tab = {"l"};
        String wyn = "(2,2),W";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test3_long() {
        String [] tab = {"left"};
        String wyn = "(2,2),W";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test4() {
        String [] tab = {"r"};
        String wyn = "(2,2),E";
        assertEquals(wyn, test(tab));
    }
    @Test
    public void test4_long() {
        String [] tab = {"right"};
        String wyn = "(2,2),E";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test5() {
        String [] tab = {"b"};
        String wyn = "(2,1),N";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test5_long() {
        String [] tab = {"backward"};
        String wyn = "(2,1),N";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test6() {
        String [] tab = {"f"};
        String wyn = "(2,3),N";
        assertEquals(wyn, test(tab));
    }

    @Test
    public void test6_long() {
        String [] tab = {"forward"};
        String wyn = "(2,3),N";
        assertEquals(wyn, test(tab));
    }


    @Test
    public void test7() {
        String [] tab = {"b", "b", "b", "b", "r", "f"};
        String wyn = "(3,0),E";
        assertEquals(wyn, test(tab));
    }
}
