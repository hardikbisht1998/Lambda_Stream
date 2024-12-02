import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

//        OlderWay
        Walkable obj=new WalkFast();
        obj.walk(4);

        Walkable obj2=new Walkable() {
            @Override
            public int walk(int steps) {
                System.out.println("Walking more Faster"+steps+"Steps");
                return 4*steps;
            }
        };
        obj2.walk(6);

        Walkable obj3=(steps)->{
            System.out.println("Walking more Faster"+steps+"Steps");
            return 8*steps;
        };

        obj3.walk(9);

        obj3=(steps)->16*steps;


        List<String> fruits= List.of("Banana","Apple","Kiwi","Mango");

        Stream<String> stream=fruits.stream();
//        stream.forEach(System.out::println);
          stream.filter(x->x.length()<6)
                  .map(String::length)
                  .map(fruitlength->fruitlength*2)
                  .sorted()
                  .forEach(System.out::println);


        Map<String,Integer> reward=fruits.stream()
//                .map(x->x.length())
                .collect(Collectors.toMap(
                        fruit->fruit,
                        String::length));
        System.out.println(reward);

    }
}


@FunctionalInterface
interface Walkable{

    int walk(int steps);
}



class WalkFast implements Walkable{

    @Override
    public int walk(int steps) {
        System.out.println("Walking fast "+ steps + "Steps ");
        return 2*steps;
    }
}