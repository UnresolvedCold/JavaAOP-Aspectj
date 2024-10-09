package codes.shubham.aop.play;

public aspect PlayAspectAj {
    pointcut log1() : call(public void helloWorld());
    pointcut log2() : call(public void helloWorld(String));
    pointcut logAll() : log1() ||
                        log2();
    before() : logAll() {
        System.out.println("Call From Aj Jointpoint");
    }
}