package pgdp.stream;

public class SourcePart <T> extends AbstractStreamPart<T,T>{

    private StreamIterator <T> iterator;
    private StreamCharacteristics streamCharacteristics;

    public SourcePart(StreamIterator<T> iterator, StreamCharacteristics streamCharacteristics) {
        this.iterator = iterator;
        this.streamCharacteristics = streamCharacteristics;
    }

    @Override
    SourcePart<?> GetSource() {
        return this;
    }
    public void processStream(){
        StreamOperation operator = getStreamOperation();

        operator.start(streamCharacteristics);
        while(iterator.hasNext()) {
            if (operator.needsMoreElements())
                operator.acceptElement(iterator.next());
        }
        operator.finish();

    }
    public StreamOperation<T> getStreamOperation () {

        StreamOperation<T> streamOperation = new StreamOperation<T>() {
            @Override
            public void start(StreamCharacteristics upstreamCharacteristics) {
                if (next.getStreamOperation() != null) {
                    StreamOperation<T> LoveisLove = next.getStreamOperation();
                    LoveisLove.start(upstreamCharacteristics);
                }

            }

            @Override
            public void acceptElement(StreamElement<T> element) {
                if (next.getStreamOperation() != null) {
                    StreamOperation<T> tempNext = next.getStreamOperation();
                    acceptElement(element);
                }
            }

            @Override
            public void finish() {
                next.getStreamOperation().finish();
            }

            @Override
            public boolean needsMoreElements() {
                return !(next.getStreamOperation() == null) & next.getStreamOperation().needsMoreElements();
            }
        };
        return streamOperation;
    }
}
