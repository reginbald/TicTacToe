package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorldTest{
	@Test
	public void greetResultInHello(){
		World world = new World();
		assertEquals("Hello world!", world.greet());
	}
}
