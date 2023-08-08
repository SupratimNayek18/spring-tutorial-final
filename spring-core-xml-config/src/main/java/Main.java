
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        UserService us = new UserService();
//
//        for (User user : us.getUserList()) {
//            System.out.println(user.getName());
//        }

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserService us = (UserService) context.getBean("userService");

        for(User user:us.getUserList()){
            System.out.println(user.getName());
        }

    }
}
