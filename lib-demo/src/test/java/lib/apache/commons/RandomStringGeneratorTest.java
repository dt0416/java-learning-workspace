package lib.apache.commons;

import static org.junit.Assert.*;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.junit.Test;

public class RandomStringGeneratorTest {

	@Test
	public void test() {
		RandomStringGenerator randomStringGenerator =
        new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build();
		System.out.println(randomStringGenerator.generate(16));
		System.out.println(randomStringGenerator.generate(12));
		System.out.println(randomStringGenerator.generate(12));
		System.out.println(randomStringGenerator.generate(12));
		System.out.println(randomStringGenerator.generate(12));
	}

}
