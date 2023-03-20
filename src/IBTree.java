import java.util.ArrayList;
import java.util.List;

public interface IBTree<T> extends ITree<T> {
    IPosition<T> left(IPosition<T> p);

    IPosition<T> right(IPosition<T> p);

    default IPosition<T> sibling(IPosition<T> p) {
        IPosition<T> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    @Override
    default int numChildren(IPosition<T> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    @Override
    default Iterable<IPosition<T>> children(IPosition<T> p) {
        List<IPosition<T>> lst = new ArrayList<>(2);
        IPosition<T> leftPos = left(p);
        IPosition<T> rightPos = right(p);
        if (leftPos != null) {
            lst.add(leftPos);
        }
        if (rightPos != null) {
            lst.add(rightPos);
        }
        return lst;
    }
}
