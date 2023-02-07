
package work.jimmmy.javastudy.multithread.threadlocal;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class Service1 {
    public void process() {
        User user = new User("牛哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
        UserContextHolder.holder.remove(); // 帮助gc，避免value内存泄漏
    }
}

class Service2 {
    public void process() {
        System.out.println("Service2: " + UserContextHolder.holder.get().name);
        // UserContextHolder.holder.remove();
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        System.out.println(
            "Service3: " + (UserContextHolder.holder.get() == null ? null : UserContextHolder.holder.get().name));
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
