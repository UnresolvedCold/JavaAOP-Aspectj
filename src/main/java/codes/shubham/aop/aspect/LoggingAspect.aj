package codes.shubham.aop.aspect;

import codes.shubham.aop.items.IProduct;

public aspect LoggingAspect {
    pointcut logPriceChange() : call(public void IProduct.setPrice(int))
                                    && args(int)
                                    && target(IProduct);

    after(int price) : logPriceChange() && args(price) {
        // private fields cannot be accessed here
        String name = ((IProduct)(thisJoinPoint.getTarget())).getName();
        codes.shubham.aop.logging.PriceLogger.getInstance().log(name, price);
    }
}