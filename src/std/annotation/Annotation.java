package std.annotation;

import java.lang.reflect.Method;

public class Annotation {
    public static void main(String[] args) {
        // 커스텀 annotation을 사용하려면
        // @interface로 생성한다. 'CustomAnnotation.java' 참조

        // @Retension : 어노테이션을 어느선까지 유지할 것인가
        // RetensionPolicy.RUNTIME : 프로그램을 실행할때도 계속 어노테이션을 하겠다는 뜻
        //                  java reflection을 활용할 수 있다. 
        // @Target : 어느부분에 적용할 것인가
        // ElementType.TYPE: 클래스에 적용
        // ElementType.METHOD: 에 적용 

        // java의 reflection api를 사용하면 아래와 같이 특정 메서드의
        // annotation을 검사하여 로직 처리하는 것이 가능하다. 
        Class clazz = Delivery.class;
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            for(java.lang.annotation.Annotation anno: method.getDeclaredAnnotations()) {
                if(anno.annotationType() == CustomAnnotation.class) {
                    IO.println(method.getName());
                } 
            }
        }
    }


}
