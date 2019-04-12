import java.util.Collection;
import java.util.Objects;

/**
 * 递归类型限定的使用示例，其中"<E extends Comparable<E>>"意为"任意实现了Comparable<E>接口，
 * 能够与自身比较的类型E"
 *
 * 这里当集合为空的时候会扔出异常，但其实更好的处理方式是返回一个{@link java.util.Optional}(见item55)
 *
 *
 * @author LightDance
 * @date 2018/9/26
 */
public class ApplicationWithComparable {
    /**
     * Returns max value in a collection - uses recursive type bound
     * @param collection 需要比较的元素所在的集合
     * @param <E> 实现了{@link Comparable}接口的元素类型
     * @return 该集合中的最大元素
     */
    public static <E extends Comparable<E>> E max(Collection<E> collection){
        if (collection.isEmpty()){
            throw new IllegalArgumentException("collection is empty!");
        }
        E result = null;
        for (E e :
                collection) {
            if (result == null || result.compareTo(e) < 0){
                Objects.requireNonNull(result = e);
            }
        }
        return result;
    }
}
