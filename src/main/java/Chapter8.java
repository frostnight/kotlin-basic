import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Chapter8 {

    public static void main(String[] args){
//        Chapter8Kt.processTheAnswer(number -> number + 1);
//        Chapter8Kt.processTheAnswer(
//                new Function1<Integer, Integer>(){
//                    @Override
//                    public Integer invoke(Integer number) {
//                        System.out.println("number = " + number);
//                        return number + 1;
//                    }
//                });

        List<String> strings = new ArrayList<>();
        strings.add("42");
        CollectionsKt.forEach(strings, s -> {
            System.out.println("s = " + s);
            return Unit.INSTANCE;
        });
    }
}
