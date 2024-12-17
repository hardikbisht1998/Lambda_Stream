package streamOperation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    public void letStart(){
        List<Integer> number= Arrays.asList(1,2,3,4,11,5,-89,54,63,3,64,128,21,12,-23,2,4,5);
//1)     Sum of all number

        Stream<Integer> stream=number.stream();
        Optional<Integer> sum=stream.reduce((a, b)->a+b);
        System.out.println("Sum of all the number : "+sum.get());

//2)     print average of all number
        Double average=number.stream().mapToInt(e->e).average().getAsDouble();
        System.out.println("Avg of all the number : "+average);

//3)    square it - filter it <100 - average it
        Double afterOperation=number.stream()
                .map(x->x*x)
                .filter(x->x>100)
                .mapToInt(x->x)
                .average()
                .getAsDouble();
        System.out.println("After operation of all the number : "+afterOperation);

//4)   print even number and odd number using stream
        List<Integer> even=number.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println("List of all even the number : "+even);
        List<Integer> odd=number.stream().filter(x->x%2!=0).collect(Collectors.toList());
        System.out.println("List of all odd the number : "+odd);


//5)  print no. start with prefix 2 only

        List<Integer> startWith2=number.stream().map(e->String.valueOf(e)).filter(e->e.startsWith("2")||e.startsWith("-2")).map(e->Integer.valueOf(e)).collect(Collectors.toList());
        System.out.println("List of all the number start with 2 : "+startWith2);

//6)  find the duplicate number
        Set<Integer> setNumber=number.stream().filter(e-> Collections.frequency(number,e)>1).collect(Collectors.toSet());
        System.out.println("Set of duplicate number : "+setNumber);

        Set<Integer> dupNumber=new HashSet<>();
        Set<Integer> dup=number.stream().filter(e->!dupNumber.add(e)).collect(Collectors.toSet());
        System.out.println("Set of duplicate number : "+dup);

//7)  find max and min number
        int max=number.stream().max(Comparator.comparing(x->x)).get();
        System.out.println("Value of maximum number from stream : "+ max);

        int min =number.stream().min(Comparator.comparing(x->x)).get();
        System.out.println("Value of minimum number from stream : "+ min);

//8)    Sort the number in asc and desc
        List<Integer> sort=number.stream().sorted().collect(Collectors.toList());
        System.out.println("Value of sortef number from stream : "+ sort);

        List<Integer> deSort=number.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Value of sortef number from stream : "+ deSort);


//9)    get first five number

        List<Integer> l=number.stream().limit(5).collect(Collectors.toList());
        System.out.println("list of first five number "+ l);

        int sum2=l.stream().reduce((x,y)->x+y).get();
        System.out.println("Sum of first five number "+ sum2);


        List<Integer> m=number.stream().skip(5).collect(Collectors.toList());
        System.out.println("list of other than first five number "+ m);

        int sum3=m.stream().reduce((x,y)->x+y).get();
        System.out.println("Sum of other than first five number "+ sum3);

//10)   second highest and lowest number

        int secondHighest=number.stream().sorted(Comparator.reverseOrder()).distinct().limit(2).skip(1).findFirst().get();
        System.out.println("Second highest "+ secondHighest);

    }
}
