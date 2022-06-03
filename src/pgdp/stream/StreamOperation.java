package pgdp.stream;

public interface StreamOperation<T> {

    public void start(StreamCharacteristics upstreamCharacteristics);

    public void acceptElement(StreamElement<T> element);

    public void finish();

    public boolean needsMoreElements();

}
