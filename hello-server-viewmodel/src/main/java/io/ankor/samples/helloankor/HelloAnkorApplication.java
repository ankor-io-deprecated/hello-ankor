package io.ankor.samples.helloankor;

import at.irian.ankor.application.SimpleSingleRootApplication;
import at.irian.ankor.ref.Ref;

import java.util.Map;

public class HelloAnkorApplication extends SimpleSingleRootApplication {
    
    public HelloAnkorApplication() {
        super("Hello Ankor", "root");
    }

    @Override
    public Object createModel(Ref rootRef, Map<String, Object> connectParameters) {
        return new HelloAnkorRootModel(rootRef);
    }
}
