package square;

import org.junit.Assert;
import org.junit.Test;

public class SquareRoot2Test {

	@Test
	public void testSquareRoot() {
		Assert.assertEquals(8f, SquareRoot2.squareRoot(64f), 0.01);
		Assert.assertEquals(8, SquareRoot2.squareRoot(64));	
		Assert.assertEquals(7f, SquareRoot2.squareRoot(49f), 0.01);
		Assert.assertEquals(7, SquareRoot2.squareRoot(49));
		Assert.assertEquals(6f, SquareRoot2.squareRoot(36f), 0.01);
		Assert.assertEquals(6, SquareRoot2.squareRoot(36));
		Assert.assertEquals(5f, SquareRoot2.squareRoot(25f), 0.01);
		Assert.assertEquals(5, SquareRoot2.squareRoot(25));
		Assert.assertEquals(4f, SquareRoot2.squareRoot(16f), 0.01);
		Assert.assertEquals(4, SquareRoot2.squareRoot(16));	
		Assert.assertEquals(3f, SquareRoot2.squareRoot(9f), 0.01);
		Assert.assertEquals(3, SquareRoot2.squareRoot(9));
		Assert.assertEquals(2f, SquareRoot2.squareRoot(4f), 0.01);
		Assert.assertEquals(2, SquareRoot2.squareRoot(4));
		Assert.assertEquals(1f, SquareRoot2.squareRoot(1f), 0.01);
		Assert.assertEquals(1, SquareRoot2.squareRoot(1));

	}

}
