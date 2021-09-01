package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class t_position {
    private Integer id;
    private String pname;
    private Double minsal;
    private Double maxsal;
    private Date releasedate;
    private Integer cid;
}
