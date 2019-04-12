import java.util.function.UnaryOperator;

/**
 * {@link #identityFunction()}中从IDENTITY_FN到UnaryOperator<T>的转换会在编译时提示warning，
 * 因为未必对所有T来说，都存在UnaryOperator<Object>即是UnaryOperator<T>. 但是identify方法比较特殊，
 * 它并不处理，只是返回其参数，因此无论T是什么类型，将它视为UnaryOperator<T>使用都能够保证类型安全。
 * 因此，这里使用@SuppressWarning注解抑制了warning提示。其应用示例如下{@link #main(String[])}
 *
 * （存疑，无法理解为什么强转是安全的，待深入学习）
 *
 * @author LightDance
 * @date 2018/9/24
 */
public class IdentityFunctionDispenserClass {

    // Generic singleton factory pattern

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    //？？
    //@SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }
        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }
}
