package com.example.liukuo.responsibility;

/**
 * 责任链模式
 * <p>
 * 是一个请求有多个对象来处理，这些对象是一条链，但具体由哪个对象来处理，
 * 根据条件判断来确定，如果不能处理会传递给该链中的下一个对象，直到有对象处理它为止
 *
 * @author 67017
 */
public class Responsibility {
    public interface IThrow {
        void throwProblem(int type);
    }

    public static class ErrorDispose implements IThrow {
        private IThrow mThrow;

        @Override
        public void throwProblem(int type) {
            System.out.println("这个问题属于error级别的");
        }

        public void setmThrow(IThrow mThrow) {
            this.mThrow = mThrow;
        }
    }

    public static class WarnDispose implements IThrow {
        private IThrow mThrow;

        @Override
        public void throwProblem(int type) {
            if (type == 1) {
                System.out.println("这个问题属于warn级别的");
            } else {
                mThrow.throwProblem(type);
            }
        }

        public void setmThrow(IThrow mThrow) {
            this.mThrow = mThrow;
        }
    }

    public static class InfoDispose implements IThrow {
        private IThrow mThrow;

        @Override
        public void throwProblem(int type) {
            if (type == 0) {
                System.out.println("这个问题属于info级别的");
            } else {
                mThrow.throwProblem(type);
            }
        }

        public void setmThrow(IThrow mThrow) {
            this.mThrow = mThrow;
        }
    }

    public static void main(String[] args) {
        InfoDispose infoDispose = new InfoDispose();
        WarnDispose warnDispose = new WarnDispose();
        ErrorDispose errorDispose = new ErrorDispose();

        infoDispose.setmThrow(warnDispose);
        warnDispose.setmThrow(errorDispose);

        infoDispose.throwProblem(1);
    }
}
