package codetest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codetest.Snippety;


public class SnippetyTest {
	/**************************************************************************
	 * Test in case document is null or empty
	 *************************************************************************/
	@Test
	public void testHighlight1() {
		Snippety snippety = new Snippety();
		String query = "deep dish pizza";
		String document = null;
		String expected_snippet = "";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight2() {
		Snippety snippety = new Snippety();
		String query = "deep dish pizza";
		String document = "";
		String expected_snippet = "";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight3() {
		Snippety snippety = new Snippety();
		String query = "deep dish pizza";
		String document = "  \t\t";
		String expected_snippet = "";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}	
	@Test
	public void testHighlight4() {
		Snippety snippety = new Snippety();
		String query = "deep dish pizza";
		String document = "...........";
		String expected_snippet = "";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}	
	
	/**************************************************************************
	 * Test in case of query parameter is null or empty
	 *************************************************************************/
	@Test
	public void testHighlight5() {
		Snippety snippety = new Snippety();
		String query = null;
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like fish. Little star's deep dish pizza sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}



	@Test
	public void testHighlight6() {
		Snippety snippety = new Snippety();
		String query = "";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like fish. Little star's deep dish pizza sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}

	@Test
	public void testHighlight7() {
		Snippety snippety = new Snippety();
		String query = "  \t\t";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like fish. Little star's deep dish pizza sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}

	/**************************************************************************
	 * Test in case query words don't match with document words
	 *************************************************************************/
	@Test
	public void testHighlight8() {
		Snippety snippety = new Snippety();
		String query = "ABC";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like fish. Little star's deep dish pizza sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight9() {
		Snippety snippety = new Snippety();
		String query = "ABC";
		String document = "Little star's deep dish pizza sure is fantastic";
		String expected_snippet = "Little star's deep dish pizza sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}


	/**************************************************************************
	 * Tests in case of One Sentence in Document with one-word query
	 *************************************************************************/
	@Test
	public void testHighlight10() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "pizza";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "Little star's deep dish [[HIGHLIGHT]]pizza[[ENDHIGHLIGHT]] sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight11() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "little";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "[[HIGHLIGHT]]Little[[ENDHIGHLIGHT]] star's deep dish pizza sure is fantastic.";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight12() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "fantastic";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "Little star's deep dish pizza sure is [[HIGHLIGHT]]fantastic[[ENDHIGHLIGHT]].";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	/**************************************************************************
	 * Tests in case of One Sentence in Document with two-words query
	 *************************************************************************/
	@Test
	public void testHighlight13() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "fantastic pizza";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "Little star's deep dish [[HIGHLIGHT]]pizza[[ENDHIGHLIGHT]] sure is [[HIGHLIGHT]]fantastic[[ENDHIGHLIGHT]].";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight14() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "deep dish";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "Little star's [[HIGHLIGHT]]deep dish[[ENDHIGHLIGHT]] pizza sure is fantastic.";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight15() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "little star's";
		String document = "Little star's deep dish pizza sure is fantastic.";
		String expected_snippet = "[[HIGHLIGHT]]Little star's[[ENDHIGHLIGHT]] deep dish pizza sure is fantastic.";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	/**************************************************************************
	 * Tests in case of three sentence in document with a one-word query
	 *************************************************************************/
	@Test
	public void testHighlight16() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "pizza";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "Little star's deep dish [[HIGHLIGHT]]pizza[[ENDHIGHLIGHT]] sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight17() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "fish";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like [[HIGHLIGHT]]fish[[ENDHIGHLIGHT]].";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight18() {
		// one sentence in a document and one word in a query
		Snippety snippety = new Snippety();
		String query = "dogs";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "[[HIGHLIGHT]]Dogs[[ENDHIGHLIGHT]] are funny.";	
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	/**************************************************************************
	 * Tests in case of three sentence in document with a two-words query
	 *************************************************************************/
	@Test
	public void testHighlight19() {
		Snippety snippety = new Snippety();
		String query = "fish dogs";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like [[HIGHLIGHT]]fish[[ENDHIGHLIGHT]]. [[HIGHLIGHT]]Dogs[[ENDHIGHLIGHT]] are funny.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	/**************************************************************************
	 * Tests in case of three sentence in document with a one-word query
	 *************************************************************************/
	@Test
	public void testHighlight20() {
		Snippety snippety = new Snippety();
		String query = "deep dish pizza";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "Little star's [[HIGHLIGHT]]deep dish pizza[[ENDHIGHLIGHT]] sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight21() {
		Snippety snippety = new Snippety();
		String query = "fish pizza dogs";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "I like [[HIGHLIGHT]]fish[[ENDHIGHLIGHT]]. Little star's deep dish [[HIGHLIGHT]]pizza[[ENDHIGHLIGHT]] sure is fantastic.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight22() {
		Snippety snippety = new Snippety();
		String query = "little star's dogs";
		String document = "I like fish. Little star's deep dish pizza sure is fantastic. Dogs are funny.";
		String expected_snippet = "[[HIGHLIGHT]]Little star's[[ENDHIGHLIGHT]] deep dish pizza sure is fantastic. [[HIGHLIGHT]]Dogs[[ENDHIGHLIGHT]] are funny.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	/**************************************************************************
	 * Tests in case of long document sentence (> 100)
	 *************************************************************************/	
	@Test
	public void testHighlight23() {
		Snippety snippety = new Snippety();
		String query = "";
		String document = "This place probably suffered from overhype, as a lot of people have recommended it to me over the past year. I thought the sushi was good but not spectacular.  And I'm irritated by any place that requires a minimum 45 minute wait on a weeknight because it won't take reservations.  Basically, the food didn't justify the wait in my book.  Oh and for the love of god, don't bring a group here.  There was a group of 6 in line in front of us when we arrived -- they were still there when we left....";
		String expected_snippet = "This place probably suffered from overhype, as a lot of people have recommended it to me over the pa... I thought the sushi was good but not spectacular.";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
	@Test
	public void testHighlight24() {
		Snippety snippety = new Snippety();
		String query = "sushi";
		String document = "Please don't go here, it is not worth you waiting in line sometimes over an hour. Or at least that is that i hope as it is my favorite sushi spot in the city and maybe the best sushi i have had in a long time.";
		String expected_snippet = "Or at least that is that i hope as it is my favorite [[HIGHLIGHT]]sushi[[ENDHIGHLIGHT]] spot in the city and maybe the best [[HIGHLIGHT]]sushi[[ENDHIGHLIGHT]]...";
		String snippet = snippety.highlight(document, query);
		assertEquals(expected_snippet, snippet);
	}
}
