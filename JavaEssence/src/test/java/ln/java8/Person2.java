package ln.java8;

public class Person2 {
  enum Gender {
    MALE, FEMALE
  }
  
  private Gender gender;
  
  private int age;

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
