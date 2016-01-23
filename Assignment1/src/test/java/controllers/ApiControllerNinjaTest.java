package controllers;

import ninja.NinjaTest;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ApiControllerNinjaTest extends NinjaTest
{
    @Test
    public void testDeckJsonGet()
    {
        String s = ninjaTestBrowser.makeJsonRequest("http://localhost:8080/deck.json");
        assertNotEquals(null,s);
    }
}
