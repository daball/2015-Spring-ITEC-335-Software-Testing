import static org.junit.Assert.*;

import org.junit.Test;


public class RowTest {

	@Test
	public void testRow() {
		//generate some cells and expectations
		String[] cells = new String[256];
		StringBuilder expectedString = new StringBuilder();
		for (int c = 0; c < 256; c++) {
			cells[c] = "Cell" + (c+1);
			if (c > 0)
				expectedString.append("~");
			expectedString.append(cells[c]);
		}
		assertFalse(expectedString.equals(""));
		
		//run tests
		Row row = new Row(cells);
		assertEquals(cells.length, row.columnCount());
		for (int i = 0; i < cells.length; i++) {
			assertEquals(row.get(i), cells[i]);
		}
		assertEquals(expectedString.toString(), row.toString());
	}

}
