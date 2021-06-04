import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CLocalPicShow {
    private Object target;
    public CLocalPicShow(Object target){
        super();
        this.target=target;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("准备载入图片"+args);
                Thread thr = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            method.invoke(target,args);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thr.start();
                return null;
            }
        });
    }
}
