package com.epishkin.cci.random;

public class FunctionsMagic {
    public interface Function<A,B>{
        B apply(A x);

        Function<A, B> andThen(Function<B, B> function);
    }

    abstract class BaseFunction<A, B> implements Function<A, B> {
        @Override
        public Function<A, B> andThen(Function<B, B> function) {
            return new CompositeFunction<A, B>(this, function);
        }
    }

    class CompositeFunction<A, B> extends BaseFunction<A, B> {
        private Function<A, B> inner;
        private Function<B, B> outer;

        CompositeFunction(Function<A, B> inner, Function<B, B> outer) {
            this.inner = inner;
            this.outer = outer;
        }

        @Override
        public B apply(A x) {
            return outer.apply(inner.apply(x));
        }
    }

    public Function<Integer,Integer> increment5I = new BaseFunction<Integer,Integer>(){
        @Override public Integer apply(Integer i){
            if(i == null)
                return 0;
            else
                return i+5;
        }
    };

    public Function<Integer,Integer> squareI = new BaseFunction<Integer,Integer>(){
        @Override public Integer apply(Integer i){
            if(i==null)
                return 0;
            else
                return i*i;
        }
    };
}
