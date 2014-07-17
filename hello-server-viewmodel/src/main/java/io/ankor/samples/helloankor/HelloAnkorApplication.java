package io.ankor.samples.helloankor;

import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.application.SimpleSingleRootApplication;
import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.Ref;

import java.util.Map;

public class HelloAnkorApplication extends SimpleSingleRootApplication {
    
    public HelloAnkorApplication() {
        super("Hello Ankor", "root");
    }

    @Override
    public Object createModel(Ref rootRef, Map<String, Object> connectParameters) {
        return new RootModel(rootRef);
    }
    
    public class RootModel {

        private final Ref rootRef;
        
        public String helloWorld = "Hello World";
        public int count = 0;
        
        public RootModel(Ref rootRef) {
            AnkorPatterns.initViewModel(this, rootRef);
            this.rootRef = rootRef;
        }
        
        @ChangeListener(pattern = "root.helloWorld")
        public void onHelloWorldChanged() {
            rootRef.appendPath("count").setValue(count + 1);
        }

        public String getHelloWorld() {
            return helloWorld;
        }

        public void setHelloWorld(String helloWorld) {
            this.helloWorld = helloWorld;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
