package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.rft.sandbox.Square;

/**
 * Created by RomanovaD on 15.05.2017.
 */
public class SquareTests {
    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25.0);
    }
}
