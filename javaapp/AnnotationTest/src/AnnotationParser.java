import java.lang.reflect.Method;

/**
 * Created by optima1 on 2016/8/11.
 */
public class AnnotationParser {
    public static void main(String[] args) throws SecurityException,ClassNotFoundException{
        String clazz="AnnotationDemo";
        Method[] demoMethod=AnnotationParser.class.getClassLoader().loadClass(clazz).getMethods();
        for (Method method:demoMethod){
            if (method.isAnnotationPresent(AuthorAnno.class)){
                AuthorAnno authorInfo=method.getAnnotation(AuthorAnno.class);
                System.out.println("method"+method);
                System.out.println("name="+authorInfo.name()+",website="+authorInfo.website()+",reversion"+authorInfo.reversion());
            }
        }
    }
}
