package codes.shubham.aop.boxset;

public aspect Aspect1 {
    pointcut titleChange() : call(* codes.shubham.aop.boxset.Boxset.setName(String))
                                && target(codes.shubham.aop.boxset.Boxset);

    before() : titleChange() {
        System.out.println("Before title change");
    }
}