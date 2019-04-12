import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * Java中，方法也可以设置并使用泛型，而且对于静态实用方法(static utility method)来说，
 * 经常通过泛型方法对其参数化类型进行操作。例如所有{@link java.util.Collections}中的，
 * 与算法相关的(algorithm)方法(例如{@link java.util.Collections#sort(List)}等)就都用了泛型。
 *
 * 编写泛型方法跟编写泛型类相似，例如这个使用原始类型的方法{@link GenericMethods#union(Set, Set)}
 *
 * 泛型方法中类型参数的声明在类修饰符与返回值类型之间，其命名规则与泛型类是相同的。
 * 对于简单的泛型方法来说，加完修饰符并对方法中类型稍作修改，就算全部完成了：没有warning，类型安全，
 * 简单易用。这里是对于简单泛型方法的简单使用：{@link GenericMethods#main(String[])}
 *
 * 上例中的一个小小局限之处在于，三个Set的类型参数必须相同，可以通过有限通配符设置类型参数，
 * 使之更加灵活。
 *
 * 有时，需要创建一个不可变(immutable)但适用多种不同类型的实例，由于泛型是通过擦除(见item28)实现的，
 * 所以可以只编写一个静态工厂方法，通过参数化类型，为每个请求的类型参数化分配对象。这种模式被称为
 * “泛型单例工厂”(generic singleton factory)，用于一些函数对象中(见item42)，例如
 * {@link Collections#emptySet()}
 *
 * 假如需要自己编写identity function dispenser(标识函数分发器？)，类库中提供了
 * {@link Function#identity()},这样就没必要自己重新实现一个了(见item59)，以免浪费时间。
 * 假设没有泛型，我们就需要为每一个类型分别实现一个identify方法，但出现泛型之后，就可以通过其擦除
 * (erasure)机制，一个方法适配所有类型。{@link IdentityFunctionDispenserClass}
 *
 * 虽然使用的比较少，但“类型参数 被方法本身所使用 而使用时又反过来限制了该类型参数”这种情况也是合法的。
 * 这就是“递归类型限定”(recursive type bound).其应用之一就是与{@link Comparable}相关方法的编写。
 * 因为Comparable接口通常要求仅能与和自身同类型的实例进行比较。
 * 很多带有集合的方法都实现了诸如排序、最值等基本方法，这些的实现需要集合中各个元素之间能够相互比较，
 * 这个类里面是如何描述这一需求{@link ApplicationWithComparable}
 *
 * 递归类型限定符有时很复杂、很难搞懂，但如果能够较深入地理解这个东西、它的通配符变体
 * (wildcard variant,见item31)以及"模拟自我类型(simulated self-type,见item2)"的话，
 * 就足以处理绝大多数递归类型限定符的例子。
 *
 *
 *
 * @author LightDance
 * @date 2018/9/24
 */
public class FavorGenericMethods {
}
