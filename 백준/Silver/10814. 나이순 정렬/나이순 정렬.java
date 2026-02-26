import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person{
    String name;
    int age;

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        arr.sort((a, b) -> Integer.compare(a.age, b.age));
        for(int i = 0; i < n; i++){
            System.out.println(arr.get(i).age + " " + arr.get(i).name);
        }
    }
}
