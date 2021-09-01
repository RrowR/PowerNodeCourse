package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TcompanyPosition {
    private String pname;
    private String cname;
    private Double minsal;
    private Double maxsal;
    private String loc;
    private Date releasedate;
}
