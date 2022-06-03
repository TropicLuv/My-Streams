package pgdp.stream;

import java.util.OptionalLong;

public final class StreamCharacteristics {

    private final OptionalLong streamSize;
    private final boolean isDistinct;
    private final boolean isChecked;

    public StreamCharacteristics(OptionalLong streamSize, boolean isDistinct, boolean isChecked) {
        this.streamSize = streamSize;
        this.isDistinct = isDistinct;
        this.isChecked = isChecked;
    }


    public OptionalLong getStreamSize (){
        return streamSize;
    }
    public boolean isDistinct(){
        return isDistinct;
    }
    public boolean isChecked (){
        return isChecked;
    }
    public static StreamCharacteristics regular() {
        return new StreamCharacteristics(OptionalLong.empty(), false, false);
    }

    public StreamCharacteristics WithStreamSize(OptionalLong x){
        return new StreamCharacteristics(x,this.isDistinct, this.isChecked());
    }
    public StreamCharacteristics withDistinct (boolean a){
        return new StreamCharacteristics(this.getStreamSize(),a, this.isChecked());
    }
    public StreamCharacteristics withChecked (boolean x){
        return new StreamCharacteristics(this.getStreamSize(),this.isDistinct, x);
    }
}
