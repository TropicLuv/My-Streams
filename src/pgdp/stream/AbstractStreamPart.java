package pgdp.stream;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class AbstractStreamPart <IN,OUT> implements Stream<IN>, StreamOperable<OUT> {

    public StreamOperable <OUT> next = null;


    public void setNext (StreamOperable <OUT> setNext){
        if(next == null)
            this.next = setNext;
        else
            throw new IllegalStateException();
    }
    abstract SourcePart <?> GetSource ();

    @Override
    public <R> Stream<R> map(Function<? super IN, ? extends R> mapper) {
        return null;
    }

    @Override
    public Stream<IN> filter(Predicate<? super IN> filter) {
        return null;
    }

    @Override
    public <R> Stream<R> mapChecked(ThrowingFunction<? super IN, ? extends R> mapper) {
        return null;
    }

    @Override
    public Stream<IN> filterChecked(ThrowingPredicate<? super IN> filter) {
        return null;
    }

    @Override
    public Stream<IN> distinct() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<IN> findFirst() {
        return Optional.empty();
    }

    @Override
    public Optional<IN> reduce(BinaryOperator<IN> accumulator) {
        return Optional.empty();
    }

    @Override
    public Collection<IN> toCollection(Supplier<? extends Collection<IN>> collectionGenerator) {
        return null;
    }

    @Override
    public Stream<IN> onErrorMap(Function<? super List<Exception>, ? extends IN> errorMapper) {
        return null;
    }

    @Override
    public Stream<IN> onErrorMapChecked(ThrowingFunction<? super List<Exception>, ? extends IN> errorMapper) {
        return null;
    }

    @Override
    public Stream<IN> onErrorFilter() {
        return null;
    }


}
