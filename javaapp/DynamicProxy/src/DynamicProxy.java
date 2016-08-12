import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by optima1 on 2016/7/20.
 */
public class DynamicProxy {
    public static void main(String[] args){
        Object proxyInstance= Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{
                MyInterface.class
        }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sum")){
                    return (int)args[0]+(int)args[1];
                }else if (method.getName().equals("returnMySelf")){
                    return proxy;
                }
                return null;
            }
        });

        MyInterface myInterface=(MyInterface)proxyInstance;
        System.out.println(myInterface.sum(1,2));

    }

    public interface MyInterface{
        int sum(int arg1,int arg2);
        MyInterface returnMySelf();
    }

}
