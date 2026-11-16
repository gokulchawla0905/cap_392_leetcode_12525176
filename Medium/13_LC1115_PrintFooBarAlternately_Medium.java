
class FooBar {
    private int n;
    private boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!flag) {
                wait();
            }

            System.out.print("foo");
            flag = false;
            notifyAll();
        }
    }

    public synchronized void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag) {
                wait();
            }

            System.out.print("bar");
            flag = true;
            notifyAll();
        }
    }
}
