/**
 * Created by optima1 on 2016/8/11.
 */
public class AnnotationDemo {
    @AuthorAnno(name="zhao")
    public static void main(String[] args){
        System.out.print("main method");
    }
    @AuthorAnno(name="hello")
    public void demo(){
        System.out.print("demo method");
    }
}
