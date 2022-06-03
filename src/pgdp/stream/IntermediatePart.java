package pgdp.stream;

import javax.xml.transform.Source;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.OptionalLong;

public abstract  class  IntermediatePart <IN, OUT> extends AbstractStreamPart <IN, OUT>  {
    private AbstractStreamPart <?, IN> x;
    public IntermediatePart (  AbstractStreamPart <?, IN> abstractStreamPart){
        this.x = abstractStreamPart;
    }
    public Source getSource (){
        return null;
    }

}