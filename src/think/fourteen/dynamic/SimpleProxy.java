package think.fourteen.dynamic;

class SimpleProxy implements Interface {

    private int callDoSomethingCount = 0;

    private int callSomethingElseCount = 0;

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
         this.proxied = proxied;
     }

    @Override
    public void doSomething() {
         System.out.println("Simple Proxy do something");
         callDoSomethingCount++;
         proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Simple Proxy some thing else " + arg);
        callSomethingElseCount++;
        proxied.somethingElse(arg);
    }

    public int getCallDoSomethingCount() {
        return callDoSomethingCount;
    }

    public int getCallSomethingElseCount() {
        return callSomethingElseCount;
    }
}
