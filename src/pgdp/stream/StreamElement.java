package pgdp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class StreamElement <T> {

    private final T element;
    private final List<Exception> listExceptions;
    private boolean isRegular;



    public StreamElement(T element, List<Exception> listExceptions) {
        this.element = element;
        this.listExceptions = listExceptions;
        if(listExceptions.size() != 0)
            this.isRegular = false;
    }

    public List<Exception> getListExceptions() {
        return listExceptions;
    }

    public T getElement (){
        return element;
    }


    public boolean hasExceptions (){
        return !(listExceptions.size() == 0);
    }


    public <R> StreamElement <R> withExceptionAdded (Exception exc){
        listExceptions.add(exc);
        return new StreamElement<R>(null, listExceptions);
    }
    public <R> StreamElement <R> tryAdapt () throws CheckedStreamException {
        if (!isRegular)
            return new StreamElement<>(null,listExceptions);
        else throw new CheckedStreamException();
    }
    public static <T> StreamElement <T> of (T t){
        List<Exception> list = new ArrayList<>();
        return new StreamElement<>(t,list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamElement<?> that = (StreamElement<?>) o;
        return isRegular == that.isRegular && Objects.equals(getElement(), that.getElement()) && Objects.equals(listExceptions, that.listExceptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement());
    }
}
