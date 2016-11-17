package sec.simplebanking;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Client extends AbstractPersistable<Long> {

    private String name;

    // DO SOMETHING HERE
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
