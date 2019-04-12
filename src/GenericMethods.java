import java.util.HashSet;
import java.util.Set;

/**
 *
 * {@link #union(Set, Set)}中没有使用泛型并且编译时会有两处warning.想要消除掉这两个warning，
 * 并让这个方法是类型安全的(typesafe)，可以修改其声明语句，加入一个类型参数以表示这三个Set中元素的类型，
 * 就像这样：{@link #union2(Set, Set)}
 *
 *
 *
 * @author LightDance
 * @date 2018/9/24
 */
public class GenericMethods {

    public static Set union(Set s1 , Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }


    public static<E> Set<E> union2(Set<E> s1 , Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>();
        guys.add("Tom");
        guys.add("Dick");
        guys.add("Dodo");
        guys.add("Garry");
        Set<String> stooges = new HashSet<>();
        stooges.add("Curly");
        stooges.add("Larry");
        stooges.add("Moe");
        stooges.add("Jenny");
        Set<String> aflCio = GenericMethods.union2(guys,stooges);

        System.out.println(aflCio);

    }
}
