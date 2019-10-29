package pt.dockoder.secureserver.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Data
public class Security {

    private  String password;
    private Boolean enabled;
    private Boolean expired;
    private Boolean locked;
    private Set<String> roles;

    @Autowired
    public Security(String password, Boolean enabled, Boolean expired, Boolean locked, Set<String> roles) {
        this.password = password;
        this.enabled = enabled;
        this.expired = expired;
        this.locked = locked;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Security{password='" + password + '\'' + ", enabled=" + enabled +
                ", expired=" + expired + ", locked=" + locked + ", roles=" + roles + '}';
    }

}
