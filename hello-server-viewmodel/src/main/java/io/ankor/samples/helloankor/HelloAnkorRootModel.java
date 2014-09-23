package io.ankor.samples.helloankor;

import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.Ref;

public class HelloAnkorRootModel {

    private final Ref rootRef;

    public String helloWorld = "Hello World";
    public int count = 0;

    public HelloAnkorRootModel(Ref rootRef) {
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
