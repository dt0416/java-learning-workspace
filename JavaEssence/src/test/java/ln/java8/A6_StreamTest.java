package ln.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * 
 * @author Ian Chen
 */
public class A6_StreamTest {

  @Test
  public void testFileStream() throws IOException {
    String fileName =
        "/Users/ianlocal/Documents/java-learning-workspace/JavaEssence/src/test/java/ln/java8/StreamTest.txt";
    String prefix = "abc";

    long startTime = System.currentTimeMillis();
    // 1.7以前使用方法
    String firstMatchdLine = "no matched line";
    for (String line : Files.readAllLines(Paths.get(fileName))) {
        if(line.startsWith(prefix)) {
            firstMatchdLine = line;
            break;
        }
    }
    System.out.println(firstMatchdLine);
    System.out.println("performance(" + (System.currentTimeMillis() - startTime) + "ms)");
    
    startTime = System.currentTimeMillis();
    // 1.8使用Stream
    Optional<String> firstMatchdLineOption =
        Files.lines(Paths.get(fileName)).filter(line -> line.startsWith(prefix)).findFirst();
    System.out.println(firstMatchdLineOption.orElse("no matched line"));
    System.out.println("performance(" + (System.currentTimeMillis() - startTime) + "ms)");
  }

  @Test
  public void testSum() {
    List<Person2> persons = new ArrayList<>();
    Person2 p = new Person2();
    p.setGender(Person2.Gender.MALE);
    p.setAge(18);
    persons.add(p);
    Person2 p2 = new Person2();
    p2.setGender(Person2.Gender.FEMALE);
    p2.setAge(20);
    persons.add(p2);
    int sum = persons.stream()
        .filter(person -> person.getGender() == Person2.Gender.MALE)
        .mapToInt(Person2::getAge)
        .sum();
    System.out.println(sum);
  }
  
  @Test
  public void testReduce() {
    List<Person2> persons = new ArrayList<>();
    Person2 p = new Person2();
    p.setGender(Person2.Gender.MALE);
    p.setAge(18);
    persons.add(p);
    Person2 p2 = new Person2();
    p2.setGender(Person2.Gender.MALE);
    p2.setAge(20);
    persons.add(p2);
    int sum = persons.stream()
        .filter(person -> person.getGender() == Person2.Gender.MALE)
        .mapToInt(Person2::getAge)
        .reduce((total, age) ->  total + age)
        .getAsInt();
    System.out.println(sum);
  }
  
  @Test
  public void testMaxWithReduce() {
    List<Person2> persons = new ArrayList<>();
    Person2 p = new Person2();
    p.setGender(Person2.Gender.MALE);
    p.setAge(18);
    persons.add(p);
    Person2 p2 = new Person2();
    p2.setGender(Person2.Gender.MALE);
    p2.setAge(20);
    persons.add(p2);
    int max = persons.stream()
        .filter(person -> person.getGender() == Person2.Gender.MALE)
        .mapToInt(Person2::getAge)
        .reduce(0, (currentMax, age) -> age > currentMax ? age : currentMax);
        
    System.out.println(max);
  }
  
  @Test
  public void testToList() {
    List<Person2> persons = new ArrayList<>();
    Person2 p = new Person2();
    p.setGender(Person2.Gender.MALE);
    p.setAge(18);
    persons.add(p);
    Person2 p2 = new Person2();
    p2.setGender(Person2.Gender.MALE);
    p2.setAge(20);
    persons.add(p2);
    List<Person2> males = persons.stream()
        .filter(person -> person.getGender() == Person2.Gender.MALE)
        .collect(Collectors.toList()); // toList() 是 java.util.stream.Collectors 的靜態方法
    System.out.println(males.size()); // 2
  }
  
}
