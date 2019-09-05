import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GG {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        String name = "root";
        GG gg = new GG();
        String encode = gg.bCryptPasswordEncoder.encode(name);
        System.out.println(encode);
    }
}
