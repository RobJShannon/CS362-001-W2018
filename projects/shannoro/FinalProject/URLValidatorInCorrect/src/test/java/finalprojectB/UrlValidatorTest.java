
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing
		UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		assertFalse(validator.isValid("\0"));
		assertTrue(validator.isValid("file:"));
		assertFalse(validator.isValid("http.com"));
		assertTrue(validator.isValid("http://www.google.com"));
		assertFalse(validator.isValid("http://www.google.com/invalid//invalid/"));
		assertTrue(validator.isValid("http://www.google.com/valid"));
		assertTrue(validator.isValid("http://www.google.com/~valid"));
		
		
		
		//Run similar tests to those above, however, this will test the code while 
		String[] schemes = {"http"};
		UrlValidator validator2 = new UrlValidator(schemes, null, UrlValidator.ALLOW_2_SLASHES);
		assertFalse(validator2.isValid("ftp://www.google.com"));
		assertTrue(validator2.isValid("http://www.google.com"));
		assertFalse(validator2.isValid("http://www.google.com/invalid///invalid/"));
		assertTrue(validator2.isValid("http://www.google.com/valid"));
		assertTrue(validator2.isValid("http://www.google.com/~valid"));
		assertTrue(validator2.isValid("http://www.google.com/@valid"));
		assertTrue(validator2.isValid("http://www.google.com/valid/valid"));
		assertFalse(validator2.isValid("http://www.google.com/####invalid####"));
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	 
		//First Partition test: scheme evaluation
		//Start by testing a URL that should work
		String[] schemes = {"http", "https"};
		UrlValidator validator = new UrlValidator(schemes, null, UrlValidator.ALLOW_2_SLASHES);
		String url = "http://www.google.com";
		assertTrue(validator.isValid(url));
		assertTrue(validator.isValid(url.replace("http", "https")));
		assertFalse(validator.isValid(url.replace("https", "HTTPS")));
		
		
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
		//Second Partition Test: path evaluation
		System.out.println("\n***BEGINNING RANDOM PATH TESTING***");
		UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		String url = "http://www.google.com";
		assertTrue(validator.isValid(url));
		Random rand = new Random();
		//These are valid characters
		String charsToTest = "abcdefghijklmnopqrstuvwxyz1234567890";
		//These are valid symbols
		String symbolsToTest = "-:@&?=+,.!~%$_;";
		
		//Create 25 test URLs
		for(int i = 0; i < 25; i ++){
			String newUrl = url + "/";
			//1 - 5 random characters to begin the path
			int numChars = rand.nextInt()%5 + 1;
			for(int j = 0; j < numChars; j++){
				newUrl += charsToTest.charAt(rand.nextInt(charsToTest.length()));
			}
			//Followed by a random symbol
			newUrl += symbolsToTest.charAt(rand.nextInt(symbolsToTest.length()));
			//And then up to 4 more characters
			numChars = rand.nextInt()%5;
			for(int j = 0; j < numChars; j++){
				newUrl += charsToTest.charAt(rand.nextInt(charsToTest.length()));
			}
			System.out.println("Testing: " + newUrl);
			assertTrue(validator.isValid(newUrl));
		}
		
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   
	   System.out.println("\n***BEGINNING PROGRAMMING BASED TESTING***");
	   UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
		String[] legalScheme = {"http://", "https://", "ftp://"};
		String[] illegalScheme = {"\0", "asdf"};
		String[] legalAuthority = {"www.google.com", "www.facebook.com", "www.amazon.com", "222.145.12.11"};
		String[] illegalAuthority = {"\0", "asdf.asdf.asdf", "111.200.3.45.56.62.117"};
		String[] legalPath = {"", "/thisisvalid", "/valid1/valid2/valid3"};
		String[] illegalPath = {"/../../..#/#/.."};
		
		String url = "";
		
		for( int i = 0; i < legalScheme.length; i++){
			for(int j = 0; j < legalAuthority.length; j++){
				for(int k = 0; k < legalPath.length; k++){
					url = legalScheme[i] + legalAuthority[j] + legalPath[k];
					System.out.println("Testing: " + url);
					assertTrue(validator.isValid(url));
				}
			}
		}
		
		for( int i = 0; i < legalScheme.length; i++){
			for(int j = 0; j < legalAuthority.length; j++){
				for(int k = 0; k < illegalPath.length; k++){
					url = legalScheme[i] + legalAuthority[j] + illegalPath[k];
					System.out.println("Testing: " + url);
					assertFalse(validator.isValid(url));
				}
			}
		}
		
		for( int i = 0; i < legalScheme.length; i++){
			for(int j = 0; j < illegalAuthority.length; j++){
				for(int k = 0; k < legalPath.length; k++){
					url = legalScheme[i] + illegalAuthority[j] + legalPath[k];
					System.out.println("Testing: " + url);
					assertFalse(validator.isValid(url));
				}
			}
		}
		
		for( int i = 0; i < illegalScheme.length; i++){
			for(int j = 0; j < legalAuthority.length; j++){
				for(int k = 0; k < legalPath.length; k++){
					url = illegalScheme[i] + legalAuthority[j] + legalPath[k];
					System.out.println("Testing: " + url);
					assertFalse(validator.isValid(url));
				}
			}
		}
   }
}
