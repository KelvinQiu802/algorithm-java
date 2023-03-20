import java.util.Iterator;

public interface ITree<T> extends Iterable<T> {
    IPosition<T> root();

    IPosition<T> parent(IPosition<T> p);

    Iterable<IPosition<T>> children(IPosition<T> p);

    int numChildren(IPosition<T> p);

    default boolean isExternal(IPosition<T> p) {
        return numChildren(p) == 0;
    }

    default boolean isInternal(IPosition<T> p) {
        return numChildren(p) > 0;
    }

    default boolean isRoot(IPosition<T> p) {
        return p == root();
    }

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    Iterator<T> iterator();

    Iterable<Position<T>> positions();
}