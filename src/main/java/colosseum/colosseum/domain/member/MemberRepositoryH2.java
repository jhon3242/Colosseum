package colosseum.colosseum.domain.member;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


@Repository
public class MemberRepositoryH2 implements MemberRepository {

	private final JdbcTemplate template;
	private static Long sequence = 0L;

	public MemberRepositoryH2(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}


	@Override
	public Member save(Member user) {
		String sql = "insert into member (id, username) values(?, ?);"; // TODO add more data
		user.setId(++sequence);
		template.update(sql, user.getId(), user.getUsername());
		return user;
	}

	@Override
	public Member findById(Long id) {
		String sql = "select * from member where id = ?";
		return template.queryForObject(sql, memberRowMapper(), id);
	}

	private RowMapper<Member> memberRowMapper() {
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setUsername(rs.getString("username"));
			return member;
		};
	}

	@Override
	public Optional<Member> findByEmail(String email) {

		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return null;
	}

	@Override
	public void delete(Member member) {
		String sql = "delete from member where id = ?";
		template.update(sql, member.getId());
	}


}
