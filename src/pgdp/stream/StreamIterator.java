package pgdp.stream;

import java.util.*;

interface StreamIterator<T> {

    List allFiles = new ArrayList();


    public boolean hasNext();

    public StreamElement<T> next();

    public OptionalLong getSize();

    public static <T> StreamIterator<T> of(Collection<T> e) {
        return new StreamIterator<>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return e.iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                if(e.size() == 0) throw new NoSuchElementException();
                List<Exception> k = new ArrayList<>();
                return new StreamElement<>(e.iterator().next(), k);
            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(e.size());
            }
        };
    }

    public static <T> StreamIterator<T> of(Iterable<T> e) {
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return e.iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                List<Exception> exceptionList = new ArrayList<>();
                return new StreamElement<>(e.iterator().next(), exceptionList);
            }

            @Override
            public OptionalLong getSize() {
                int counter = 0;
                while (hasNext())
                    counter++;
                return OptionalLong.of(counter);
            }
        };
    }

    public static <T> StreamIterator<T> of(T[] arr) {
        return new StreamIterator<T>() {
            int count = 0;
            @Override
            public boolean hasNext() {

                return count == arr.length;
            }

            @Override
            public StreamElement<T> next() {
                if(count != arr.length) {
                    count++;
                    List<Exception> exceptionList = new ArrayList<>();
                    return new StreamElement<>(arr[count], exceptionList);
                }else throw new NoSuchElementException();

            }

            @Override
            public OptionalLong getSize() {
                return OptionalLong.of(arr.length);
            }
        };
    }

    static <T> StreamIterator<T> of(java.util.stream.Stream<T> e) {
        return new StreamIterator<T>() {
            @Override
            public boolean hasNext() {
                return e.iterator().hasNext();
            }

            @Override
            public StreamElement<T> next() {
                if (!e.iterator().hasNext()) throw new NoSuchElementException();

                List<Exception> exceptionList = new ArrayList<>();
                return new StreamElement<>(e.iterator().next(), exceptionList);
            }

            @Override
            public OptionalLong getSize() {
                int counter = 0;
                while (hasNext())
                    counter++;
                return OptionalLong.of(counter);
            }
        };
    }

}
