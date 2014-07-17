define([
    "ankor/AnkorSystem",
    "ankor/transport/WebSocketTransport",
    "ankor/utils/BaseUtils"
], function (AnkorSystem, WebSocketTransport, BaseUtils) {
    var ankorClient = new AnkorSystem({
        modelId: "root",
        utils: new BaseUtils(),
        transport: new WebSocketTransport("/websocket/ankor", {
            connectProperty: "root"
        })
    });
    
    var rootRef = ankorClient.getRef("root");
    
    rootRef.addPropChangeListener(function() {
        var helloWorldRef = rootRef.appendPath("helloWorld");
        var countRef = rootRef.appendPath("count");

        var helloWorldNode = document.getElementById("helloWorld");
        helloWorldNode.style.display = '';
        
        var countNode = document.getElementById("count");
        countNode.style.display = '';

        helloWorldNode.addEventListener("keyup", function () {
            helloWorldRef.setValue(helloWorldNode.value);
        });

        countRef.addPropChangeListener(function (ref) {
            countNode.textContent = countRef.getValue();
        });
    });
});
