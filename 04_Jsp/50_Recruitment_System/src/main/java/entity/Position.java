package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private Integer pid;
    private String pname;
    private Double minsal;
    private Double maxsal;
    private Date releasedate;
    private String loc;
    private String cname;
    private Integer cid;

    public Position(String pname, Double minsal, Double maxsal, Date date, Integer cid) {
        this.pname = pname;
        this.minsal = minsal;
        this.maxsal = maxsal;
        this.releasedate = date;
        this.cid = cid;
    }
}
