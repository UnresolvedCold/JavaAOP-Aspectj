package codes.shubham.aop.boxset;

public aspect Aspect1 {
    pointcut titleChange() : call(* codes.shubham.aop.boxset.Boxset.setName(String))
                                && target(codes.shubham.aop.boxset.Boxset);

    pointcut constructSet() : initialization(Boxset.new(String));


    before() : titleChange() {
        System.out.println("Before title change");
    }

    after(): constructSet() {
        System.out.println("After construction");
    }
}