package Spring_JDBC.Spring_JDBC.repo;

import Spring_JDBC.Spring_JDBC.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AlienRepo {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String query = "insert into alien(id,name,tech) values(?,?,?)";
        int rows = jdbcTemplate.update(query, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Alien added to the database");
        System.out.println(rows + " rows affected");
    }

    public List<Alien> findAll() {

        String query = "select * from alien";
        RowMapper<Alien> alien = (rs,n)->{
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            };

        List<Alien> list = jdbcTemplate.query(query, alien);
        return jdbcTemplate.query(query, alien);
    }
}
